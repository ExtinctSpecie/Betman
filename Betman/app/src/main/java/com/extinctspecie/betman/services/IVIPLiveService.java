package com.extinctspecie.betman.services;

import com.extinctspecie.betman.helpers.Information;
import com.extinctspecie.betman.models.TodayItem;
import com.extinctspecie.betman.models.VIPLiveItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by WorkSpace on 5/6/2017.
 */

public interface IVIPLiveService
{
    //put end point in @GET
    @GET("today_vip_live")
    Call<List<VIPLiveItem>> getVIPLiveItems();

    public class Factory {
        private static IVIPLiveService service;

        public static IVIPLiveService getInstance() {
            if (service == null) {

                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(Information.getBaseUrl()).build();
                service = retrofit.create(IVIPLiveService.class);
                return service;
            } else {
                return service;
            }
        }


    }
}
