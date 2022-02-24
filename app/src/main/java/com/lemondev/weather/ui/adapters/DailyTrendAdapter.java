package com.lemondev.weather.ui.adapters;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.ui.adapters.ViewHolder.AbstractItemViewHolder;
import com.lemondev.weather.ui.adapters.ViewHolder.dailyitems.SunConditionItemViewHolder;
import com.lemondev.weather.ui.adapters.ViewHolder.dailyitems.TemperatureItemViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022/2/23
 * Created by vibrantBobo
 */

public class DailyTrendAdapter extends RecyclerView.Adapter<AbstractItemViewHolder> {

    private int mItemViewType;

    private List<Integer> tagTypes;
    private WeatherModel weatherModel;

    public DailyTrendAdapter() {
        tagTypes = new ArrayList<>();
        tagTypes.add(ViewType.TEMPERATURE);
        mItemViewType = ViewType.TEMPERATURE;
    }

    @NonNull
    @Override
    public AbstractItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case ViewType.TEMPERATURE:
                return new TemperatureItemViewHolder(parent);

            /**
             * 湿度 和 空气质量 也没有除了数值也没有直观的表示方法，所以不表示了
             */
//            case ViewType.HUMIDITY:
//                return new HumidityItemViewHolder(parent);
//            case ViewType.AIR_QUALITY:
//                return new AirQualityItemViewHolder(parent);
            case ViewType.SUN_CONDITION:
                return new SunConditionItemViewHolder(parent);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractItemViewHolder holder, int position) {
        holder.onBindView(weatherModel);
    }

    @Override
    public int getItemCount() {
        return weatherModel.getDaily().getTemperature().size();
    }

    @Override
    public int getItemViewType(int position) {
        //determine by tagView
        return mItemViewType;
    }

    public void setWeatherModel(WeatherModel weatherModel) {
        Log.d("MTAG", "setWeatherModel: ");
        this.weatherModel = weatherModel;
        notifyDataSetChanged();
    }

    /**
     * 获取当前显示的itemViewType
     *
     * @return
     */
    public int getmItemViewType() {
        return mItemViewType;
    }

    public void setmItemViewType(int mItemViewType) {
        this.mItemViewType = mItemViewType;
        //refresh
        notifyDataSetChanged();
    }
}
