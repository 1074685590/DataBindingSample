package com.github.markzhai.sample.test;

import android.databinding.BaseObservable;

/**
 * Created by Administrator on 2018/11/16 0016 on 上午 9:41
 */

public class Table extends BaseObservable {

   private int width;

   private int height;

    public Table(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
