package com.ourtime;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import com.example.administrator.mylove.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/19 0019.
 */
public class TimeAdapter extends BaseAdapter {
    private Context context;
    private List<TimeDao> list = new ArrayList<TimeDao>();

    public TimeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = View.inflate(context, R.layout.title, null);
        TextView detialText = (TextView) convertView
                .findViewById(R.id.Detail_UserName);
        TextView MainText = (TextView) convertView
                .findViewById(R.id.Item_MainText);
       TimeDao time = list.get(position);
        detialText.setText(time.getDetail());
        MainText.setText(time.getDay());

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void addList(TimeDao timeDao) {
        list.add(timeDao);
    }
    @Override
    public int getCount() {

        return list.size();
    }
}
