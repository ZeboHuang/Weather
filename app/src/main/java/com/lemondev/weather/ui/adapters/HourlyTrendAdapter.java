package com.lemondev.weather.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.ui.adapters.ViewHolder.HourlyViewHolder;
import com.lemondev.weather.ui.adapters.ViewHolder.hourlyitems.TemperatureHourlyItemViewHolder;
import com.lemondev.weather.ui.recyclerview.TrendRecyclerView;

/**
 * 2022/2/25
 * Created by vibrantBobo
 */

public class HourlyTrendAdapter extends RecyclerView.Adapter<TemperatureHourlyItemViewHolder> {

    private WeatherModel weatherModel;

    @NonNull
    @Override
    public TemperatureHourlyItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TemperatureHourlyItemViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TemperatureHourlyItemViewHolder holder, int position) {
        holder.onBindView(weatherModel);
    }

    @Override
    public int getItemCount() {
        return weatherModel.getHourly().getTemperature().size();
    }

    public void setWeatherModel(WeatherModel weatherModel) {
        this.weatherModel = weatherModel;
    }
}
