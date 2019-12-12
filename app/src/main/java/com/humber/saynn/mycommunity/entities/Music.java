package com.humber.saynn.mycommunity.entities;

public class Music {

    private String singer;
    private int imageId;

    public Music(String singer, int imageId) {
        this.singer = singer;
        this.imageId = imageId;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
