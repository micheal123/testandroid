package com.example.administrator.mylove;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/19 0019.
 */
public class MessageAdapter extends BaseAdapter {
    private Context context;
 List<MessageDao> list = new ArrayList<MessageDao>();

    public MessageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = View.inflate(context, R.layout.title2, null);
        TextView detialText = (TextView) convertView
                .findViewById(R.id.Detail);
        TextView MainText = (TextView) convertView
                .findViewById(R.id.Item_MainText1);
//        ImageView imageView= (ImageView) convertView.findViewById(R.id.imageView_touxiang);
        MessageDao time = list.get(position);
        detialText.setText(time.getDetail());
        MainText.setText(time.getTime());
//        imageView.setImageResource(R.drawable.tou1);
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

    public void addList(MessageDao MessageDao) {
        list.add(MessageDao);
    }

    @Override
    public int getCount() {

        return list.size();
    }
}
