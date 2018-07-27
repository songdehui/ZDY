package com.example.thinkpad.assets;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    private WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        Intent intent = getIntent();
        String imgPath = intent.getStringExtra("img");
        Log.e("***",imgPath);
        web.loadUrl(imgPath);

    }

    private void initView() {
        web = (WebView) findViewById(R.id.web);


    }
}
