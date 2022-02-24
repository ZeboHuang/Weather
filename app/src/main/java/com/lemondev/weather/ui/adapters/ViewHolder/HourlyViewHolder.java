package com.lemondev.weather.ui.adapters.ViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemondev.weather.R;
import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.ui.recyclerview.TrendRecyclerView;

/**
 * 2022/2/23
 * Created by vibrantBobo
 */

public class HourlyViewHolder extends AbstractCardViewHolder {

    TextView keypointText;  //may be have...
    TrendRecyclerView trendView;

    public HourlyViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.container_hourly_weather, parent, false));

        keypointText = itemView.findViewById(R.id.hourly_keypoint_text);
        trendView = itemView.findViewById(R.id.hourly_trend_recyclerView);
    }

    @Override
    public void onBindView(@NonNull WeatherModel weatherModel) {
        super.onBindView(weatherModel);
    }
}
