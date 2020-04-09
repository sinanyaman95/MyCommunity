package com.humber.saynn.mycommunity.entities;

public class Food {

    private String description;
    private int imageId;
    private String url;
    private String nationality;

    public Food(String description, int imageId,String url) {
        this(description,imageId,url,"general");
    }

    public Food(String description, int imageId,String url, String nationality) {
        this.description = description;
        this.imageId = imageId;
        this.url = url;
        this.nationality = nationality;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
