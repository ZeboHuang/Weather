package com.lemondev.weather.models.realtime;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 2022/2/14
 * Created by vibrantBobo
 */

public class AirQualityModel implements Parcelable {

    private int pm25;

    private AqiModel aqi;

    private AqiDescriptionModel description;


    protected AirQualityModel(Parcel in) {
        pm25 = in.readInt();
        aqi = in.readParcelable(AqiModel.class.getClassLoader());
        description = in.readParcelable(AqiDescriptionModel.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pm25);
        dest.writeParcelable(aqi, flags);
        dest.writeParcelable(description, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AirQualityModel> CREATOR = new Creator<AirQualityModel>() {
        @Override
        public AirQualityModel createFromParcel(Parcel in) {
            return new AirQualityModel(in);
        }

        @Override
        public AirQualityModel[] newArray(int size) {
            return new AirQualityModel[size];
        }
    };

    public int getPm25() {
        return pm25;
    }

    public AqiModel getAqi() {
        return aqi;
    }

    public AqiDescriptionModel getDescription() {
        return description;
    }
}
