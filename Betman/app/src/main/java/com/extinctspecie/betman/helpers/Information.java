package com.extinctspecie.betman.helpers;

/**
 * Created by WorkSpace on 5/2/2017.
 */

public class Information
{
    static String baseURL = "https://bet-man.herokuapp.com/api/";
    static boolean adShown = false;

    public static boolean isAdShown() {
        return adShown;
    }

    public static void setAdShown(boolean adShown) {
        Information.adShown = adShown;
    }

    public static String getBaseUrl()
    {
        return baseURL;
    }

}
