package com.extinctspecie.betman.services;

import com.extinctspecie.betman.helpers.Information;
import com.extinctspecie.betman.models.VIPLiveItem;
import com.extinctspecie.betman.models.VIPTipsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by WorkSpace on 5/6/2017.
 */

public interface IVIPTipsService
{
    //put end point in @GET
    @GET("today_vip_tips")
    Call<List<VIPTipsItem>> getVIPTipsItems();

    public class Factory {
        private static IVIPTipsService service;

        public static IVIPTipsService getInstance() {
            if (service == null) {

                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(Information.getBaseUrl()).build();
                IVIPTipsService service = retrofit.create(IVIPTipsService.class);
                return service;
            } else {
                return service;
            }
        }


    }
}
