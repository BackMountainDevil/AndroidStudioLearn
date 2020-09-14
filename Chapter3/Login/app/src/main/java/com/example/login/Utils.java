package com.example.login;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Utils {
    public static boolean saveInfo(String username, String password)  {
        String info = username + "##" + password;
        File file = new File("data/data/com.example.login/info.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(info.getBytes());
            fos.close();
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }
    }
/*
* 获取用户保存的信息
*  @return 数组第一个元素为用户名，第二个为密码，返回空为读取失败
* */
    public  static  String[] readInfo(){
        File file = new File("data/data/com.example.login/info.txt");
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String temp = reader.readLine();
            return temp.split("##");
        } catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
}
