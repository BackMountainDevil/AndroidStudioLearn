package com.example.login;

import android.content.Context;

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

    /*
    利用上下文Context获取路径
    * */
    public static boolean saveInfoByContext(Context context,String username, String password)  {
        String info = username + "##" + password;
        //File file = new File(context.getFilesDir().getAbsolutePath() + "/info.txt");
        //System.out.println(context.getFilesDir().getAbsolutePath());
        // /data/user/0/com.example.login/files/info.txt

        try {
            //FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = context.openFileOutput("info2.txt",Context.MODE_PRIVATE);
            fos.write(info.getBytes());
            fos.close();
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }
    }

    public  static  String[] readInfoByContext(Context context){
        try{
            FileInputStream fis = context.openFileInput("info2.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String temp = reader.readLine();
            return temp.split("##");
        } catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

}
