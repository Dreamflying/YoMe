package utils.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 项目名称：com.utils.app
 * 类描述：fragment 管理类
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/16 下午4:35
 * 修改备注：
 *
 * @version 1.0
 */
public class FragmentManagerUtils {
    private static FragmentTransaction transaction;
    private static FragmentManagerUtils instance = new FragmentManagerUtils();
    private View rootView;

    private FragmentManagerUtils() {

    }

    public static FragmentManagerUtils getInstance(Activity context) {
        transaction = context.getFragmentManager().beginTransaction();
        return instance;
    }

    /** 加入页面缓存
     * @param inflater
     * @param layout
     * @return view
     */
    public View cache(LayoutInflater inflater,int layout){
        if (rootView == null) {
            rootView = inflater.inflate(layout, null);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
      return  rootView;

    }
    /**
     * 添加fragment
     *
     * @param id
     * @param fragment
     */
    public void add(int id, Fragment fragment) {
        transaction.add(id, fragment);
        back();
        commit();

    }

    /**
     * 替换fragment
     *
     * @param id
     * @param fragment
     */
    public void replace(int id, Fragment fragment) {
        transaction.replace(id, fragment);
        back();
        commit();


    }

    /**
     * 返回fragment
     */
    public void back() {
        transaction.addToBackStack(null);

    }

    /**
     * 移除fragment
     */
    public void remove(Fragment fragment) {
        transaction.remove(fragment);
        back();
        commit();

    }

    /**
     * commit fragment
     */
    public void commit() {
        transaction.commit();
    }
}
