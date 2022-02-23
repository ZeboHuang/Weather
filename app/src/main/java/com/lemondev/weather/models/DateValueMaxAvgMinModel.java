package com.lemondev.weather.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class DateValueMaxAvgMinModel implements Parcelable {
    private String date;    //daily
    private String datetime;    //hourly
    private float value;

    //daily data use
    private float max;
    private float min;
    private float avg;

    protected DateValueMaxAvgMinModel(Parcel in) {
        date = in.readString();
        datetime = in.readString();
        value = in.readFloat();
        max = in.readFloat();
        min = in.readFloat();
        avg = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(datetime);
        dest.writeFloat(value);
        dest.writeFloat(max);
        dest.writeFloat(min);
        dest.writeFloat(avg);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DateValueMaxAvgMinModel> CREATOR = new Creator<DateValueMaxAvgMinModel>() {
        @Override
        public DateValueMaxAvgMinModel createFromParcel(Parcel in) {
            return new DateValueMaxAvgMinModel(in);
        }

        @Override
        public DateValueMaxAvgMinModel[] newArray(int size) {
            return new DateValueMaxAvgMinModel[size];
        }
    };

    public String getDate() {
        return date;
    }

    public String getDatetime() {
        return datetime;
    }

    public float getValue() {
        return value;
    }

    public float getMax() {
        return max;
    }

    public float getMin() {
        return min;
    }

    public float getAvg() {
        return avg;
    }
}
