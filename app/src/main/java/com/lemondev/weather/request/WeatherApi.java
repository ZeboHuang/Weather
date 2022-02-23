package com.lemondev.weather.request;

import com.lemondev.weather.response.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 2022/2/7
 * Created by vibrantBobo
 */

public interface WeatherApi {

    @GET("/v2.5/{api_key}/{longitude},{latitude}/weather.json")
    Call<WeatherResponse> update(
            @Path("api_key") String api_key,
            @Path("longitude") String longitude,
            @Path("latitude") String latitude,
            @Query("hourlysteps") int hourlysteps,
            @Query("dailysteps") int dailysteps
    );


}
