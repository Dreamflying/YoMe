package utils.system;

import android.util.Log;

/**Log日志管理类
 *@author Darker
 *@time 2014-4-11 下午5:31:42
 *@Email 1522651962@qq.com
 */
public class LogUtils {
	private static boolean isLog=true;

	public static  void v(String tag,String message){
     if (isLog){
		 Log.v(tag,message);
	 }

	}



}
