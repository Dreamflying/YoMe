package base;

import android.widget.ImageView;

/**
 * 项目名称：com.base
 * 类描述：请求图片实体类
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/16 上午11:01
 * 修改备注：
 *
 * @version 1.0
 */
public class RequestImage extends Request {
    private ImageView imageView;
    private int defaultImage;
    private int failureImage;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(int defaultImage) {
        this.defaultImage = defaultImage;
    }

    public int getFailureImage() {
        return failureImage;
    }

    public void setFailureImage(int failureImage) {
        this.failureImage = failureImage;
    }
}
