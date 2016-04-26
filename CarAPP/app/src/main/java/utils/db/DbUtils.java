package utils.db;

import android.app.Application;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * 项目名称：utils.db
 * 类描述： 数据库utils
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/11/16 下午3:56
 * 修改备注：
 *
 * @version 1.0
 */
public class DbUtils {

    private final  static String DB_NAME= "utils/test";
    private final  static String DB_PATH="anjibei/db";
    private final  static  int   DB_VERSION=1;
    private static  DbManager.DaoConfig daoConfig;
    public static  void init(Application context){
        x.Ext.init(context);
        x.Ext.setDebug(true);
    }
    public static void createDb(){
         daoConfig = new DbManager.DaoConfig()
                .setDbName(DB_NAME)
                .setDbDir(new File(DB_PATH))
                .setDbVersion(DB_VERSION)
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        // TODO: ...
                        // db.addColumn(...);
                        // db.dropTable(...);
                        // ...
                    }
                });
    }

    public static  DbManager getDbManager(){
        if(daoConfig==null){
            createDb();
        }
        return x.getDb(daoConfig);

    }

}
