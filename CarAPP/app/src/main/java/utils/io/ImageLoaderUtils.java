package utils.io;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * @description 获取 ImageOptions
 * @author Ly
 * @email 1522651962@qq.com
 * @time 2014-10-4上午10:40:26
 */
public class ImageLoaderUtils {

	private static ImageLoaderUtils imageOptions = new ImageLoaderUtils();
	DisplayImageOptions options;
	private ImageLoadingListener animateFirstListener;

	private ImageLoaderUtils() {

	}

	/**初始化imageloader 放在application 中初始化一次
	 * @param context
	 */
	public  static void init(Context context){
		// method.
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
				.threadPriority(Thread.NORM_PRIORITY )
				.memoryCacheExtraOptions(480, 800) // maxwidth, max height，即保存的每个缓存文件的最大长宽
				.threadPoolSize(3)//线程池内加载的数量
				.denyCacheImageMultipleSizesInMemory()
				.memoryCache(new WeakMemoryCache())
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				.diskCacheSize(100 * 1024 * 1024) // 50 Mb
				.tasksProcessingOrder(QueueProcessingType.FIFO)
				.writeDebugLogs() // Remove for release app
				.build();
		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);

	}



		public static ImageLoaderUtils getInstance() {
		return imageOptions;
	}

	/**
	 * @function 获取imageoptions
	 * @time 2014-10-4上午10:46:51
	 * @param isCacheInMemory
	 * @param isCacheOnDisk
	 * @param round
	 * @return DisplayImageOptions
	 */
	public DisplayImageOptions getOptions(boolean isCacheInMemory,
			boolean isCacheOnDisk, int round) {

		options = new DisplayImageOptions.Builder()
				.cacheInMemory(isCacheInMemory)
				.cacheOnDisk(isCacheOnDisk).bitmapConfig(Config.RGB_565)
				.considerExifParams(true).displayer(new BitmapDisplayer() {

					@Override
					public void display(Bitmap arg0, ImageAware arg1,
							LoadedFrom arg2) {
						// TODO Auto-generated method stub
						// arg0=Bitmap.createBitmap(50,50,Config.RGB_565);
						arg1.setImageBitmap(arg0);
					}
				}).imageScaleType(ImageScaleType.EXACTLY)// 设置图片缩放
				.build();
		return options;

	}

	public DisplayImageOptions getHeadOptions(boolean isCacheInMemory,
			boolean isCacheOnDisk, int round) {

		options = new DisplayImageOptions.Builder()
		.cacheInMemory(isCacheInMemory).cacheOnDisk(isCacheOnDisk)
				.bitmapConfig(Config.RGB_565).considerExifParams(true)
				.displayer(new RoundedBitmapDisplayer(round))
				.imageScaleType(ImageScaleType.EXACTLY)// 设置图片缩放
				.build();
		return options;

	}

	/**
	 * @function 获取下载图片监听对象
	 * @time 2014-10-4上午11:03:29
	 * @return ImageLoadingListener
	 */
	public ImageLoadingListener getImageLoadingListener() {
		animateFirstListener = new AnimateFirstDisplayListener();
		return animateFirstListener;
	}

	public static int calculateInSampleSize(Options options,
			int reqWidth, int reqHeight) {

		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			final int heightRatio = Math.round((float) height
					/ (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);

			inSampleSize = heightRatio < widthRatio ? widthRatio : heightRatio;
		}

		return inSampleSize;
	}

	public DisplayImageOptions getOptionsAuto(boolean isCacheInMemory,
			boolean isCacheOnDisk, int round) {

		options = new DisplayImageOptions.Builder()
				.cacheInMemory(isCacheInMemory).cacheOnDisk(isCacheOnDisk)
				.bitmapConfig(Config.RGB_565).considerExifParams(true)
				.displayer(new BitmapDisplayer() {

					@Override
					public void display(Bitmap arg0, ImageAware arg1,
							LoadedFrom arg2) {
						// TODO Auto-generated method stub
						// arg0=Bitmap.createBitmap(50,50,Config.RGB_565);
						arg1.setImageBitmap(arg0);
					}
				}).imageScaleType(ImageScaleType.EXACTLY)// 设置图片缩放
				.build();
		return options;

	}

	public DisplayImageOptions getFirstOptions(boolean isCacheInMemory,
			boolean isCacheOnDisk, int round) {

		options = new DisplayImageOptions.Builder()
				.cacheInMemory(isCacheInMemory)
				.cacheOnDisk(isCacheOnDisk).bitmapConfig(Config.RGB_565)
				.considerExifParams(true).displayer(new BitmapDisplayer() {

					@Override
					public void display(Bitmap arg0, ImageAware arg1,
							LoadedFrom arg2) {
						// TODO Auto-generated method stub
						// arg0=Bitmap.createBitmap(50,50,Config.RGB_565);
						arg1.setImageBitmap(arg0);
					}
				}).imageScaleType(ImageScaleType.EXACTLY)// 设置图片缩放
				.build();
		return options;

	}

	public static void showImage(String url, ImageView imageView) {
		ImageLoader.getInstance()
				.displayImage(
						url,
						imageView,
						ImageLoaderUtils.getInstance().getOptions(true,
								true, 0),
						ImageLoaderUtils.getInstance()
								.getImageLoadingListener());
	}
	public static void showHeadImage(String url, ImageView imageView) {
		ImageLoader.getInstance()
				.displayImage(
						url,
						imageView,
						ImageLoaderUtils.getInstance().getHeadOptions(true,
								true, 150),
						ImageLoaderUtils.getInstance()
								.getImageLoadingListener());
	}
	
}
