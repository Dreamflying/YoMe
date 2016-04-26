package base;

import java.util.List;

/**
 * 项目名称：com.base
 * 类描述：数据处理接口
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 下午1:07
 * 修改备注：
 *
 * @version 1.0
 */
public interface IController {

    /** 初始化 request in activity
     * @param object
     * @param className
     */
    void init(Object object, Class className);

    /** 初始化 request in activity
     * @param object
     * @param picPaths
     * @param className
     */
    void init(Object object, List<String> picPaths, Class className);
    /**
     * 开始请求
     */
    void start();

    /**
     * 请求准备工作
     * @param url
     * @param requestType
     */
    Controller prepare(String url, RequestType requestType);

    /**
     * 数据处理
     * @param json
     */
    void handlerResult(String json);

}
