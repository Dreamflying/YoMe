package utils.io;

import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 项目名称：com.utils.io
 * 类描述 文件工具类
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 下午1:32
 * 修改备注：
 *
 * @version 1.0
 */
public class FileUtils {

	private String SDCARD = null;

	public FileUtils() {
		SDCARD = Environment.getExternalStorageDirectory() + "/";
	}

	/**
	 * 创建一个目录
	 * 
	 * @param dirName
	 * @return
	 */
	public File createSDDir(String dirName) {
		File fileDir = new File(SDCARD + dirName);
		fileDir.mkdir();
		return fileDir;
	}

	/**
	 * 创建一个文件
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public File createSDFile(String fileName) throws IOException {
		File file = new File(SDCARD + fileName); // 注意在这里一定要加上主目录
													// SDCARD中，才可以，不然会找不到目录 。
		file.createNewFile();
		return file;
	}

	/**
	 * 判断SD卡上的文件是不是存在
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean existSDFile(String fileName) {
		File file = new File(SDCARD + fileName);
		return file.exists();
	}

	/**
	 * 将一个流对象写入SDCARD
	 * 
	 * @param path
	 * @param fileName
	 * @param is
	 * @param fileUtilsUpdateProgressBar
	 * @return
	 */
	public File writeSDCARDFromInputSteam(String path, String fileName,
			InputStream is,
			FileUtilsUpdateProgressBar fileUtilsUpdateProgressBar) {
		File file = null;
		OutputStream os = null;
		try {
			createSDDir(path);
			file = createSDFile(path + fileName);
			os = new FileOutputStream(file);
			int downLoadFileSize = 0;
			byte[] buffer = new byte[1024];
			fileUtilsUpdateProgressBar.startProgressBar(0);
			do {
				// 循环读取
				int numread = is.read(buffer);
				if (numread == -1) {
					break;
				}
				os.write(buffer, 0, numread);
				downLoadFileSize += numread;
				fileUtilsUpdateProgressBar.updateProgressBar(downLoadFileSize);

			} while (true);
			fileUtilsUpdateProgressBar.endProgressBar(1);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return file;
	}

	/** 删除文件
	 * @param file
	 * @return
	 */
	public boolean deleteFile(File file){
		return  file.delete();
	}
}
