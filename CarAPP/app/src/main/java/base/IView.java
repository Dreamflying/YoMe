package base;

import android.app.Application;
import android.content.Intent;
import android.view.View;

import utils.app.ServiceUtils;

/**
 * 项目名称：com.base
 * 类描述：界面操作接口
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 上午11:33
 * 修改备注：
 *
 * @version 1.0
 */
public interface IView {


    /** Activity 跳转
     * @param intentClass
     * @param isFinish
     */
    void presentActivity(Class intentClass, boolean isFinish);

    /**获取intent
     * @param intentClass
     * @return
     */
    Intent getIntent(Class intentClass);

    /** 获取application
     * @return
     */
      Application getApplication();


    /**
     * 开启service
     * @param serviceClass
     */
    void startService(Class serviceClass, ServiceUtils.ServiceType serviceType);

    /**
     * 停止service
     */
    void stopService(Class serviceClass, ServiceUtils.ServiceType serviceType);

    /**
     * @return
     */
    boolean validateInternet();


    /**
     * 初始化布局,数据,获取ID in Activity
     */
     void initView();

    /**
     * 初始化布局,数据,获取ID in Fragment
     * @param view
     */
     void initView(View view);

    /**
     * 设置监听
     */
     void setListener();

    /**
     * 利用 androidannotions框架初始化view 之后，进行数据绑定
     */
    void initDataAfterViews();
}
