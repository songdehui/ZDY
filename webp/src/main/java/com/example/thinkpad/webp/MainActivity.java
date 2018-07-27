package com.example.thinkpad.webp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Glide.with(this)
                .load("http://misc.dyhoa.com/images/biaozhi/2/19.webp")
//                .apply(options).transition(new DrawableTransitionOptions().crossFade(200))
                .into(img);
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
    }
}
