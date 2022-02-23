package com.lemondev.weather.models.realtime;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 2022/2/14
 * Created by vibrantBobo
 */

public class AqiDescriptionModel implements Parcelable {

    private String usa;
    private String chn;

    protected AqiDescriptionModel(Parcel in) {
        usa = in.readString();
        chn = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(usa);
        dest.writeString(chn);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AqiDescriptionModel> CREATOR = new Creator<AqiDescriptionModel>() {
        @Override
        public AqiDescriptionModel createFromParcel(Parcel in) {
            return new AqiDescriptionModel(in);
        }

        @Override
        public AqiDescriptionModel[] newArray(int size) {
            return new AqiDescriptionModel[size];
        }
    };

    public String getUsa() {
        return usa;
    }

    public String getChn() {
        return chn;
    }
}
