package com.example.thinkpad.pengyouquanpop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    private List<Boolean> mLike;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public void setData(List<String> list, List<Boolean> mCheckedList, List<Boolean> mLike) {
        this.list = list;
        this.mCheckedList = mCheckedList;
        this.mLike = mLike;
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
            viewHolder.dianzan = view.findViewById(R.id.dianzan);
            viewHolder.li = view.findViewById(R.id.li);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv.setText(list.get(position));
        final ViewHolder finalViewHolder = viewHolder;

        if (mCheckedList.get(position) == true) {
            viewHolder.li.setVisibility(View.VISIBLE);
        } else {
            viewHolder.li.setVisibility(View.GONE);
        }
        if (mLike.get(position) == false) {
            viewHolder.like.setText("赞");
        } else {
            viewHolder.like.setText("取消");
        }


        final ViewHolder finalViewHolder1 = viewHolder;
        final ViewHolder finalViewHolder2 = viewHolder;
        viewHolder.dianzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mCheckedList.size(); i++) {
                    if (i == position) {
                        mCheckedList.set(i, !mCheckedList.get(position));
                    } else {
                        mCheckedList.set(i, false);
                    }
                }

                finalViewHolder1.like.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mLike.set(position, !mLike.get(position));
                        notifyDataSetChanged();
                    }
                });
                notifyDataSetChanged();
            }
        });
        return view;
    }


    class ViewHolder {
        public View rootView;
        public TextView tv;
        public ImageView img;
        public TextView like;
        public TextView comment;
        public LinearLayout li;
        public ImageView dianzan;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.like = (TextView) rootView.findViewById(R.id.like);
            this.comment = (TextView) rootView.findViewById(R.id.comment);
            this.li = (LinearLayout) rootView.findViewById(R.id.li);
            this.dianzan = (ImageView) rootView.findViewById(R.id.dianzan);
        }

    }
}
