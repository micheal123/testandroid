package com.example.administrator.mylove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ourtime.TimeView;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    FragmentManager fManager;
    private Fragment1 fg1;
    private Fragment2 fg2;
    private Fragment3 fg3;
    private ImageView course_image;
    private ImageView found_image;
    private ImageView settings_image;
    private TextView course_text;
    private TextView settings_text;
    private TextView found_text;
    private RelativeLayout course_layout;
    private RelativeLayout found_layout;
    private RelativeLayout settings_layout;
    private int blue =0xFF0AB2FB;
    private int gray = 0xFF7597B3;
    private int whirt = 0xFFFFFFFF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fManager = getSupportFragmentManager();
       initViews();



    }
    public void initViews()
    {
        course_image = (ImageView) findViewById(R.id.course_image);
        found_image = (ImageView) findViewById(R.id.found_image);
        settings_image = (ImageView) findViewById(R.id.setting_image);
        course_text = (TextView) findViewById(R.id.course_text);
        found_text = (TextView) findViewById(R.id.found_text);
        settings_text = (TextView) findViewById(R.id.setting_text);
        course_layout = (RelativeLayout) findViewById(R.id.course_layout);
        found_layout = (RelativeLayout) findViewById(R.id.found_layout);
        settings_layout = (RelativeLayout) findViewById(R.id.setting_layout);
        setChioceItem(0);
        course_layout.setOnClickListener(this);
        found_layout.setOnClickListener(this);
        settings_layout.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.course_layout:
                setChioceItem(0);
                break;
            case R.id.found_layout:
                setChioceItem(1);
                break;
            case R.id.setting_layout:
                setChioceItem(2);
                break;
            default:
                break;
        }

    }

    private void setChioceItem(int i) {
        FragmentTransaction transaction = fManager.beginTransaction();
        clearChioce();
        hideFragments(transaction);
        switch (i) {
            case 0:
                course_image.setImageResource(R.drawable.ic_tabbar_course_pressed);
                course_text.setTextColor(blue);
//                course_layout.setBackgroundResource(R.drawable.ic_tabbar_bg_click);
                if (fg1 == null) {
                    // Èç¹ûfg1Îª¿Õ£¬Ôò´´½¨Ò»¸ö²¢Ìí¼Óµ½½çÃæÉÏ
                    fg1 = new Fragment1();
                    transaction.add(R.id.content, fg1);
                } else {
                    // Èç¹ûMessageFragment²»Îª¿Õ£¬ÔòÖ±½Ó½«ËüÏÔÊ¾³öÀ´
                    transaction.show(fg1);
                }
                break;
            case 1:
                found_image.setImageResource(R.drawable.ic_tabbar_found_pressed);
                found_text.setTextColor(blue);
//                found_layout.setBackgroundResource(R.drawable.ic_tabbar_bg_click);
                if (fg2 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg2 = new Fragment2();
                    transaction.add(R.id.content, fg2);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg2);
                }
                break;

            case 2:
                settings_image.setImageResource(R.drawable.ic_tabbar_settings_pressed);
                settings_text.setTextColor(blue);
//                settings_layout.setBackgroundResource(R.drawable.ic_tabbar_bg_click);
                if (fg3 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg3 = new Fragment3();
                    transaction.add(R.id.content, fg3);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg3);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (fg1 != null) {
            transaction.hide(fg1);
        }
        if (fg2 != null) {
            transaction.hide(fg2);
        }
        if (fg3 != null) {
            transaction.hide(fg3);
        }
    }

    private void clearChioce() {
        course_image.setImageResource(R.drawable.ic_tabbar_course_normal);
        course_layout.setBackgroundColor(whirt);
        course_text.setTextColor(gray);
        found_image.setImageResource(R.drawable.ic_tabbar_found_normal);
        found_layout.setBackgroundColor(whirt);
        found_text.setTextColor(gray);
        settings_image.setImageResource(R.drawable.ic_tabbar_settings_normal);
        settings_layout.setBackgroundColor(whirt);
        settings_text.setTextColor(gray);
    }
}