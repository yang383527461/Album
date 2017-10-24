package com.ygy.album.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2017/10/23.
 */

public class MultipleItem implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int SWITCH = 2;
    public static final int IMG_TEXT = 3;
    public static final int TEXT_SPAN_SIZE = 3;
    public static final int IMG_SPAN_SIZE = 1;
    public static final int IMG_TEXT_SPAN_SIZE = 4;
    public static final int IMG_TEXT_SPAN_SIZE_MIN = 2;
    private int itemType;
    private int spanSize;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MultipleItem(int itemType, int spanSize, String content, String url){
        this.itemType = itemType;
        this.spanSize = spanSize;
        this.content = content;
        this.url = url;
    }
    public MultipleItem(int itemType, int spanSize, String content) {
        this.itemType = itemType;
        this.spanSize = spanSize;
        this.content = content;
    }

    public MultipleItem(int itemType, int spanSize) {
        this.itemType = itemType;
        this.spanSize = spanSize;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}