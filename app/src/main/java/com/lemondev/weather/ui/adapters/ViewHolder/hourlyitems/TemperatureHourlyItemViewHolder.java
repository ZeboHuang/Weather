package com.lemondev.weather.ui.adapters.ViewHolder.hourlyitems;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lemondev.weather.R;
import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.ui.adapters.ViewHolder.AbstractItemViewHolder;
import com.lemondev.weather.utils.FormatUtils;
import com.lemondev.weather.utils.TransformUtils;

import java.util.Calendar;

/**
 * 2022/2/25
 * Created by vibrantBobo
 */

public class TemperatureHourlyItemViewHolder extends AbstractItemViewHolder {

    private Calendar calendar;
    private String time, temperature, skycon;
    private int skyconIconRes;

    private TextView timeView, temperatureView, skyconView;
    private ImageView skyconIconView;


    /**
     * 在子类里面调用该构造函数，传入各自的视图布局View对象
     * 相当于重写onCreateViewHolder return 的ViewHolder
     */
    public TemperatureHourlyItemViewHolder(@NonNull ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.hourly_trend_item, parent, false));

        timeView = itemView.findViewById(R.id.hourly_time);
        temperatureView = itemView.findViewById(R.id.hourly_temperature);
        skyconIconView = itemView.findViewById(R.id.hourly_skycon_icon);
        skyconView = itemView.findViewById(R.id.hourly_skycon);
    }

    @Override
    public void onBindView(@NonNull WeatherModel weatherModel) {
        super.onBindView(weatherModel);

        calendar = FormatUtils.getCalendarWithCaiyunFormat(
                weatherModel.getHourly().getTemperature().get(getAdapterPosition())
                        .getDatetime()
        );
        time = calendar.get(Calendar.HOUR_OF_DAY) + " 点";
        temperature = (int) weatherModel.getHourly().getTemperature().get(getAdapterPosition())
                .getValue() + "°";
        skyconIconRes = TransformUtils.getSkyconIcon(
                weatherModel.getHourly().getSkycon().get(getAdapterPosition()).getValue()
        );
        skycon = TransformUtils.getSkycon(weatherModel.getHourly().getSkycon().get(getAdapterPosition()).getValue());


        timeView.setText(time);
        temperatureView.setText(temperature);
        skyconIconView.setImageResource(skyconIconRes);
        skyconView.setText(skycon);
    }
}
