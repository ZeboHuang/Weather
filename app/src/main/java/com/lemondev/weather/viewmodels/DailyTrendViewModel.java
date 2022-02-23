package com.lemondev.weather.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.repositories.WeatherRepository;

/**
 * 2022/2/19
 * Created by vibrantBobo
 */

public class DailyTrendViewModel extends ViewModel {
    private WeatherRepository weatherRepository = WeatherRepository.getInstance();

    public MutableLiveData<WeatherModel> getWeather() {
        return weatherRepository.getWeather();
    }
}
