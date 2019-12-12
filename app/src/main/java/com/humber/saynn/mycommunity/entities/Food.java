package com.humber.saynn.mycommunity.entities;

public class Food {

    private String description;
    private int imageId;
    private String url;

    public Food(String description, int imageId,String url) {
        this.description = description;
        this.imageId = imageId;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
