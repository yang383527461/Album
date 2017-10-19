package com.ygy.album.bean;

/**
 * Created by Administrator on 2017/10/19.
 */

public class Songbean {

    /**
     * songId : 1
     * songName : Despacito
     * songImg : http://p1.music.126.net/V8RPaL2lZFprtZ8Mfs7YTQ==/17799993742463224.jpg?param=130y130
     * songUrl : http://v4.music.126.net/20170914205030/9de09a9059e2861b21d3145dd1ec02f2/web/cloudmusic/YCEhICAiIWI1ISAxMSEiMA==/mv/5617127/f4c98c76d55ba16958fcdf555c129069.mp4
     * singer : Luis Fonsi / Daddy Yankee
     * type : 欧美
     */

    private int songId;
    private String songName;
    private String songImg;
    private String songUrl;
    private String singer;
    private String type;

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongImg() {
        return songImg;
    }

    public void setSongImg(String songImg) {
        this.songImg = songImg;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
