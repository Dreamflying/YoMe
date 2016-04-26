package base;


import java.util.List;

import common.Constant;
import utils.http.HttpRequest;
import utils.json.JSONUtils;
import utils.system.LogUtils;

/**
 * 项目名称：com.base
 * 类描述： 业务处理基类
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 上午11:24
 * 修改备注：
 *
 * @version 1.0
 */
public class Controller implements IController, IRequest {

    public Request request;
    public Object viewObject;


    public Controller(Object viewObject){
        this.viewObject=viewObject;
    }

    @Override
    public void init(Object object, Class className) {
        if (viewObject instanceof BaseActivity){
            this.request=RequestFactory.getInstance().getRequest((BaseActivity)viewObject,object,className);
        }else if (viewObject instanceof  BaseFragment){
            this.request=RequestFactory.getInstance().getRequest((BaseFragment)viewObject,object,className);
        }
        request.setiRequestFromController(this);
    }

    @Override
    public void init(Object object, List<String> picPaths, Class className) {
        if (viewObject instanceof BaseActivity){
            this.request=RequestFactory.getInstance().getRequest((BaseActivity)viewObject,object,className);
        }else if (viewObject instanceof  BaseFragment){
            this.request=RequestFactory.getInstance().getRequest((BaseFragment)viewObject,object,className);
        }
        request.setPaths(picPaths);
        request.setiRequestFromController(this);
    }

    @Override
    public void start() {
        LogUtils.v("Controller", "start");
        HttpRequest.request(request);
    }

    @Override
    public Controller prepare(String url, RequestType requestType) {
        request.setUrl(Constant.URL_SERVER + url);
        request.setRequestType(requestType);
        return this;
    }

    @Override
    public void handlerResult(String json) {
        Result result = (Result) JSONUtils.jsonToObject(json, Result.class);
        if (result != null) {
            if (result.getCode().equals(Constant.REQUEST_SUCCESS_CODE)) {
                Object object = JSONUtils.jsonToObject(json, request.getClassName());
                if (object != null) {
                    request.getiRequestFromView().requestSuccess(object);
                } else {
                    requestDataIsNull(result.getMessage());
                }
            }
            if (result.getCode().equals(Constant.REQUEST_ERROR_CODE)) {
                requestErrorCode(result.getMessage());

            }
        } else {
            requestDataIsNull("data is null");
        }

    }

    @Override
    public void requestSuccess(Object object) {
        if(viewObject!=null)handlerResult((String) object);
    }

    @Override
    public void requestErrorCode(String errorMessage) {
        if(viewObject!=null)request.getiRequestFromView().requestErrorCode(errorMessage);

    }

    @Override
    public void requestDataIsNull(String objectString) {
        if(viewObject!=null)request.getiRequestFromView().requestDataIsNull(objectString);
    }

    @Override
    public void requestServerError(String serverError) {
        if(viewObject!=null) request.getiRequestFromView().requestServerError(serverError);

    }

    @Override
    public void requestTimeout(String timeoutString) {
        if(viewObject!=null) request.getiRequestFromView().requestTimeout(timeoutString);

    }

    @Override
    public void requestNoConnection(String noConnection) {
        if(viewObject!=null)request.getiRequestFromView().requestNoConnection(noConnection);
    }
}

