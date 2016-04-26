package base;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import utils.app.ServiceUtils;
import utils.system.NetworkUtils;

/**
 * 项目名称：com.base
 * 类描述： fragment 基类
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 下午12:11
 * 修改备注：
 *
 * @version 1.0
 */
public class BaseFragment extends Fragment implements  IView,IRequest {
    Intent intent;
    View  rootView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void init(View view){
        this.initView(view);
        this.setListener();
    }
    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void requestSuccess(Object object) {

    }

    @Override
    public void requestDataIsNull(String objectString) {

    }

    @Override
    public void requestErrorCode(String errorMessage) {

    }

    @Override
    public void requestServerError(String serverError) {

    }

    @Override
    public void requestTimeout(String timeoutString) {

    }

    @Override
    public void requestNoConnection(String noConnection) {

    }

    @Override
    public void startService(Class serviceClass,ServiceUtils.ServiceType serviceType) {
        intent = getIntent(serviceClass);
        //如果你想要添加flags 可以再此处添加
        ServiceUtils.startService(intent, getActivity(), serviceType);
    }

    @Override
    public void stopService(Class serviceClass,ServiceUtils.ServiceType serviceType) {
        intent = getIntent(serviceClass);
        //如果你想要添加flags 可以再此处添加
       ServiceUtils.stopService(intent,getActivity(),serviceType);
    }

    @Override
    public boolean validateInternet() {
        return NetworkUtils.validateInternet(getActivity());
    }

    @Override
    public Application getApplication() {
        return null;
    }

    @Override
    public Intent getIntent(Class intentClass) {
        intent = new Intent(getActivity(),intentClass);
        return intent;
    }

    @Override
    public void presentActivity(Class intentClass,boolean isFinish) {
        getActivity().startActivity(intent);
        if (isFinish)getActivity().finish();
    }

    @Override
    public void initDataAfterViews() {

    }
}
