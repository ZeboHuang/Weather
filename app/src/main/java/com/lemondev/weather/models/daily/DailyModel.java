package com.lemondev.weather.models.daily;

import android.os.Parcel;
import android.os.Parcelable;

import com.lemondev.weather.models.realtime.LifeIndexModel;
import com.lemondev.weather.models.realtime.SkyconModel;
import com.lemondev.weather.models.DateValueMaxAvgMinModel;

import java.util.List;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class DailyModel implements Parcelable {


    private List<AstroModel> astro;
    private List<DateValueMaxAvgMinModel> temperature;
    private List<DateValueMaxAvgMinModel> humidity;
    private List<SkyconModel> skycon;
    private List<SkyconModel> skycon_08h_20h;   //白天
    private List<SkyconModel> skycon_20h_32h;   //夜晚


    private AirQualityDailyModel air_quality;
    private LifeIndexDailyModel life_index;


    protected DailyModel(Parcel in) {
        astro = in.createTypedArrayList(AstroModel.CREATOR);
        temperature = in.createTypedArrayList(DateValueMaxAvgMinModel.CREATOR);
        humidity = in.createTypedArrayList(DateValueMaxAvgMinModel.CREATOR);
        skycon = in.createTypedArrayList(SkyconModel.CREATOR);
        skycon_08h_20h = in.createTypedArrayList(SkyconModel.CREATOR);
        skycon_20h_32h = in.createTypedArrayList(SkyconModel.CREATOR);
        air_quality = in.readParcelable(AirQualityDailyModel.class.getClassLoader());
        life_index = in.readParcelable(LifeIndexDailyModel.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(astro);
        dest.writeTypedList(temperature);
        dest.writeTypedList(humidity);
        dest.writeTypedList(skycon);
        dest.writeTypedList(skycon_08h_20h);
        dest.writeTypedList(skycon_20h_32h);
        dest.writeParcelable(air_quality, flags);
        dest.writeParcelable(life_index, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DailyModel> CREATOR = new Creator<DailyModel>() {
        @Override
        public DailyModel createFromParcel(Parcel in) {
            return new DailyModel(in);
        }

        @Override
        public DailyModel[] newArray(int size) {
            return new DailyModel[size];
        }
    };

    public List<AstroModel> getAstro() {
        return astro;
    }

    public List<DateValueMaxAvgMinModel> getTemperature() {
        return temperature;
    }

    public List<DateValueMaxAvgMinModel> getHumidity() {
        return humidity;
    }

    public List<SkyconModel> getSkycon() {
        return skycon;
    }

    public List<SkyconModel> getSkycon_08h_20h() {
        return skycon_08h_20h;
    }

    public List<SkyconModel> getSkycon_20h_32h() {
        return skycon_20h_32h;
    }

    public AirQualityDailyModel getAir_quality() {
        return air_quality;
    }

    public LifeIndexDailyModel getLife_index() {
        return life_index;
    }
}
