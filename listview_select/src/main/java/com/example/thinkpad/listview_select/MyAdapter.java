package com.example.thinkpad.listview_select;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 宋德慧
 * time: 2018/7/20-10:48.
 * email: m18201222438@163.com
 * tel: 15836320932
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;
    private List<Boolean> mCheckedList;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public void setData(List<String> list, List<Boolean> mCheckedList) {
        this.list = list;
        this.mCheckedList = mCheckedList;
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
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item, null);
            viewHolder = new ViewHolder(view);
            viewHolder.tv = view.findViewById(R.id.tv);
            viewHolder.mCB = view.findViewById(R.id.mCB);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv.setText(list.get(position));
        viewHolder.mCB.setChecked(mCheckedList.get(position));
        viewHolder.mCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCheckedList.set(position, isChecked);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv;
        public CheckBox mCB;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.mCB = (CheckBox) rootView.findViewById(R.id.mCB);
        }

    }
}
