package com.lemondev.weather.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lemondev.weather.models.WeatherModel;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class WeatherResponse {

    @SerializedName("result")
    @Expose
    private WeatherModel weather;

    public WeatherModel getWeather() {
        return weather;
    }
}
