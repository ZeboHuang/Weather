package com.lemondev.weather.ui.adapters.ViewHolder.dailyitems;

import android.view.LayoutInflater;
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
 * 2022/2/23
 * Created by vibrantBobo
 */

public class TemperatureItemViewHolder extends AbstractItemViewHolder {

    private Calendar calendar;
    private String week;
    private String month;
    private String day;
    private int skyconIconRes;
    private int maxTemp, minTemp;
    private String skycon;

    private TextView dayText, maxTempText, minTempText, skyconText, weekText, monthText;
    private ImageView skyconIcon;


    /**
     * 在子类里面调用该构造函数，传入各自的视图布局View对象
     * 相当于重写onCreateViewHolder return 的ViewHolder
     */
    public TemperatureItemViewHolder(@NonNull ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_trend_temperature_item, parent, false));

        weekText = itemView.findViewById(R.id.daily_trend_item_week_text);
        monthText = itemView.findViewById(R.id.daily_trend_item_month_text);
        dayText = itemView.findViewById(R.id.daily_trend_item_day_text);
        maxTempText = itemView.findViewById(R.id.daily_trend_item_max_temp_text);
        minTempText = itemView.findViewById(R.id.daily_trend_item_min_temp_text);
        skyconIcon = itemView.findViewById(R.id.daily_trend_item_icon_imageview);
        skyconText = itemView.findViewById(R.id.daily_trend_item_skycon_text);

        calendar = null;
        minTemp = 0;
        maxTemp = 0;
        skyconIconRes = 0;
    }

    @Override
    public void onBindView(@NonNull WeatherModel weatherModel) {
        super.onBindView(weatherModel);

        calendar = FormatUtils.getCalendarWithCaiyunFormat(
                weatherModel.getDaily().getTemperature().get(getAdapterPosition()).getDate());

        week = TransformUtils.getWeekOf(calendar.get(Calendar.DAY_OF_WEEK));
        month = TransformUtils.getMonthOf(calendar.get(Calendar.MONTH));
        day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

        maxTemp = (int) weatherModel.getDaily().getTemperature().get(getAdapterPosition()).getMax();
        minTemp = (int) weatherModel.getDaily().getTemperature().get(getAdapterPosition()).getMin();
        skyconIconRes = TransformUtils.getSkyconIcon(
                weatherModel.getDaily().getSkycon().get(getAdapterPosition()).getValue()
        );
        skycon = TransformUtils.getSkycon(weatherModel.getDaily().getSkycon().get(getAdapterPosition()).getValue());

        weekText.setText(week);
        monthText.setText(month);
        dayText.setText(day);
        maxTempText.setText(maxTemp + "°");
        minTempText.setText(minTemp + "°");
        skyconIcon.setImageResource(skyconIconRes);
        skyconText.setText(skycon);

    }
}
