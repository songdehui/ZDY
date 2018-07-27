package com.example.thinkpad.scrollselector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Pickers> list; // 滚动选择器数据
    private String[] id;
    private String[] name;

    private Button bt_yes; // 确定按钮
    private RelativeLayout picker_rel; // 选择器布局

    private TextView tv;
    private PickerScrollView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initLinstener();
        initData();
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        pic = (PickerScrollView) findViewById(R.id.pic);

    }
    /**
     * 设置监听事件
     */
    private void initLinstener() {
        tv.setOnClickListener(onClickListener);
        pic.setOnSelectListener(pickerListener);

    }

    /**
     * 初始化数据
     */
    private void initData() {
        list = new ArrayList<Pickers>();
        id = new String[] { "1", "2", "3", "4", "5", "6" };
        name = new String[] { "中国银行", "农业银行", "招商银行", "工商银行", "建设银行", "民生银行" };
        for (int i = 0; i < name.length; i++) {
            list.add(new Pickers(name[i], id[i]));
        }
        // 设置数据，默认选择第一条
        pic.setData(list);
        pic.setSelected(0);
    }

    // 滚动选择器选中事件
    PickerScrollView.onSelectListener pickerListener = new PickerScrollView.onSelectListener() {

        @Override
        public void onSelect(Pickers pickers) {
            System.out.println("选择：" + pickers.getShowId() + "--银行："
                    + pickers.getShowConetnt());
        }
    };

    // 点击监听事件
    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v == tv) {
                picker_rel.setVisibility(View.VISIBLE);
            } else if (v == bt_yes) {
                picker_rel.setVisibility(View.GONE);
            }
        }
    };
}
