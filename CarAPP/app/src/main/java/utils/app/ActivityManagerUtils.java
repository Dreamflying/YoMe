package utils.app;

import android.app.Activity;

import java.util.ArrayList;

/**
 * 项目名称：com.utils.app
 * 类描述：Activity 管理类
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/17 上午9:17
 * 修改备注：
 *
 * @version 1.0
 */
public class ActivityManagerUtils {
    public static ArrayList<Activity> activities=new ArrayList<>();
    /**
     *
     */
    public void onCreate(){

    }
    public void onResume(){

    }
    public void onStart(){

    }
    public void onReStart(){

    }
    public void onPause(){

    }
    public void onStop(){

    }
    public void onDestory(){

    }

    /**添加activity
     * @param activity
     */
    public static void addActivity(Activity activity){
            activities.add(activity);
    }

    /**
     * 退出应用
     */
    public static void exit(){
        for (Activity activity:activities){
            activity.finish();
        }
    }
}
