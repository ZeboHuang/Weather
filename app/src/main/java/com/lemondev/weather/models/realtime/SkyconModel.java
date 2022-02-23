package com.lemondev.weather.models.realtime;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class SkyconModel implements Parcelable {
    private String datetime;
    private String value;


    protected SkyconModel(Parcel in) {
        datetime = in.readString();
        value = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(datetime);
        dest.writeString(value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SkyconModel> CREATOR = new Creator<SkyconModel>() {
        @Override
        public SkyconModel createFromParcel(Parcel in) {
            return new SkyconModel(in);
        }

        @Override
        public SkyconModel[] newArray(int size) {
            return new SkyconModel[size];
        }
    };

    public String getDatetime() {
        return datetime;
    }

    public String getValue() {
        return value;
    }



}
