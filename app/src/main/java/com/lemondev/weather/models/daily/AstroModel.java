package com.lemondev.weather.models.daily;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class AstroModel implements Parcelable {
    private String date;
    private SunConModel sunrise;
    private SunConModel sunset;

    protected AstroModel(Parcel in) {
        date = in.readString();
        sunrise = in.readParcelable(SunConModel.class.getClassLoader());
        sunset = in.readParcelable(SunConModel.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeParcelable(sunrise, flags);
        dest.writeParcelable(sunset, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AstroModel> CREATOR = new Creator<AstroModel>() {
        @Override
        public AstroModel createFromParcel(Parcel in) {
            return new AstroModel(in);
        }

        @Override
        public AstroModel[] newArray(int size) {
            return new AstroModel[size];
        }
    };

    public String getDate() {
        return date;
    }

    public SunConModel getSunrise() {
        return sunrise;
    }

    public SunConModel getSunset() {
        return sunset;
    }
}
