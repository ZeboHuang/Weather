package com.lemondev.weather.models.realtime;

import android.os.Parcel;
import android.os.Parcelable;

import com.lemondev.weather.models.DateIndexDescModel;

/**
 * 2022/2/14
 * Created by vibrantBobo
 */

public class LifeIndexModel implements Parcelable{

    private DateIndexDescModel ultraviolet;     //紫外线
    private DateIndexDescModel comfort;

    protected LifeIndexModel(Parcel in) {
        ultraviolet = in.readParcelable(DateIndexDescModel.class.getClassLoader());
        comfort = in.readParcelable(DateIndexDescModel.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(ultraviolet, flags);
        dest.writeParcelable(comfort, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LifeIndexModel> CREATOR = new Creator<LifeIndexModel>() {
        @Override
        public LifeIndexModel createFromParcel(Parcel in) {
            return new LifeIndexModel(in);
        }

        @Override
        public LifeIndexModel[] newArray(int size) {
            return new LifeIndexModel[size];
        }
    };

    public DateIndexDescModel getUltraviolet() {
        return ultraviolet;
    }

    public DateIndexDescModel getComfort() {
        return comfort;
    }
}
