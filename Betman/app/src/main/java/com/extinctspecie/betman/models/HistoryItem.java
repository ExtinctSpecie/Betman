package com.extinctspecie.betman.models;

import com.extinctspecie.betman.helpers.Log;

/**
 * Created by gomes on 4/5/2017.
 */

public class HistoryItem {

    private String teamOne;
    private String teamTwo;
    private String odd;
    private String prediction;
    private String finalScore;
    private String result;
    private String dateOfGame;
    private String timeOfGame;
    private String matchType;


    //empty constructor
    public HistoryItem()
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

    public String getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(String finalScore) {
        this.finalScore = finalScore;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public void printItem()
    {
        if(teamOne != null)
            Log.v("HistoryItem : ",teamOne);
        if(teamTwo != null)
            Log.v("HistoryItem : ",teamTwo);
        if(odd != null)
            Log.v("HistoryItem : ",odd);
        if(prediction != null)
            Log.v("HistoryItem : ",prediction);
        if(timeOfGame != null)
            Log.v("HistoryItem : ",timeOfGame);
        if(dateOfGame != null)
            Log.v("HistoryItem : ",dateOfGame);
        if(matchType != null)
            Log.v("HistoryItem : ",matchType);
        if(result != null)
            Log.v("HistoryItem : ",result);
        if(finalScore != null)
            Log.v("HistoryItem : ",finalScore);
    }
}
