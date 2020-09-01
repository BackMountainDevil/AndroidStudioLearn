package com.example.horseracelamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //跑马灯效果，仅修改xml，手机测试滚动成功，无法实现点击效果，虚拟机不滚动
    }
}