package com.lemondev.weather.models.daily;

import android.os.Parcel;
import android.os.Parcelable;

import com.lemondev.weather.models.DateValueMaxAvgMinModel;

import java.util.List;

/**
 * 2022/2/14
 * Created by vibrantBobo
 */

public class AirQualityDailyModel implements Parcelable {

    private List<AqiDailyModel> aqi;

    private List<DateValueMaxAvgMinModel> pm25;      //数据结构相似

    protected AirQualityDailyModel(Parcel in) {
        aqi = in.createTypedArrayList(AqiDailyModel.CREATOR);
        pm25 = in.createTypedArrayList(DateValueMaxAvgMinModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(aqi);
        dest.writeTypedList(pm25);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AirQualityDailyModel> CREATOR = new Creator<AirQualityDailyModel>() {
        @Override
        public AirQualityDailyModel createFromParcel(Parcel in) {
            return new AirQualityDailyModel(in);
        }

        @Override
        public AirQualityDailyModel[] newArray(int size) {
            return new AirQualityDailyModel[size];
        }
    };

    public List<AqiDailyModel> getAqi() {
        return aqi;
    }

    public List<DateValueMaxAvgMinModel> getPm25() {
        return pm25;
    }
}
