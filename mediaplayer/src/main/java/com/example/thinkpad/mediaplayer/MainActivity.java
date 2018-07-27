package com.example.thinkpad.mediaplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout simulation1;
    private LinearLayout simulation2;
    private LinearLayout simulation3;
    private LinearLayout simulation4;
    private BeatBox beatBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        beatBox=new BeatBox(this,"voice2");
    }

    private void initView() {
        simulation1 = (LinearLayout) findViewById(R.id.simulation1);
        simulation2 = (LinearLayout) findViewById(R.id.simulation2);
        simulation3 = (LinearLayout) findViewById(R.id.simulation3);
        simulation4 = (LinearLayout) findViewById(R.id.simulation4);
        simulation1.setOnClickListener(this);
        simulation2.setOnClickListener(this);
        simulation3.setOnClickListener(this);
        simulation4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simulation1:
                beatBox.play(beatBox.getSounds().get(0));
                break;
            case R.id.simulation2:
                beatBox.play(beatBox.getSounds().get(1));
                break;
            case R.id.simulation3:
                beatBox.play(beatBox.getSounds().get(2));
                break;
            case R.id.simulation4:
                beatBox.play(beatBox.getSounds().get(3));
                break;
        }
    }
}
