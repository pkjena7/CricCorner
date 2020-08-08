package com.example.criccorner;

public class NewsDetails {
    private String news;
    private String url;

    public NewsDetails() {
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public NewsDetails(String news, String url) {
        this.news = news;
        this.url = url;
    }
}
