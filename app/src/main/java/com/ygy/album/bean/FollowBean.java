package com.ygy.album.bean;

/**
 * Created by Administrator on 2017/10/20.
 */

public class FollowBean {
    private String imgUrl;
    private String name;

    public FollowBean(String imgUrl, String name) {
        this.imgUrl = imgUrl;
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
