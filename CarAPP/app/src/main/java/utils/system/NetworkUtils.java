package utils.system;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 项目名称：com.utils.system
 * 类描述：手机网络工具类
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/17 下午1:57
 * 修改备注：
 *
 * @version 1.0
 */
public class NetworkUtils {
    /** 网络状态
     * @param context
     * @return
     */
    public static boolean validateInternet(Context context){
      if (isMobile(context)||isWifi(context)) return true;
        return false;
    }

    /** 移动网络
     * @param context
     * @return
     */
    public static boolean  isMobile(Context context){
        LogUtils.v("mobile","here");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            if(activeNetInfo.isAvailable())
            return true;
        }
        return false;

    }

    /** WIFI
     * @param mContext
     * @return
     */
    private static boolean isWifi(Context mContext) {
        LogUtils.v("wifi","here");
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            if (activeNetInfo.isAvailable())
            return true;
        }
        return false;
    }
}
