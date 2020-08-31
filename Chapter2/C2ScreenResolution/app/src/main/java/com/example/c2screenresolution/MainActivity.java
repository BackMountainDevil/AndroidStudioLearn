package com.example.c2screenresolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 当前的页面布局采用的是res/layout/activity_main.xml
        setContentView(R.layout.activity_main);


//        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
//        int width = wm.getDefaultDisplay().getWidth();
//        int height = wm.getDefaultDisplay().getHeight();


        // 获取名叫tv_hello的TextView控件
        TextView tv_hello = findViewById(R.id.tv_width);
        // 设置TextView控件的文字内容
        tv_hello.setText("123");
        // 设置TextView控件的文字颜色
        tv_hello.setTextColor(Color.GREEN);
        // 设置TextView控件的文字大小
        tv_hello.setTextSize(30);
    }
}
