package utils.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * 项目名称：com.utils.app
 * 类描述： app-service utils
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/17 上午10:21
 * 修改备注：
 *
 * @version 1.0
 */


public class ServiceUtils {
    public enum ServiceType{
        BIND,START
    }
   static ServiceType type;

    /**开启service
     *
     * @param intent
     * @param context
     * @param serviceType
     */
    public static  void startService(Intent intent,Context context,ServiceType serviceType) {
         type= serviceType;
        switch (type){
            case BIND:
                context.bindService(intent,conn,Context.BIND_AUTO_CREATE);
                break;
            case START:
                context.startService(intent);
                break;


        }

    }
    private static  ServiceConnection conn = new ServiceConnection() {
        /** 获取服务对象时的操作 */
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub

        }

        /** 无法获取到服务对象时的操作 */
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub
        }

    };

    /**关闭service
     * @param intent
     * @param context
     */
    public static void stopService(Intent intent ,Context context,ServiceType serviceType){
        type= serviceType;
        switch (type){
            case BIND:
                context.unbindService(conn);
                break;
            case START:
                context.stopService(intent);
                break;


        }

    }
}