package com.lemondev.weather.models.hourly;

import android.os.Parcel;
import android.os.Parcelable;

import com.lemondev.weather.models.realtime.SkyconModel;
import com.lemondev.weather.models.DateValueMaxAvgMinModel;

import java.util.List;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class HourlyModel implements Parcelable{

    private String description; //描述
    private List<DateValueMaxAvgMinModel> temperature;
    private List<DateValueMaxAvgMinModel> humidity;
    private List<SkyconModel> skycon;


    protected HourlyModel(Parcel in) {
        description = in.readString();
        temperature = in.createTypedArrayList(DateValueMaxAvgMinModel.CREATOR);
        humidity = in.createTypedArrayList(DateValueMaxAvgMinModel.CREATOR);
        skycon = in.createTypedArrayList(SkyconModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeTypedList(temperature);
        dest.writeTypedList(humidity);
        dest.writeTypedList(skycon);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HourlyModel> CREATOR = new Creator<HourlyModel>() {
        @Override
        public HourlyModel createFromParcel(Parcel in) {
            return new HourlyModel(in);
        }

        @Override
        public HourlyModel[] newArray(int size) {
            return new HourlyModel[size];
        }
    };

    public List<DateValueMaxAvgMinModel> getHumidity() {
        return humidity;
    }

    public String getDescription() {
        return description;
    }

    public List<DateValueMaxAvgMinModel> getTemperature() {
        return temperature;
    }

    public List<SkyconModel> getSkycon() {
        return skycon;
    }
}
