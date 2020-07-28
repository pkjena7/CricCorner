package com.example.criccorner;


public class Schedule {
    private String url1;
    private String url2;
    private String team1;
    private String team2;
    private String date;
    private String time;
    private String location;
    private String day;
    private String match_no;

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMatch_no() {
        return match_no;
    }

    public void setMatch_no(String match_no) {
        this.match_no = match_no;
    }

    public Schedule(String url1, String url2, String team1, String team2, String date, String time, String location, String day, String match_no) {
        this.url1 = url1;
        this.url2 = url2;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.time = time;
        this.location = location;
        this.day = day;
        this.match_no = match_no;
    }

    public Schedule() {
    }
}