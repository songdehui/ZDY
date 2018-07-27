package com.example.thinkpad.listview_select;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.all)
    Button all;
    @Bind(R.id.un_all)
    Button unAll;
    @Bind(R.id.no)
    Button no;
    @Bind(R.id.delete)
    Button delete;
    @Bind(R.id.lv)
    ListView lv;
    private List<String> mDataList;
    private List<Boolean> mCheckedList;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mDataList = new ArrayList<String>();
        mCheckedList = new ArrayList<Boolean>();

        for (int i = 0; i < 50; i++) {
            mDataList.add("数据" + i);
            mCheckedList.add(false);
        }
        adapter = new MyAdapter(MainActivity.this, mDataList);
        adapter.setData(mDataList, mCheckedList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCheckedList.set(position, !mCheckedList.get(position));
                adapter.setData(mDataList, mCheckedList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @OnClick({R.id.all, R.id.un_all, R.id.no, R.id.delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.all:
                select_all();
                break;
            case R.id.un_all:
                un_select();
                break;
            case R.id.no:
                cancel();
                break;
            case R.id.delete:
                delete();
                break;
        }
    }

    private void select_all() {
        for (int i = 0; i < mCheckedList.size(); i++) {
            mCheckedList.set(i, true);
        }
        adapter.setData(mDataList, mCheckedList);
        adapter.notifyDataSetChanged();

    }

    private void un_select() {
        for (int i = 0; i < mCheckedList.size(); i++) {
            mCheckedList.set(i, !mCheckedList.get(i));
        }
        adapter.setData(mDataList, mCheckedList);
        adapter.notifyDataSetChanged();

    }

    private void cancel() {
        for (int i = 0; i < mCheckedList.size(); i++) {
            if (mCheckedList.get(i)) {
                mCheckedList.set(i, false);
            }
        }
        adapter.setData(mDataList, mCheckedList);
        adapter.notifyDataSetChanged();
    }

    private void delete() {
        for (int i = 0; i < mCheckedList.size(); i++) {
            if (mCheckedList.get(i)) {
                mCheckedList.remove(i);
                mDataList.remove(i);
                i--;
            }
        }
        adapter.setData(mDataList, mCheckedList);
        adapter.notifyDataSetChanged();
    }
}
