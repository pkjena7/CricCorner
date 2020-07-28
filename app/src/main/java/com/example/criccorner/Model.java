package com.example.criccorner;

public class Model {
    private String url;
    private String rank;
    private String rating;
    private String team;

    public Model(String url, String rank, String rating, String team) {
        this.url = url;
        this.rank = rank;
        this.rating = rating;
        this.team = team;
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Model() {
    }
}
