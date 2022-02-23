package com.lemondev.weather.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 2022/2/14
 * Created by vibrantBobo
 */

public class DateIndexDescModel implements Parcelable {
    private String date;
    private String index;
    private String desc;

    protected DateIndexDescModel(Parcel in) {
        date = in.readString();
        index = in.readString();
        desc = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(index);
        dest.writeString(desc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DateIndexDescModel> CREATOR = new Creator<DateIndexDescModel>() {
        @Override
        public DateIndexDescModel createFromParcel(Parcel in) {
            return new DateIndexDescModel(in);
        }

        @Override
        public DateIndexDescModel[] newArray(int size) {
            return new DateIndexDescModel[size];
        }
    };

    public String getDate() {
        return date;
    }

    public String getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }
}
