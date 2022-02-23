package com.lemondev.weather.models.daily;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class SunConModel implements Parcelable {
    //太阳日出日落
    private String time;

    protected SunConModel(Parcel in) {
        time = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SunConModel> CREATOR = new Creator<SunConModel>() {
        @Override
        public SunConModel createFromParcel(Parcel in) {
            return new SunConModel(in);
        }

        @Override
        public SunConModel[] newArray(int size) {
            return new SunConModel[size];
        }
    };

    public String getTime() {
        return time;
    }
}
