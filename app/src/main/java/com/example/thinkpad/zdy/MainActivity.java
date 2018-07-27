package com.example.thinkpad.zdy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DragGridLayout gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("夜叉");
        strings.add("桃花");
        strings.add("青坊主");
        strings.add("烟烟罗");
        strings.add("奕");
        strings.add("兵佣");
        strings.add("镰鼬");
        strings.add("追月神");
        strings.add("鬼使黑");
        strings.add("鬼使白");
        strings.add("樱花");
        strings.add("酒吞童子");
        strings.add("茨木童子");
        strings.add("一目连");
        strings.add("辉夜姬");
        strings.add("姑获");
//        gv.setIsDragabled(true);
        gv.setItemView(strings);
    }

    private void initView() {
        gv = (DragGridLayout) findViewById(R.id.gv);
    }
}
