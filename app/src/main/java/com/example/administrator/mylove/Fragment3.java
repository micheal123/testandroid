package com.example.administrator.mylove;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/20 0020.
 */
public class Fragment3 extends Fragment {
    ViewPager viewPager;
    private ImageView[] tips;

    private ImageView imageView;

    private int[] imgIdArray ;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fg3, container,false);
//        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
//        imgIdArray = new int[]{R.drawable.tab1,R.drawable.tab2};
//        tips = new ImageView[imgIdArray.length];
//        for(int i=0; i<tips.length; i++){
//            ImageView imageView = new ImageView(getActivity());
//
//            //¿ØÖÆµã¼ä¾àÀë
//            LinearLayout.LayoutParams ll= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            ll.setMargins(5, 0, 5, 0);
//            imageView.setLayoutParams(ll);
//
//
//            tips[i] = imageView;
//            if(i == 0){
//                tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
//            }else{
//                tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
//            }
//
//            linearLayout.addView(imageView);
//        }
//        PagerAdapter pagerAdapter = new PagerAdapter() {
//
//            @Override
//            public boolean isViewFromObject(View arg0, Object arg1) {
//
//                return arg0 == arg1;
//            }
//
//            @Override
//            public int getCount() {
//
//                return viewList.size();
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position,
//                                    Object object) {
//
//
//            }
//
//            @Override
//            public int getItemPosition(Object object) {
//
//                return super.getItemPosition(object);
//            }
//
//            @Override
//            public CharSequence getPageTitle(int position) {
//
//                return titleList.get(position);//直接用适配器来完成标题的显示，所以从上面可以看到，我们没有使用PagerTitleStrip。当然你可以使用。
//
//            }
//
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//
//
//                return view;
//            }
//
//        };
//        viewPager.setAdapter(pagerAdapter);

        return view;
    }

}
