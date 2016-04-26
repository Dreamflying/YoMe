package base;

import android.content.Context;

import com.android.volley.RequestQueue;

import java.util.List;

/**
 * 项目名称：com.base
 * 类描述：发送请求装载类
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 上午11:41
 * 修改备注：
 *
 * @version 1.0
 */
public class Request {
    private IRequest iRequestFromView;
    private IRequest iRequestFromController;
    private String url;
    private Class className;
    private RequestQueue queue;
    private RequestType RequestType;
    private Object parameter;
    private List<String> paths;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private Context context;


    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

    public RequestType getRequestType() {
        return RequestType;
    }

    public void setRequestType(RequestType requestType) {
        RequestType = requestType;
    }

    public RequestQueue getQueue() {
        return queue;
    }

    public void setQueue(RequestQueue queue) {
        this.queue = queue;
    }

    public IRequest getiRequestFromView() {
        return iRequestFromView;
    }

    public void setiRequestFromView(IRequest iRequestFromView) {
        this.iRequestFromView = iRequestFromView;
    }

    public IRequest getiRequestFromController() {
        return iRequestFromController;
    }

    public void setiRequestFromController(IRequest iRequestFromController) {
        this.iRequestFromController = iRequestFromController;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassName(Class className) {
        this.className = className;
    }


}
