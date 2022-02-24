package com.lemondev.weather.ui.adapters.ViewHolder.dailyitems;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.lemondev.weather.R;
import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.ui.adapters.ViewHolder.AbstractItemViewHolder;

/**
 * 2022/2/23
 * Created by vibrantBobo
 */

public class HumidityItemViewHolder extends AbstractItemViewHolder {
    public HumidityItemViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_trend_humidity_item, parent, false));
    }

    @Override
    public void onBindView(@NonNull WeatherModel weatherModel) {
        super.onBindView(weatherModel);

        /**
         * 降水量 看不懂
         */

//        weatherModel.getDaily().getHumidity().get(getAdapterPosition())
//                .getMax()
    }
}
