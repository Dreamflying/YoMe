package base;

/**
 * 项目名称：com.base
 * 类描述：返回头部类
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 下午3:02
 * 修改备注：
 *
 * @version 1.0
 */
public class Result {
    private String code;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;

    }

    public void setCode(String code) {
        this.code = code;
    }
}
