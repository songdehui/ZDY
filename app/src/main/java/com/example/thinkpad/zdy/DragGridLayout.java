package com.example.thinkpad.zdy;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 宋德慧
 * time: 2018/7/19-9:48.
 * email: m18201222438@163.com
 * tel: 15836320932
 */
public class DragGridLayout extends GridLayout {
    public DragGridLayout(Context context) {
        this(context, null);
    }

    public DragGridLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setColumnCount(4);
        setLayoutTransition(new LayoutTransition());
    }

    private int margin = 10;

    public void setItemView(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            TextView textView = new TextView(getContext());
            textView.setText(list.get(i));
            textView.setTextSize(17);
            int tv_width = getResources().getDisplayMetrics().widthPixels / getColumnCount() - margin * 2;
            textView.setWidth(tv_width);
            textView.setEnabled(true);
            textView.setBackgroundResource(R.drawable.shape);
            textView.setGravity(Gravity.CENTER);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.setMargins(margin, margin, margin, margin);
            textView.setLayoutParams(layoutParams);
            addView(textView);
        }
    }
}
