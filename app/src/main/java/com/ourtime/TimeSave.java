package com.ourtime;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mylove.R;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;

/**
 * Created by Administrator on 2016/1/19 0019.
 */
public class TimeSave  extends Activity{
   EditText editText;
    Button button1,button2;
    String getdetial;
    //得到纪念日信息
int count=0;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.timeadd);
        super.onCreate(savedInstanceState);
        Calendar c= getInstance();
        Date d=new Date();
        c.setTime(d);
        DatePicker mDatePicker = (DatePicker)findViewById(R.id.datePicker);
        mDatePicker.init(c.get(Calendar.YEAR), c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                data=year+","+(monthOfYear+1)+","+dayOfMonth;
                Toast.makeText(TimeSave.this,"你选择的时间为："+year+"年"+(monthOfYear+1)+"月"+
                        dayOfMonth+"日",Toast.LENGTH_SHORT).show();

            }
        });
        editText= (EditText) findViewById(R.id.editjinianri);
        button1= (Button) findViewById(R.id.yesbutton);
        button2= (Button) findViewById(R.id.nobutton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdetial=editText.getText()+"";
                SharedPreferences settings = getSharedPreferences("setting", 0);
                SharedPreferences.Editor editor = settings.edit();
                count=settings.getInt("count",0);
                if (count==0){
                    editor.putInt("count",0);
                    if(getdetial!=null&&data!=null){
                        editor.putString("detail"+count,getdetial);
                        editor.putString("data"+count,data);
                        count++;
                        editor.putInt("count",count);
                        editor.commit();
                        Intent intent=new Intent(TimeSave.this,TimeView.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(TimeSave.this,"你还没有输入标题或选择日期",Toast.LENGTH_SHORT).show();
                    }
                    }else {
                    if(getdetial!=null&&data!=null) {
                        editor.putString("detail" + count, getdetial);
                        editor.putString("data" + count, data);
                        count++;
                        editor.putInt("count", count);
                        editor.commit();
                        Intent intent = new Intent(TimeSave.this, TimeView.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(TimeSave.this,"你还没有输入标题或选择日期",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeSave.this,TimeView.class);
                startActivity(intent);
            }
        });
    }


}
