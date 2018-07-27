package com.example.thinkpad.assets;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 宋德慧
 * time: 2018/7/19-20:22.
 * email: m18201222438@163.com
 * tel: 15836320932
 */
public class CheatsAdapter extends BaseQuickAdapter<CheatsBean, BaseViewHolder> {
    public CheatsAdapter(int layoutResId, @Nullable List<CheatsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CheatsBean item) {
        helper.setText(R.id.cheats_title, item.getTitle()).setText(R.id.cheats_simpleContent, item.getSimleContent());
        String img = "assets://html/course" + 3 + "/mj/images/" + item.getImageName();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));
        imageLoader.displayImage(img, (ImageView) helper.getView(R.id.cheats_icon));
    }
}
