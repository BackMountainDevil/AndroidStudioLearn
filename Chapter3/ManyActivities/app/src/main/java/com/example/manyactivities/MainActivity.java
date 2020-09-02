package com.example.manyactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
实现不同Activity的切换，这里仅实现“消息”和“通讯录”的切换，不同Activity切换有切屏！！！辣眼睛
* 设置颜色：https://www.cnblogs.com/Free-Thinker/p/5571871.html
* 取色器： https://www.mokuge.com/tool/css_color/
*设置标题： https://stackoverflow.com/questions/2198410/how-to-change-title-of-activity-in-android
传参： https://blog.csdn.net/smile_tb/article/details/52232389
* */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String msg = "Main";   //日志Verbose   msg  Main


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "The onCreate() event");
        //设置标题
        setTitle("Windows微信已登录");



        //设置当前页面的按钮颜色，按钮会变大？？？？？？why
        Button btn_msg = findViewById(R.id.btn_msg);
        btn_msg.setBackgroundColor(0xFFDDFFBD);

        //设置按钮点击事件
        findViewById(R.id.btn_msg).setOnClickListener(this);
        findViewById(R.id.btn_dir).setOnClickListener(this);
        findViewById(R.id.btn_find).setOnClickListener(this);
        findViewById(R.id.btn_me).setOnClickListener(this);

    }
    /** 当底部按钮单击时调用 */
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_dir) {
            // 准备跳到下个活动页面ActNextActivity
            Intent intent = new Intent(this, ActDir.class);
            // 期望接收下个页面的返回数据
            startActivityForResult(intent, 0);
        }
    }
    /** 当活动接收返回数据时调用 */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String nextLife = data.getStringExtra("life");
        Log.d(msg,  nextLife);
        super.onActivityResult(requestCode, resultCode, data);
    }

    /** 当活动即将可见时调用 */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /** 当活动可见时调用 */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /** 当其他活动获得焦点时调用 */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /** 当活动不再可见时调用 */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /** 当活动将被销毁时调用 */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }
}