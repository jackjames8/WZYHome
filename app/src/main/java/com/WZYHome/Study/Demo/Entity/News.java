package com.WZYHome.Study.Demo.Entity;

/**
 * Created by Administrator on 2018/7/25.
 */

public class News {
    private String title;
    private int resId;

    public News(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
