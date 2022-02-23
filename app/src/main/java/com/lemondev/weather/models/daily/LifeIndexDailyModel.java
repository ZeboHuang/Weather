package com.lemondev.weather.models.daily;

import android.os.Parcel;
import android.os.Parcelable;

import com.lemondev.weather.models.DateIndexDescModel;

import java.util.List;

/**
 * 2022/2/14
 * Created by vibrantBobo
 */

public class LifeIndexDailyModel implements Parcelable {

    private List<DateIndexDescModel> ultraviolet;
    private List<DateIndexDescModel> carWashing;
    private List<DateIndexDescModel> dressing;
    private List<DateIndexDescModel> comfort;
    private List<DateIndexDescModel> coldRisk;

    protected LifeIndexDailyModel(Parcel in) {
        ultraviolet = in.createTypedArrayList(DateIndexDescModel.CREATOR);
        carWashing = in.createTypedArrayList(DateIndexDescModel.CREATOR);
        dressing = in.createTypedArrayList(DateIndexDescModel.CREATOR);
        comfort = in.createTypedArrayList(DateIndexDescModel.CREATOR);
        coldRisk = in.createTypedArrayList(DateIndexDescModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(ultraviolet);
        dest.writeTypedList(carWashing);
        dest.writeTypedList(dressing);
        dest.writeTypedList(comfort);
        dest.writeTypedList(coldRisk);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LifeIndexDailyModel> CREATOR = new Creator<LifeIndexDailyModel>() {
        @Override
        public LifeIndexDailyModel createFromParcel(Parcel in) {
            return new LifeIndexDailyModel(in);
        }

        @Override
        public LifeIndexDailyModel[] newArray(int size) {
            return new LifeIndexDailyModel[size];
        }
    };

    public List<DateIndexDescModel> getUltraviolet() {
        return ultraviolet;
    }

    public List<DateIndexDescModel> getCarWashing() {
        return carWashing;
    }

    public List<DateIndexDescModel> getDressing() {
        return dressing;
    }

    public List<DateIndexDescModel> getComfort() {
        return comfort;
    }

    public List<DateIndexDescModel> getColdRisk() {
        return coldRisk;
    }
}
