package com.example.administrator.mylove;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/1/28 0028.
 */
public class InternetHelp {
    JSONObject jobject;
    JSONArray array;
    private static String url1 = "http://192.168.1.105:8080/blog1/myjson";
    public JSONObject conn(){
        try {
        URL url = new URL(url1);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(2000);
        //设置连接超时为5秒
        conn.setRequestMethod("GET"); //设定请求方式
        InputStream dis = conn.getInputStream();
        byte[] data = readInputStream(dis);
        String json = new String(data);
          jobject = new JSONObject(json);
    }catch (Exception e) {
            e.printStackTrace();
        }
        return jobject;
    }
    public boolean panduan(){
        try {
            URL url = new URL(url1);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(2000);
            //设置连接超时为5秒
            conn.setRequestMethod("GET"); //设定请求方式
            InputStream dis = conn.getInputStream();
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public JSONArray arrayconn(){


        try {
            URL url = new URL(url1);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(2000);
            //设置连接超时为5秒
            conn.setRequestMethod("GET"); //设定请求方式
            InputStream dis = conn.getInputStream();
            byte[] data = readInputStream(dis);
            String ppp = new String(data);
            array = new JSONArray(ppp);
        }catch (Exception e) {
            e.printStackTrace();

        }

        return array;
    }
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }


}
