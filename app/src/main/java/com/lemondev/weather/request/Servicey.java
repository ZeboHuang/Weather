package com.lemondev.weather.request;

/**
 * 2022/2/7
 * Created by vibrantBobo
 */

import com.lemondev.weather.utils.Credentials;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 单例模式
 * 网络服务
 * 创建、获取Retrofit 实例
 */
public class Servicey {

    //retrofit 实例
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static WeatherApi weatherApi = retrofit.create(WeatherApi.class);

    public static WeatherApi getWeatherApi() {
        return weatherApi;
    }
}
