package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;



/*
References: https://www.bilibili.com/video/BV1HJ411L756?p=46
登录界面 + txt文档存储&&读取用户名密码
* */
public class MainActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private CheckBox cb_remember;
    private Button btn_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        cb_remember = findViewById(R.id.cb_remember);
        btn_log = findViewById(R.id.btn_log);

        btn_log.setOnClickListener(new btnClickListener());

        String[] info = Utils.readInfo();
        if(info != null){
            et_username.setText(info[0]);
            et_password.setText(info[1]);
            cb_remember.setChecked(true);
        }
    }


    class btnClickListener implements OnClickListener{

        @Override
        public void onClick(View view) {
            String username = et_username.getText().toString().trim();
            String password = et_password.getText().toString().trim();
            if(username.isEmpty()) {
                Toast.makeText(MainActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
            }
            else if(password.isEmpty()) {
                Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            }
            else{
                if(cb_remember.isChecked()) {
                    System.out.println("userNmae: " + username);
                    System.out.println("password: " + password);
                    if(Utils.saveInfo(username,password)){
                        Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
                    }
                }

                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            }

        }
    }
}