package com.bawei.listview_checkbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yufuhao on 2017/6/7.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Bean> list;

    public MyAdapter(Context context, List<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = convertView.inflate(context, R.layout.listview, null);
            viewHolder = new ViewHolder();
            viewHolder.tv = (TextView) convertView.findViewById(R.id.tv);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv.setText(list.get(position).getStr());


        viewHolder.checkBox.setChecked(list.get(position).isBoo());

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).isBoo()) {
                    list.get(position).setBoo(false);
                    viewHolder.checkBox.setChecked(false);
                }else{
                    list.get(position).setBoo(true);
                    viewHolder.checkBox.setChecked(true);
                }
                //点击监听,保存checkbox的状态
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    class ViewHolder {
        TextView tv;
        CheckBox checkBox;
    }
}
