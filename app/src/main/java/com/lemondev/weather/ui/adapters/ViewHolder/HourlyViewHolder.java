package com.lemondev.weather.ui.adapters.ViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemondev.weather.R;
import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.ui.adapters.HourlyTrendAdapter;
import com.lemondev.weather.ui.recyclerview.TrendRecyclerView;

/**
 * 2022/2/23
 * Created by vibrantBobo
 */

public class HourlyViewHolder extends AbstractCardViewHolder {

    private String description;
    private HourlyTrendAdapter mAdapter;

    private TextView keypointText;  //may be have...
    private TrendRecyclerView trendView;

    public HourlyViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.container_hourly_weather, parent, false));

        keypointText = itemView.findViewById(R.id.hourly_keypoint_text);
        trendView = itemView.findViewById(R.id.hourly_trend_recyclerView);

        mAdapter = new HourlyTrendAdapter();
    }

    @Override
    public void onBindView(@NonNull WeatherModel weatherModel) {
        super.onBindView(weatherModel);

        description = weatherModel.getHourly().getDescription();
        keypointText.setText(description);

        mAdapter.setWeatherModel(weatherModel);
        trendView.setAdapter(mAdapter);

    }
}
