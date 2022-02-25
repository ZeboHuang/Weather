package com.lemondev.weather.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lemondev.weather.models.PlaceModel;
import com.lemondev.weather.repositories.PlaceRepository;

import java.util.List;

/**
 * 2022/2/25
 * Created by vibrantBobo
 */

public class PlaceViewModel extends ViewModel {
    private PlaceRepository placeRepository = PlaceRepository.getInstance();

    public MutableLiveData<List<PlaceModel>> getPlaces() {
        return placeRepository.getPlaces();
    }
}
