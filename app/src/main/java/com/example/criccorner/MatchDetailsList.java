package com.example.criccorner;

public class MatchDetailsList {
    String url;
    String team1;
    String team2;
    String safe_eleven1;
    String safe_eleven2;
    String safe_eleven3;
    String full_squad1;
    String full_squad2;
    String probable_eleven1;
    String probable_eleven2;

    public MatchDetailsList(String url, String team1, String team2, String safe_eleven1, String safe_eleven2, String safe_eleven3, String full_squad1, String full_squad2, String probable_eleven1, String probable_eleven2) {
        this.url = url;
        this.team1 = team1;
        this.team2 = team2;
        this.safe_eleven1 = safe_eleven1;
        this.safe_eleven2 = safe_eleven2;
        this.safe_eleven3 = safe_eleven3;
        this.full_squad1 = full_squad1;
        this.full_squad2 = full_squad2;
        this.probable_eleven1 = probable_eleven1;
        this.probable_eleven2 = probable_eleven2;
    }

    public MatchDetailsList() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getSafe_eleven1() {
        return safe_eleven1;
    }

    public void setSafe_eleven1(String safe_eleven1) {
        this.safe_eleven1 = safe_eleven1;
    }

    public String getSafe_eleven2() {
        return safe_eleven2;
    }

    public void setSafe_eleven2(String safe_eleven2) {
        this.safe_eleven2 = safe_eleven2;
    }

    public String getSafe_eleven3() {
        return safe_eleven3;
    }

    public void setSafe_eleven3(String safe_eleven3) {
        this.safe_eleven3 = safe_eleven3;
    }

    public String getFull_squad1() {
        return full_squad1;
    }

    public void setFull_squad1(String full_squad1) {
        this.full_squad1 = full_squad1;
    }

    public String getFull_squad2() {
        return full_squad2;
    }

    public void setFull_squad2(String full_squad2) {
        this.full_squad2 = full_squad2;
    }

    public String getProbable_eleven1() {
        return probable_eleven1;
    }

    public void setProbable_eleven1(String probable_eleven1) {
        this.probable_eleven1 = probable_eleven1;
    }

    public String getProbable_eleven2() {
        return probable_eleven2;
    }

    public void setProbable_eleven2(String probable_eleven2) {
        this.probable_eleven2 = probable_eleven2;
    }
}

