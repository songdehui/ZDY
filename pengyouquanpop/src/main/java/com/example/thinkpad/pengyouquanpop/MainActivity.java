package com.example.thinkpad.pengyouquanpop;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<String> mDataList;
    private List<Boolean> mCheckedList;
    private MyAdapter adapter;
    private ListView lv;
    private List<Boolean> mLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                adapter.setData(mDataList, mCheckedList,mLike);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void init() {
        mDataList = new ArrayList<String>();
        mCheckedList = new ArrayList<Boolean>();
        mLike = new ArrayList<Boolean>();

        for (int i = 0; i < 50; i++) {
            mDataList.add("数据" + i);
            mCheckedList.add(false);
            mLike.add(false);
        }
        adapter = new MyAdapter(MainActivity.this, mDataList);
        adapter.setData(mDataList, mCheckedList, mLike);
        lv.setAdapter(adapter);
    }


    private void initView() {
        lv = (ListView) findViewById(R.id.lv);
    }
}
