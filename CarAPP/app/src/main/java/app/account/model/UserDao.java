package app.account.model;

import java.util.List;

import utils.db.DbUtils;

/**
 * 项目名称：anjibei.com.module.account.dao
 * 类描述： 针对本地数据库进行操作
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/11/17 上午9:45
 * 修改备注：
 *
 * @version 1.0
 */
public class UserDao {

    public void save(User user) throws Exception{
        DbUtils.getDbManager().save(user);
    }
    public List<User> select() throws Exception{
       return DbUtils.getDbManager().findAll(User.class);
    }
}
