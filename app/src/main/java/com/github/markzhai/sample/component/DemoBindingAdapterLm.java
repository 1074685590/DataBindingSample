package com.github.markzhai.sample.component;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2018/11/16 0016 on 下午 4:45
 */

public class DemoBindingAdapterLm {

    @BindingAdapter({"loadUrl","placeholder"})
    public static void loadImgFromUrl(ImageView imageView, String url , Drawable drawable){
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(drawable)
                .into(imageView);
    }
}
