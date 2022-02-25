package com.lemondev.weather.response;

import com.lemondev.weather.models.LocationModel;
import com.lemondev.weather.models.PlaceModel;

import java.util.List;

/**
 * 2022/2/25
 * Created by vibrantBobo
 */

public class PlaceResponse {

    private String status;
    private String query;
    private List<PlaceModel> places;


    public String getStatus() {
        return status;
    }

    public String getQuery() {
        return query;
    }

    public List<PlaceModel> getPlaces() {
        return places;
    }
}
