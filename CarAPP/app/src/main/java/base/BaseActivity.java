package base;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.car.R;
import utils.app.ActivityManagerUtils;
import utils.app.ServiceUtils;
import utils.system.NetworkUtils;


/**
 * 项目名称：com.base
 * 类描述： Activity 基类
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 上午11:46
 * 修改备注：
 *
 * @version 1.0
 */
public class BaseActivity extends Activity implements  IView,IRequest {
    private Intent intent;
    private ActionBar actionBar;
    private Button back;
    private TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
	    actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
        ActivityManagerUtils.addActivity(this);
        initCustomActionBar();

    }

    /**
     * 自定义actionbar
     */
    public void initCustomActionBar(){
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.common_view_actionbar);
        back=(Button)actionBar.getCustomView().findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        title=(TextView)actionBar.getCustomView().findViewById(R.id.title);

    }
    /**
     * 设置action title
     * **/
    public void setActionBarTitle(String titleString){
        title.setText(titleString);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /**
     * 初始化
     */
    public void init(){
        this.initView();
        this.setListener();
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initView(View view) {

    }
    @Override
    public void requestSuccess(Object object) {

    }
    @Override
    public void requestDataIsNull(String objectString) {

    }
    @Override
    public void requestErrorCode(String errorMessage) {
        initView();

    }
    @Override
    public void requestServerError(String serverError) {

    }
    @Override
    public void requestTimeout(String timeoutString) {

    }
    @Override
    public void requestNoConnection(String noConnection) {
        System.out.println("noc ");
//        View view = getLayoutInflater().inflate(R.layout.common_view_noconnection,null);
//        ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        this.addContentView(view,layoutParams);
        this.setContentView(R.layout.common_view_noconnection);

    }

    @Override
    public boolean validateInternet() {
        return NetworkUtils.validateInternet(this);
    }

    @Override
    public void startService(Class serviceClass,ServiceUtils.ServiceType serviceType) {
        intent=new Intent(this, serviceClass);
        //如果你想要添加flags 可以再此处添加
        ServiceUtils.startService(intent, this, serviceType);


    }

    @Override
    public void stopService(Class serviceClass,ServiceUtils.ServiceType serviceType) {
        intent=new Intent(this, serviceClass);
        //如果你想要添加flags 可以再此处添加
        ServiceUtils.stopService(intent, this, serviceType);

    }
    @Override
    public Intent getIntent(Class intentClass){
        return getIntent();
    }

   @Override
    public void presentActivity(Class intentClass,boolean isFinish){
        intent=new Intent(this, intentClass);
        this.startActivity(intent);
        if (isFinish)close();
    }
    //点击再次请求
    public void clickReRequest(View view){
        this.reRequest();
    }
    //再次请求
    public void reRequest(){
    }
    /**
     * 关闭当前activity
     */
    public void close(){
        this.finish();
    }

    @Override
    public void initDataAfterViews() {

    }

}
