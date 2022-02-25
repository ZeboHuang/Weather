package com.lemondev.weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * 2022/2/25
 * Created by vibrantBobo
 */

public class PlaceModel implements Parcelable{
    private String id;
    private String name;
    private String formatted_address;
    private LocationModel location;


    protected PlaceModel(Parcel in) {
        id = in.readString();
        name = in.readString();
        formatted_address = in.readString();
        location = in.readParcelable(LocationModel.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(formatted_address);
        dest.writeParcelable(location, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PlaceModel> CREATOR = new Creator<PlaceModel>() {
        @Override
        public PlaceModel createFromParcel(Parcel in) {
            return new PlaceModel(in);
        }

        @Override
        public PlaceModel[] newArray(int size) {
            return new PlaceModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public LocationModel getLocation() {
        return location;
    }
}
