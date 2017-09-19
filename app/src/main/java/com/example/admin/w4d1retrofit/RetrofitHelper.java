package com.example.admin.w4d1retrofit;

import com.example.admin.w4d1retrofit.model.WeatherResponse;

import java.security.acl.Owner;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Luis Aguirre on 9/6/2017.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "https://api.openweathermap.org/";
    public static final String APPID = "57995bc3940d707ce01f87253f710814";

    public static Retrofit create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }

    //create a static method to use the interface verbs
    public static Call<WeatherResponse> createCall(String city) {

        Retrofit retrofit = create();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService.getWeather(city, APPID);
    }

    //create an interface to have all the paths and verbs for the rest api
    interface ApiService {
        @GET("data/2.5/forecast")
        //@Headers()
        Call<WeatherResponse> getWeather(@Query("q") String city, @Query("APPID") String APPID);
    }
}

