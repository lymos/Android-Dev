package com.example.lymos.flagmentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_channel;
    private TextView txt_message;
    private TextView txt_better;
    private TextView txt_setting;
    private TextView text_topbar;

    // fragment object
    private MyFragment fg1, fg2, fg3, fg4;
    private FragmentManager fmanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        fmanager = getFragmentManager();    // 获取FragmentManager
       // txt_channel.performClick();  // 模拟一次点击
    }

    /**
     * UI组件初始化并与事件绑定
     */
    public void bindViews(){
        txt_channel = (TextView) findViewById(R.id.txt_channel);
        txt_message = (TextView) findViewById(R.id.txt_message);
        txt_better = (TextView) findViewById(R.id.txt_better);
        txt_setting = (TextView) findViewById(R.id.txt_setting);

        txt_channel.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_better.setOnClickListener(this);
        txt_setting.setOnClickListener(this);
    }

    private void hideFragments(FragmentTransaction fgment){
        if(fg1 != null){
            fgment.hide(fg1);
        }
        if(fg2 != null){
            fgment.hide(fg2);
        }
        if(fg3 != null){
            fgment.hide(fg3);
        }
        if(fg4 != null){
            fgment.hide(fg4);
        }
    }

    /**
     * @Override
     * 点击事件
     * @param v
     */
    public void onClick(View v){
        FragmentTransaction transaction  = fmanager.beginTransaction(); // 启动
        hideFragments(transaction);
        switch(v.getId()) {
            case R.id.txt_channel:
                setSelectedFalse();
                txt_channel.setSelected(true);
                //text_topbar.setText("提醒");
                if(fg1 == null){
                    fg1 = new MyFragment("系统提醒！");  // 声明类
                    transaction.add(R.id.ly_content, fg1);  // 把内容添加到FrameLayout中
                }else{
                    transaction.show(fg1);  // 显示
                }
                break;
            case R.id.txt_message:
                setSelectedFalse();
                txt_message.setSelected(true);
               // text_topbar.setText("信息");
                if(fg2 == null){
                    fg2 = new MyFragment("信息内容！");
                    transaction.add(R.id.ly_content, fg2);
                }else{
                    transaction.show(fg2);
                }
                break;
            case R.id.txt_better:
                setSelectedFalse();
                txt_better.setSelected(true);
                //text_topbar.setText("我的");
                if(fg3 == null){
                    fg3 = new MyFragment("我的资料！");
                    transaction.add(R.id.ly_content, fg3);
                }else{
                    transaction.show(fg3);
                }
                break;
            case R.id.txt_setting:
                setSelectedFalse();
                txt_setting.setSelected(true);
               // text_topbar.setText("设置");
                if(fg4 == null){
                    fg4 = new MyFragment("系统设置！");
                    transaction.add(R.id.ly_content, fg4);
                }else{
                    transaction.show(fg4);
                }
                break;
        }
        transaction.commit(); // 提交

    }

    /**
     * 重置选中状态
     */
    private void setSelectedFalse(){
        txt_setting.setSelected(false);
        txt_better.setSelected(false);
        txt_channel.setSelected(false);
        txt_message.setSelected(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
