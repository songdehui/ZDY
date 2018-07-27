package com.example.thinkpad.datijiqiao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String ASSETS_ROOT = "file:///android_asset";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void itemClick(View view) {
        ViewGroup viewGroup = (ViewGroup) view;
        //String filePath = Const.ASSETS_ROOT + "/html/course1/dtjq/" + view.getTag();
        String imgPath = ASSETS_ROOT + "/html/course1/dtjq/" + view.getTag();
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        intent.putExtra("img", imgPath);
        startActivity(intent);
    }


}
