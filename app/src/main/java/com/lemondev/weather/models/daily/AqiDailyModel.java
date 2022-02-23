package com.lemondev.weather.models.daily;

import android.os.Parcel;
import android.os.Parcelable;

import com.lemondev.weather.models.realtime.AqiModel;

/**
 * 2022/2/14
 * Created by vibrantBobo
 */

public class AqiDailyModel implements Parcelable {
    private String date;
    private AqiModel max;
    private AqiModel avg;
    private AqiModel min;

    protected AqiDailyModel(Parcel in) {
        date = in.readString();
        max = in.readParcelable(AqiModel.class.getClassLoader());
        avg = in.readParcelable(AqiModel.class.getClassLoader());
        min = in.readParcelable(AqiModel.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeParcelable(max, flags);
        dest.writeParcelable(avg, flags);
        dest.writeParcelable(min, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AqiDailyModel> CREATOR = new Creator<AqiDailyModel>() {
        @Override
        public AqiDailyModel createFromParcel(Parcel in) {
            return new AqiDailyModel(in);
        }

        @Override
        public AqiDailyModel[] newArray(int size) {
            return new AqiDailyModel[size];
        }
    };

    public String getDate() {
        return date;
    }

    public AqiModel getMax() {
        return max;
    }

    public AqiModel getAvg() {
        return avg;
    }

    public AqiModel getMin() {
        return min;
    }
}
