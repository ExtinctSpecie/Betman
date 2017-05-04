package com.extinctspecie.betman.models;

/**
 * Created by gomes on 4/5/2017.
 */

public class HistoryItem {

    private String team1;
    private String team2;
    private String odd;
    private String prediction;
    private String finish_score;
    private String result;
    private String date_of_the_game;
    private String time_of_the_game;

    public HistoryItem() {
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

    public String getOdd() {
        return odd;
    }

    public void setOdd(String odd) {
        this.odd = odd;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public String getFinish_score() {
        return finish_score;
    }

    public void setFinish_score(String finish_score) {
        this.finish_score = finish_score;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate_of_the_game() {
        return date_of_the_game;
    }

    public void setDate_of_the_game(String date_of_the_game) {
        this.date_of_the_game = date_of_the_game;
    }

    public String getTime_of_the_game() {
        return time_of_the_game;
    }

    public void setTime_of_the_game(String time_of_the_game) {
        this.time_of_the_game = time_of_the_game;
    }
}
