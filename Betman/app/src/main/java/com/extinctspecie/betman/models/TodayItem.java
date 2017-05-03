package com.extinctspecie.betman.models;

/**
 * Created by WorkSpace on 5/2/2017.
 */

public class TodayItem
{

    private long id;
    private String team1;
    private String team2;
    private String odd;
    private String prediction;
    private String date_of_the_game;
    private String time_of_the_game;
    private String won_lost;

    //empty constructor
    public TodayItem()
    {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getWon_lost() {
        return won_lost;
    }

    public void setWon_lost(String won_lost) {
        this.won_lost = won_lost;
    }

//    private long id;
//    private String teamOne;
//    private String teamTwo;
//    private String odd;
//    private String prediction;
//    private String time;
//    private String result;

}
