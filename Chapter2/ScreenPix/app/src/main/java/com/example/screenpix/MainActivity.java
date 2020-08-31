package com.example.screenpix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 当前的页面布局采用的是res/layout/activity_main.xml
        setContentView(R.layout.activity_main);


/*        WindowManager wm1 = this.getWindowManager();  //获取屏幕参数方法1
        int width = wm1.getDefaultDisplay().getWidth();
        int height = wm1.getDefaultDisplay().getHeight();*/

        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);  //获取屏幕参数方法1
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        float density = dm.density; //density：像素密度，即一个dp单位包含多少个px单位。

        TextView tv_width = findViewById(R.id.tv_width);
        TextView tv_height = findViewById(R.id.tv_height);
        TextView tv_density = findViewById(R.id.tv_density);

        tv_width.setText("Width： "+Integer.toString(width)+" px");
        tv_height.setText("Height： "+Integer.toString(height)+" px");
        tv_density.setText("Density : "+Float.toString(density));
    }
}
