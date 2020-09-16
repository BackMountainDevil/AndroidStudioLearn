package com.example.listview;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView lv_con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_con = findViewById(R.id.lv_con);
        lv_con.setAdapter(new MyAdpter());
    }

    private  class MyAdpter extends BaseAdapter {

        //返回ListView展示条目的数量
        @Override
        public int getCount() {
            return 1500000000;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }
/*重复使用view，避免内存溢出
* https://www.bilibili.com/video/BV1HJ411L756?p=92
* */
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
//            TextView tv_Test = new TextView(MainActivity.this);
//            tv_Test.setText("this is the " + i + " item");
//            return tv_Test;       //view数目太大会由内存溢出error

            TextView tv_Text;
            if(view == null){
                tv_Text = new TextView(MainActivity.this);
                System.out.println("Creat a new one -   " + i);
            }else{
                tv_Text = (TextView)view;
                System.out.println("Use old one -   " + i);
            }
            tv_Text.setText("this is the " + i + " item");
            return tv_Text;
        }
    }
}