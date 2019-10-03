package com.example.facebookfuntest;

public class ItemClass {
    private String title;
    private String pastTime;
    private String contents;
    private String mainImg;

    public ItemClass(){

    }

    public ItemClass(String title, String pastTime, String contents, String mainImg) {
        this.title = title;
        this.pastTime = pastTime;
        this.contents = contents;
        this.mainImg = mainImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPastTime() {
        return pastTime;
    }

    public void setPastTime(String pastTime) {
        this.pastTime = pastTime;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

}

