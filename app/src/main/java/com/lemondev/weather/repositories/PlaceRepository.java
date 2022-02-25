package com.lemondev.weather.repositories;

import androidx.lifecycle.MutableLiveData;

import com.lemondev.weather.models.PlaceModel;
import com.lemondev.weather.request.WeatherApiClient;

import java.util.List;

/**
 * 2022/2/25
 * Created by vibrantBobo
 */

public class PlaceRepository {
    //Repository 依赖 网络请求层

    private static PlaceRepository instance;

    public static PlaceRepository getInstance() {
        if (instance == null) {
            synchronized (PlaceRepository.class) {
                if (instance == null) {
                    instance = new PlaceRepository();
                }
            }
        }
        return instance;
    }

    public MutableLiveData<List<PlaceModel>> getPlaces() {
        return WeatherApiClient.getInstance().getPlaces();
    }
}
