package app.account.view;

import android.os.Debug;
import android.view.View;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import app.account.controller.AccountController;
import app.account.model.User;
import app.car.R;
import base.BaseActivity;
import utils.system.LogUtils;


/**
 * 项目名称：com.anjibei.com.module.account.view
 * 类描述： 登录界面
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 下午3:33
 * 修改备注：
 *
 * @version 1.0
 */
@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity {
    User user = new User();
    @ViewById
    ImageView imageView;

    @AfterViews
    @Override
    public void initDataAfterViews() {
        Debug.startMethodTracing();
        Debug.stopMethodTracing();
        setActionBarTitle("首页");

    }

    @Override
    public void requestSuccess(Object object) {
        super.requestSuccess(object);
        LogUtils.v("current", Thread.currentThread().getName());
        if (object instanceof User) {
            user = (User) object;
            LogUtils.v("user", user.getContents().getUserNickname());
        }
    }

    @Override
    public void requestErrorCode(String errorMessage) {
        super.requestErrorCode(errorMessage);
        LogUtils.v("errorMessage", errorMessage);
    }

    @Click({R.id.upload, R.id.frame})
    public void login(View view) {
        switch (view.getId()) {
            case R.id.upload:
                user.setUserId("18571658411");
                user.setUserPassword("zhao123");
                new AccountController(this).testDb(user);
                break;
            case R.id.frame:
                break;
        }


    }

    @Override
    public void reRequest() {
        user.setUserId("12360580725");
        user.setUserPassword("123456");
        new AccountController(this).login(user);
        System.out.println("request");
    }
}
