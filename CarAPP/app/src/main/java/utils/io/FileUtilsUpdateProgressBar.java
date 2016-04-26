package utils.io;

/**
 * 项目名称：com.utils.io
 * 类描述  更新文件接口
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 下午1:32
 * 修改备注：
 *
 * @version 1.0
 */
public interface FileUtilsUpdateProgressBar {
	
	/**
	 * @param updatelength
	 */
	public void updateProgressBar(int updatelength);
	
	/**
	 * @param updatelength
	 */
	public void startProgressBar(int updatelength);
	
	/**
	 * @param updatelength
	 */
	public void endProgressBar(int updatelength);

}
