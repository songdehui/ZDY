package com.example.thinkpad.datijiqiao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        Intent intent = getIntent();
        String img = intent.getStringExtra("img");
        web.loadUrl(img);
    }

    private void initView() {
        web = (WebView) findViewById(R.id.web);
    }
}
