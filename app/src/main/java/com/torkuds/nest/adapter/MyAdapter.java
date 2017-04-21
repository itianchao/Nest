package com.torkuds.nest.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.torkuds.nest.R;

import java.util.List;

/**
 * des:MyAdapter
 * Created by torkuds
 * on 2017/4/21 0021.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<String> datas;

    public MyAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas != null ? datas.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return datas != null ? datas.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null){
            view = View.inflate(context, R.layout.item_list, null);
            holder = new ViewHolder();
            holder.textView = (TextView) view.findViewById(R.id.textView);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText(datas.get(i));
        return view;
    }

    class ViewHolder {
        TextView textView;
    }
}
