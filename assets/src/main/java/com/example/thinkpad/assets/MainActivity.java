package com.example.thinkpad.assets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String ASSETS_ROOT = "file:///android_asset";


    private List<CheatsBean> cheatsList = new ArrayList<CheatsBean>();

    private CheatsAdapter cheatsAdapter;

    private int course;
    private RecyclerView widget_listview;
    private String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        course = getIntent().getIntExtra("course", 3);
        cheatsAdapter = new CheatsAdapter(R.layout.listview_item_cheats, cheatsList);
        widget_listview.setLayoutManager(new LinearLayoutManager(this));
        widget_listview.setAdapter(cheatsAdapter);

        cheatsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String imgPath = ASSETS_ROOT + "/html/course" + course + "/mj/" + cheatsList.get(position).getHtmlName();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                intent.putExtra("img", imgPath);
                startActivity(intent);
            }
        });

        if (course == 2) {
            cheatsList.add(new CheatsBean("倒车入库技巧图解", "自从驾考改革之后，考场上已经看不见标杆了，有的只是地上的黄线，而且还取消了移库。没有标杆这倒库可要怎么倒进去呀，今天就给大家准备全新的科目二倒车入库技巧。", "list_1.jpg", "dcrkjqtj.html"));
            cheatsList.add(new CheatsBean("侧方停车考试易出错点解析", "据了解，科目二考试中，多数考生败在了侧方停车和倒车入库这两项中，对此，小编总结了侧方停车考试的易出错点，大家不妨前来看看！", "list_2.jpg", "cftcksy.html"));
            cheatsList.add(new CheatsBean("坡路定点停车和起步技巧图解", "道起步最怕熄火、倒溜，要注意三个步骤首先是轻带油门，慢松离合器；其次是一旦感觉车子已有向前的动力，就应松手刹，同时略加油门；最后是车子一经起步，就慢慢松开离合器。", "list_3.jpg", "plddtc.html"));
            cheatsList.add(new CheatsBean("曲线行驶考试攻略", "前期准备首先：调整座椅位置，使踩踏离合器和脚刹、油门时较舒服（尤其是便于使离合器处于半离合状态）其次：调整左后视镜，使车身占后视镜约1/5（即在左后视镜中可以看见车左后下方）", "list_4.jpg", "qxxsks.html"));
            cheatsList.add(new CheatsBean("东岳驾校科目二真实考试视屏", "东岳驾校科目二真实考试视频一览", "list_5.png", "http://api.dyhoa.com/dweixin/h5/43/video.html"));
        } else {
            cheatsList.add(new CheatsBean("科目三考试通关技巧", "2015年新交规科目三（大路考）考试由原来的13项道路驾驶技能项目增加到16项，并且考试里程不少于3公里，其中需抽取不少于20%进行夜间考试；不进行夜间考试的考生，应当进行模拟夜间灯光使用考试。", "list_1.jpg", "k3ksggjq.html"));
            cheatsList.add(new CheatsBean("最容易忽略的9条扣分点", "科目三相较于科目二来说是比较简单的，但是为什么很多考生都不能顺利通过，多半是因为大意，不注重细节所以才导致了科目三考试的失败。给大家介绍关于科目三考试中最容易被考生忽略的9条扣分点，希望能给大家做个参考。", "list_2.jpg", "zryhl.html"));
            cheatsList.add(new CheatsBean("夜考注意事项", "一般情况下，夜考行驶距离要比路考短，控制好速度，把握好灯光，还是很容易通过的。夜考主要考你会不会亮灯，以及对汽车灯光的熟练运用。考试中，若能正确使用和变换灯光，并且没有其他重大操作失误，就可及格。", "list_3.jpg", "ykzysx.html"));
            cheatsList.add(new CheatsBean("东岳驾校科目三考试线路图", "东岳驾校科目三小型车路考线路图", "list_4.png", "http://api.dyhoa.com/dweixin/h5/43/index.html"));
        }

    }

    private void initView() {
        widget_listview = (RecyclerView) findViewById(R.id.widget_listview);
    }
}
