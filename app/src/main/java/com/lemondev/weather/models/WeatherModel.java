package com.lemondev.weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.lemondev.weather.models.daily.DailyModel;
import com.lemondev.weather.models.hourly.HourlyModel;
import com.lemondev.weather.models.realtime.RealtimeModel;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class WeatherModel implements Parcelable {
    private RealtimeModel realtime;
    private HourlyModel hourly;
    private DailyModel daily;
    private String forecast_keypoint;


    protected WeatherModel(Parcel in) {
        realtime = in.readParcelable(RealtimeModel.class.getClassLoader());
        hourly = in.readParcelable(HourlyModel.class.getClassLoader());
        daily = in.readParcelable(DailyModel.class.getClassLoader());
        forecast_keypoint = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(realtime, flags);
        dest.writeParcelable(hourly, flags);
        dest.writeParcelable(daily, flags);
        dest.writeString(forecast_keypoint);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WeatherModel> CREATOR = new Creator<WeatherModel>() {
        @Override
        public WeatherModel createFromParcel(Parcel in) {
            return new WeatherModel(in);
        }

        @Override
        public WeatherModel[] newArray(int size) {
            return new WeatherModel[size];
        }
    };

    public RealtimeModel getRealtime() {
        return realtime;
    }

    public HourlyModel getHourly() {
        return hourly;
    }

    public DailyModel getDaily() {
        return daily;
    }

    public String getForecast_keypoint() {
        return forecast_keypoint;
    }
}
