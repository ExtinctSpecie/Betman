package com.extinctspecie.betman.services;

import com.extinctspecie.betman.helpers.Information;
import com.extinctspecie.betman.models.NewsFeedItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by WorkSpace on 29-Jun-17.
 */

public interface INewsFeedService
{
    //put end point in @GET
    @GET("newsfeed")
    Call<List<NewsFeedItem>> getNewsFeedItems();

    public class Factory {
        private static INewsFeedService service;

        public static INewsFeedService getInstance() {
            if (service == null) {

                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(Information.getBaseUrl()).build();
                service = retrofit.create(INewsFeedService.class);
                return service;
            } else {
                return service;
            }
        }


    }
}
