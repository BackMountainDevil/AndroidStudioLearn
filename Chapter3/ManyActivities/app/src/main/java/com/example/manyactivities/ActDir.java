package com.example.manyactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActDir extends AppCompatActivity implements View.OnClickListener{
    String msg = "Dir";   //日志Verbose   msg  Dir
    private String mStr = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_dir);

        //设置标题
        setTitle("广东**通讯录");

        //设置当前页面的按钮颜色，按钮会变大？？？？？？why
        Button btn_msg = findViewById(R.id.btn_dir);
        btn_msg.setBackgroundColor(0xFFDDFFBD);

        //设置按钮点击事件
        findViewById(R.id.btn_msg).setOnClickListener(this);
        findViewById(R.id.btn_dir).setOnClickListener(this);
        findViewById(R.id.btn_find).setOnClickListener(this);
        findViewById(R.id.btn_me).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_msg) {
            // 准备跳到下个活动页面ActNextActivity
            Intent intent = new Intent(this, MainActivity.class);
            // 发送数据

            intent.putExtra("life", "身价十八亿津巴布韦"); // 把字符串参数塞给意图
            setResult(Activity.RESULT_OK, intent); // 携带意图返回前一个页面
            finish(); // 关闭当前页面
        }
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