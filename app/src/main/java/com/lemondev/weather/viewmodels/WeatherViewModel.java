package com.lemondev.weather.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.repositories.WeatherRepository;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class WeatherViewModel extends ViewModel {
    //ViewModel 依赖 Repository

    private WeatherRepository weatherRepository = WeatherRepository.getInstance();


    public MutableLiveData<WeatherModel> getWeather() {
        return weatherRepository.getWeather();
    }
}
