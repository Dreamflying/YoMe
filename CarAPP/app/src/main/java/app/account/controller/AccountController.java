package app.account.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import app.account.model.User;
import app.account.model.UserDao;
import base.Controller;
import base.RequestType;
import utils.io.FileUtils;
import utils.system.LogUtils;


/**
 * 项目名称：com.anjibei.com.module.account.service
 * 类描述：账户业务处理类
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 下午3:27
 * 修改备注：
 *
 * @version 1.0
 */
public class AccountController extends Controller {

    private String LOGIN="account/user/loginSystem";
    private String UPLOAD="";


     public  AccountController(Object currentActivity){
          super(currentActivity);
     }

    public void login(Object vo){
        LogUtils.v("service", "login");
        init(vo, User.class);
        prepare(LOGIN, RequestType.POST);
        start();
    }
    public  void register(Object object){
        ArrayList<String> paths=new ArrayList<>();
        File file=null;
        try {
            file= new FileUtils().createSDFile("utils.test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        paths.add(file.getPath());
        init(object,paths,User.class);
        prepare(LOGIN, RequestType.MULTIPART);
        start();
    }
    public void testDb(User user){
        try {
            new UserDao().save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void select(){
        try {
            LogUtils.v("userid=",((User) new UserDao().select().get(0)).getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
