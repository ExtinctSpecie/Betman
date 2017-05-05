package com.extinctspecie.betman.models;

/**
 * Created by WorkSpace on 5/2/2017.
 */

public class TodayItem
{

    private long id;
    private String teamOne;
    private String teamTwo;
    private String odd;
    private String prediction;
    private String dateOfGame;
    private String timeOfGame;

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

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
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

    public String getDateOfGame() {
        return dateOfGame;
    }

    public void setDateOfGame(String dateOfGame) {
        this.dateOfGame = dateOfGame;
    }

    public String getTimeOfGame() {
        return timeOfGame;
    }

    public void setTimeOfGame(String timeOfGame) {
        this.timeOfGame = timeOfGame;
    }

//    private long id;
//    private String teamOne;
//    private String teamTwo;
//    private String odd;
//    private String prediction;
//    private String time;
//    private String result;

}
