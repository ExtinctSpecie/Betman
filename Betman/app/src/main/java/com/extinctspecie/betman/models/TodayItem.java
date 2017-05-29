package com.extinctspecie.betman.models;

import com.extinctspecie.betman.helpers.Log;

/**
 * Created by WorkSpace on 5/2/2017.
 */

public class TodayItem {

    private String TAG = this.getClass().getSimpleName();
    private String teamOne;
    private String teamTwo;
    private String odd;
    private String prediction;
    private String timeOfGame;
    private String matchType;
    private String teamOneCountry;
    private String teamTwoCountry;

    //empty constructor
    public TodayItem() {

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

    public String getTimeOfGame() {
        return timeOfGame;
    }

    public void setTimeOfGame(String timeOfGame) {
        this.timeOfGame = timeOfGame;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getTeamOneCountry() {
        return teamOneCountry;
    }

    public void setTeamOneCountry(String teamOneCountry) {
        this.teamOneCountry = teamOneCountry;
    }

    public String getTeamTwoCountry() {
        return teamTwoCountry;
    }

    public void setTeamTwoCountry(String teamTwoCountry) {
        this.teamTwoCountry = teamTwoCountry;
    }
    public void printSelf()
    {
        Log.v(TAG,teamOne);
        Log.v(TAG,teamTwo);
        Log.v(TAG,teamOneCountry);
        Log.v(TAG,teamTwoCountry);
        Log.v(TAG,odd);
        Log.v(TAG,prediction);
        Log.v(TAG,matchType);
        Log.v(TAG,timeOfGame);

    }
}
