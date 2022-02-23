package com.lemondev.weather.repositories;

import androidx.lifecycle.MutableLiveData;

import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.request.WeatherApiClient;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class WeatherRepository {
    //Repository 依赖 网络请求层

    private static WeatherRepository instance;


    public static WeatherRepository getInstance() {
        if (instance == null) {
            synchronized (WeatherRepository.class) {
                if (instance == null) {
                    instance = new WeatherRepository();
                }
            }
        }
        return instance;
    }

    public MutableLiveData<WeatherModel> getWeather() {
        return WeatherApiClient.getInstance().getWeather();
    }
}
