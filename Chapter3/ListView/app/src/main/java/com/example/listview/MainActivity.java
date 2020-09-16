package com.example.listview;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
            return 15;
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
* ListView内部细节实现https://www.bilibili.com/video/BV1HJ411L756?p=94
*
* */
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View v;
            if(view == null){
                v = View.inflate(MainActivity.this,R.layout.item,null); //将xml转换为View
                System.out.println("Creat a new one -   " + i);
            }else{
                v = view;
                System.out.println("Use old one -   " + i);
            }
            return v;
        }
    }
}