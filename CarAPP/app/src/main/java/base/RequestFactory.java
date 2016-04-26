package base;

import com.android.volley.toolbox.Volley;

/**
 * 项目名称：com.base
 * 类描述：获取Request 工厂类
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 下午12:07
 * 修改备注：
 *
 * @version 1.0
 */
public class RequestFactory {
    private static RequestFactory ourInstance = new RequestFactory();
    Request request= new Request();
    public static RequestFactory getInstance() {
        return ourInstance;
    }

    private RequestFactory() {
    }

    /**
     * 获取Request from activity
     * @param activity
     * @param param
     * @param className
     * @return request
     */
    public Request getRequest(BaseActivity activity,Object param,Class className){
        request.setContext(activity);
        request.setQueue(Volley.newRequestQueue(activity));
        request.setiRequestFromView(activity);
        request.setParameter(param);
        request.setClassName(className);
        return request;
    }

    /**
     * 获取Request from fragment
     * @param fragment
     * @param param
     * @param className
     * @return request
     */
    public Request getRequest(BaseFragment fragment,Object param,Class className){
        request.setContext(fragment.getActivity());
        request.setQueue(Volley.newRequestQueue(fragment.getActivity()));
        request.setiRequestFromView(fragment);
        request.setParameter(param);
        request.setClassName(className);
        return request;

    }

}
