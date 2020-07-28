package com.example.criccorner;

public class OdiAllRounder {
    private String url;
    private String rank;
    private String rating;
    private String player;
    private String country;

    public OdiAllRounder() {
    }

    public OdiAllRounder(String url, String rank, String rating, String player, String country) {
        this.url = url;
        this.rank = rank;
        this.rating = rating;
        this.player = player;
        this.country = country;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
