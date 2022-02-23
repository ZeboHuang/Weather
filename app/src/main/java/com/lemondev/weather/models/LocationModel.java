package com.lemondev.weather.models;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class LocationModel {
    private String longitude;   //经度
    private String latitude;    //纬度

    public LocationModel(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLocation() {
        return longitude + "," + latitude;
    }
}
