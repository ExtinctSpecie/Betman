package com.extinctspecie.betman.models;

/**
 * Created by WorkSpace on 5/6/2017.
 */

public class VIPLiveItem
{
    private String teamOne;
    private String teamTwo;
    private String odd;
    private String prediction;


    //Empty constructor
    public VIPLiveItem()
    {

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
}