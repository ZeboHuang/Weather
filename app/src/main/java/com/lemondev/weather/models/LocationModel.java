package com.lemondev.weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class LocationModel implements Parcelable{

    @SerializedName("lng")
    private String longitude;   //经度

    @SerializedName("lat")
    private String latitude;    //纬度

    public LocationModel(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    protected LocationModel(Parcel in) {
        longitude = in.readString();
        latitude = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(longitude);
        dest.writeString(latitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LocationModel> CREATOR = new Creator<LocationModel>() {
        @Override
        public LocationModel createFromParcel(Parcel in) {
            return new LocationModel(in);
        }

        @Override
        public LocationModel[] newArray(int size) {
            return new LocationModel[size];
        }
    };

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
