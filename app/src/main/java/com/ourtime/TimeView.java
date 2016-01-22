package com.ourtime;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mylove.MainActivity;
import com.example.administrator.mylove.R;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;

/**
 * Created by Administrator on 2016/1/18 0018.
 */

public class TimeView extends Activity{
    private LinearLayout L;
    private ImageView DetailBack;
    private TextView DetailAshameID;
    private ListView MyListView;
    TimeAdapter adapter;
   TimeDao timeDao;
    ImageButton imageButton;
    String detail,Time,allday;
    int year,month,day;

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.ourdata);
        super.onCreate(savedInstanceState);
        MyListView = (ListView) findViewById(R.id.MyListView);
        DetailBack = (ImageView) findViewById(R.id.Detail_Back);
        imageButton= (ImageButton) findViewById(R.id.add);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeView.this,TimeSave.class);
                startActivity(intent);
            }
        });
        DetailBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeView.this,MainActivity.class);
                startActivity(intent);
            }
        });


        adapter=new TimeAdapter(this);
//        TimeSave timeSave=new TimeSave();
//        String day=timeSave.count(2016,1,7);
//        timeDao=new TimeDao();
//        timeDao.setDay(day+"天");
//        timeDao.setDetail("自2016年1月7日,我们已经在一起");
//        adapter.addList(timeDao);
//         day=timeSave.count(2016,1,10);
//         timeDao=new TimeDao();
//        timeDao.setDay(day + "天");
//        timeDao.setDetail("1月10号那一天，已经过了");
//        adapter.addList(timeDao);
//        timeDao=new TimeDao();
//        day=timeSave.count(2016,1,11);
//        timeDao.setDay(day + "天");
//        timeDao.setDetail("不在你身旁。。。。");
//

        Toast.makeText(TimeView.this, "亲爱的又来看我们的历程啦~", Toast.LENGTH_SHORT).show();
        SharedPreferences settings = getSharedPreferences("setting", 0);
        int count=settings.getInt("count",0);
        if(count!=0){
            for (int i=0;i<count;i++){
                timeDao=new TimeDao();
                Time=settings.getString("data"+i,"");
                detail=settings.getString("detail"+i,"");
                timeDao.setDetail(detail);
                String z[]=Time.split(",");
                year=Integer.parseInt(z[0]);
                month=Integer.parseInt(z[1]);
                day=Integer.parseInt(z[2]);
                allday = count(year,month,day);
                timeDao.setDay(allday+"天");
                adapter.addList(timeDao);
            }
        }
        MyListView.setAdapter(adapter);


    }



    public String count(int year,int month,int day){
        Calendar calendar= getInstance();
        calendar.setTime(new Date());
        System.out.println("现在时间是："+new Date());
        String nyear=String.valueOf(calendar.get(YEAR));
        String nmonth=String.valueOf(calendar.get(MONTH)+1);
        String nday=String.valueOf(calendar.get(DAY_OF_MONTH));
        String week=String.valueOf(calendar.get(DAY_OF_WEEK)-1);
        long nowtime=calendar.getTimeInMillis();
        calendar.set(year,month-1,day);//这里与真实的月份之间相差1
        long settime=calendar.getTimeInMillis();
        long days=(nowtime-settime)/(1000*60*60*24);
        return ""+days;
    }
}
