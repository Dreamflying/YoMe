package utils.app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 项目名称：com.utils.app
 * 类描述： 轻量存储
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/18 上午10:26
 * 修改备注：
 *
 * @version 1.0
 */
public class SharePreferenceUtils {
    private static SharedPreferences.Editor mEditor;
    private static  SharedPreferences sharedPreferences;
    private static final String SAVE_FILE_NAME = "save_info";
    public static  void init(Context context){
        sharedPreferences=context.getSharedPreferences(SAVE_FILE_NAME,Context.MODE_PRIVATE);
        mEditor=sharedPreferences.edit();
    }
    public static  void saveUserName(String username){
        mEditor.putString("username",username);
        mEditor.commit();
    }
    public static  String getUserName(){
        return  sharedPreferences.getString("username","");
    }
    public static  void savePassword(String password){
        mEditor.putString("password",password);
        mEditor.commit();
    }
    public static  String getPassword(){
        return sharedPreferences.getString("password","");
    }
    public static  void saveAvatar(String avatar){
        mEditor.putString("avatar",avatar);
        mEditor.commit();
    }
    public static  String getAvatar(){
        return  sharedPreferences.getString("avatar","");
    }

    public static void clear(){
        mEditor.clear();
    }
}
