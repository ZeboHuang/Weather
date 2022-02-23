package com.lemondev.weather.models.realtime;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class RealtimeModel implements Parcelable {

    private float temperature;  //温度
    private float humidity;     //湿度
    private String skycon;      //天空状况
    private float visibility;   //可见度
    private float apparent_temperature; //体感温度

    private AirQualityModel air_quality;
    private LifeIndexModel life_index;

    protected RealtimeModel(Parcel in) {
        temperature = in.readFloat();
        humidity = in.readFloat();
        skycon = in.readString();
        visibility = in.readFloat();
        apparent_temperature = in.readFloat();
        air_quality = in.readParcelable(AirQualityModel.class.getClassLoader());
        life_index = in.readParcelable(LifeIndexModel.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(temperature);
        dest.writeFloat(humidity);
        dest.writeString(skycon);
        dest.writeFloat(visibility);
        dest.writeFloat(apparent_temperature);
        dest.writeParcelable(air_quality, flags);
        dest.writeParcelable(life_index, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RealtimeModel> CREATOR = new Creator<RealtimeModel>() {
        @Override
        public RealtimeModel createFromParcel(Parcel in) {
            return new RealtimeModel(in);
        }

        @Override
        public RealtimeModel[] newArray(int size) {
            return new RealtimeModel[size];
        }
    };

    public float getTemperature() {
        return temperature;
    }

    public float getApparent_temperature() {
        return apparent_temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public String getSkycon() {
        return skycon;
    }

    public float getVisibility() {
        return visibility;
    }


    public AirQualityModel getAir_quality() {
        return air_quality;
    }

    public LifeIndexModel getLife_index() {
        return life_index;
    }
}
