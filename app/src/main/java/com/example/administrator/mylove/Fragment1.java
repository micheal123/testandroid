package com.example.administrator.mylove;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ourtime.TimeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/20 0020.
 */
public class Fragment1 extends Fragment {
    ViewPager mPager;
    ImageView imageView;
    List imList, pointList;
    int z[];


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg1, container,false);
        ImageButton imageButton= (ImageButton) view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), TimeView.class);
                startActivity(intent);

            }
        });
        InitViewPager(view);
        return view;
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        load lo = new load(z.length);
        lo.start();
        super.onStart();
    }

    public Handler myhandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            mPager.setCurrentItem(msg.what);
            super.handleMessage(msg);
        };

    };

    private void InitViewPager(View parentView) {
        mPager = (ViewPager) parentView.findViewById(R.id.viewPager);
        imList = new ArrayList<ImageView>();
        pointList = new ArrayList<ImageView>();
        z = new int[] { R.drawable.tab1, R.drawable.tab2,R.drawable.tab3,R.drawable.tab4,R.drawable.tab5 };
        for (int i = 0; i < z.length; i++) {
            imageView = new ImageView(getActivity());
            imageView.setBackgroundResource((z[i]));
            imList.add(imageView);
        }
        mPager.setAdapter(new MyPagerAdapter(z));
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
        mPager.setCurrentItem(0);
        mPager.setOffscreenPageLimit(4);
    }

    class load extends Thread {
        int what6;
        int index = 0;
        int T=0;

        public load(int length) {
            this.what6 = length;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (true) {
                synchronized (this) {

                    try {
                        sleep(2500);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //
               if(index==0){
                   T++;
               }
                    if (index >= what6) {
                        T++;
                    }
                      if(T%2!=0) {
                          myhandler.sendEmptyMessage(index++);
                      }else{
                          myhandler.sendEmptyMessage(--index);
                      }
                }
            }

        }

    }

    public class MyPagerAdapter extends PagerAdapter {
        private int[] ids;

        public MyPagerAdapter(int[] ids) {
            this.ids = ids;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return ids.length;
        }

        public Object instantiateItem(View container, int position) {
            ImageView imageView = (ImageView) imList.get(position);
            ViewGroup parent = (ViewGroup)imageView.getParent();
            if (parent != null) {
                parent.removeAllViews();
            }
            ((ViewPager) container).addView(imageView, 0);
            return imageView;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            ((ViewPager)container).removeView(imageView);
        }
    }


    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(z[arg0]);
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }
}}