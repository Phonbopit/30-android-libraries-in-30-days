package com.devahoy.learn30androidlibraries.day17;

public class Website {
    String title;
    String url;
    int imageResourceId;

    public Website(String title, String url, int imgId) {
        this.title = title;
        this.url = url;
        this.imageResourceId = imgId;
    }

    public String getTitle() {
        return title;
    }
    public String getUrl() {
        return url;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
}
