package com.lemondev.weather.models.realtime;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 2022/2/14
 * Created by vibrantBobo
 */

public class AqiModel implements Parcelable {
    private int chn;
    private int usa;

    protected AqiModel(Parcel in) {
        chn = in.readInt();
        usa = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(chn);
        dest.writeInt(usa);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AqiModel> CREATOR = new Creator<AqiModel>() {
        @Override
        public AqiModel createFromParcel(Parcel in) {
            return new AqiModel(in);
        }

        @Override
        public AqiModel[] newArray(int size) {
            return new AqiModel[size];
        }
    };

    public int getChn() {
        return chn;
    }

    public int getUsa() {
        return usa;
    }
}
