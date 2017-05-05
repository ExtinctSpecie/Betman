package com.extinctspecie.betman.services;

import com.extinctspecie.betman.helpers.Information;
import com.extinctspecie.betman.models.TodayItem;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by WorkSpace on 5/2/2017.
 */

public interface ITodayService {


    //put end point in @GET
    @GET("today_free")
    Call<List<TodayItem>> getTodayItems();

    public class Factory {
        private static ITodayService service;

        public static ITodayService getInstance() {
            if (service == null) {

                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(Information.getBaseUrl()).build();
                ITodayService service = retrofit.create(ITodayService.class);
                return service;
            } else {
                return service;
            }
        }


    }

}
