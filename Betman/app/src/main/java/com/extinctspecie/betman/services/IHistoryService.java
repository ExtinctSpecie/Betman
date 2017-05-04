package com.extinctspecie.betman.services;

import com.extinctspecie.betman.helpers.Information;
import com.extinctspecie.betman.models.HistoryItem;
import com.extinctspecie.betman.models.TodayItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by WorkSpace on 5/4/2017.
 */

public interface IHistoryService {
    //put end point in @GET
    @GET("history")
    Call<List<HistoryItem>> getHistoryItems();

    public class Factory {
        private static IHistoryService service;

        public static IHistoryService getInstance() {
            if (service == null) {

                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(Information.getBaseUrl()).build();
                IHistoryService service = retrofit.create(IHistoryService.class);
                return service;
            } else {
                return service;
            }
        }

    }
}
