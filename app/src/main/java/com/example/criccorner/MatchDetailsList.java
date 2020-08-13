package com.example.criccorner;

public class MatchDetailsList {
    String url;
    String match_details;

    public MatchDetailsList(String url, String match_details) {
        this.url = url;
        this.match_details = match_details;
    }

    public MatchDetailsList() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMatch_details() {
        return match_details;
    }

    public void setMatch_details(String match_details) {
        this.match_details = match_details;
    }
}
