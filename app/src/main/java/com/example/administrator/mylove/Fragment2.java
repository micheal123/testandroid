package com.example.administrator.mylove;

import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;


/**
 * Created by Administrator on 2016/1/20 0020.
 */
public class Fragment2 extends Fragment {
    SwipeRefreshLayout swipeRefreshLayout;
    TextView textView;
    MessageAdapter adapter;
    MessageDao messageDao;
    private ListView MyListView;
    String username,text;
    InternetHelp internetHelp;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fg2, container,false);
        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        MyListView= (ListView) view.findViewById(R.id.MyListView2);
        textView= (TextView) view.findViewById(R.id.pull_text);
        adapter=new MessageAdapter(getActivity());
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                textView.setText("正在刷新");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("刷新成功,下拉再次刷新");
                            //判断是否正常响应数据
                            //获取各个属性的值
                            internetHelp=new InternetHelp();
                            if (internetHelp.panduan()){
//                                JSONObject jobject= internetHelp.conn();
//                                try {
//                                    username = jobject.getString("username").toString();
//                                    password = jobject.getString("password").toString();
//                                }catch (Exception e){
//                                    e.printStackTrace();
//                                }
                                JSONArray jsonArray=internetHelp.arrayconn();
                                adapter.list.clear();
                                for(int i=0;i<jsonArray.length();i++){
                                    try {
                                        JSONObject item=jsonArray.getJSONObject(i);
                                        username = item.getString("username").toString();
                                         text = item.getString("text").toString();
                                        setMyListView(username,text);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }else{
                                textView.setText("网络错误异常！!!!你男朋友没有开服务");
                            }
                            //构造的对象加入集合当中

                            MyListView.setAdapter(adapter);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });



        return view;
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
 public  void setMyListView(String username,String password){
     messageDao=new MessageDao();
     messageDao.setDetail(username);
     messageDao.setTime(password);
     adapter.addList(messageDao);

 }
    @Override
    public void onResume() {

        super.onResume();
    }

    @Override
    public void onStart() {

        super.onStart();
    }
}
