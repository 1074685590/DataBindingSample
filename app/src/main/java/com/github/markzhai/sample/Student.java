package com.github.markzhai.sample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableBoolean;

/**
 * Created by Administrator on 2018/11/16 0016 on 上午 9:41
 */

public class Student extends BaseObservable {
    private String name;
    private int    age;
    private String url;

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    public ObservableArrayMap<String, String> user = new ObservableArrayMap<>();

    public ObservableBoolean isFired = new ObservableBoolean();


    public Student(String name, int age, boolean isFired) {
        this.name = name;
        this.age = age;
        setIsFired(isFired);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        setIsFired(false);

    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }


    public void setIsFired(boolean isFired) {
        this.isFired.set(isFired);
    }
}
