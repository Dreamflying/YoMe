package base;

/**
 * description 请求回调接口
 * time 15/9/14 上午10:56
 * author Darker  1522651962@qq.com
 */
public interface IRequest {


    /**
     * request data success (请求数据成功)
     *
     * @param object
     */
     void requestSuccess(Object object);

    /**
     * request data is null (数据为空)
     *
     * @param objectString
     */
     void requestDataIsNull(String objectString);

    /**
     * request ErrorCode(请求错误Code)
     *
     * @param errorMessage
     */

     void requestErrorCode(String errorMessage);

    /**
     * request timeout(请求超时)
     *
     * @param timeoutString
     */
     void requestTimeout(String timeoutString);

    /**
     * request serverError(请求服务器错误)
     *
     * @param serverError
     */
     void requestServerError(String serverError);

    /**
     * request noConnection(请求无链接)
     *
     * @param noConnection
     */
     void requestNoConnection(String noConnection);


}
