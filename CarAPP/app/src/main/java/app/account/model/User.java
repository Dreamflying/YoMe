package app.account.model;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * 项目名称：com.anjibei.com.module.account.entity
 * 类描述：model
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 下午3:42
 * 修改备注：
 *
 * @version 1.0
 */
@Table(name = "user")
public class User {
    @Column(name ="id",isId = true)
    private int id;
    @Column(name ="userId")
    private String userId;
    @Column(name ="userPassword")
    private String userPassword;
    private ContentsEntity contents;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public void setContents(ContentsEntity contents) {
        this.contents = contents;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContentsEntity getContents() {
        return contents;
    }


    public class ContentsEntity {
        private String sid;
        private String userPicPath;
        private String userNickname;

        public void setSid(String sid) {
            this.sid = sid;
        }

        public void setUserPicPath(String userPicPath) {
            this.userPicPath = userPicPath;
        }

        public void setUserNickname(String userNickname) {
            this.userNickname = userNickname;
        }

        public String getSid() {
            return sid;
        }

        public String getUserPicPath() {
            return userPicPath;
        }

        public String getUserNickname() {
            return userNickname;
        }
    }
}
