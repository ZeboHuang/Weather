package com.lemondev.weather.ui.adapters.ViewHolder.dailyitems;

import android.view.LayoutInflater;
import android.view.ViewGroup;
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

public class SunConditionItemViewHolder extends AbstractItemViewHolder {


    private String sunriseTime, sunsetTime, week, month, day;
    private Calendar calendar;

    private TextView sunriseView, sunsetView, weekView, monthView, dayView;


    /**
     * 在子类里面调用该构造函数，传入各自的视图布局View对象
     * 相当于重写onCreateViewHolder return 的ViewHolder
     */
    public SunConditionItemViewHolder(@NonNull ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_trend_sun_con_item, parent, false));

        weekView = itemView.findViewById(R.id.week_text);
        monthView = itemView.findViewById(R.id.month_text);
        dayView = itemView.findViewById(R.id.day_text);
        sunriseView = itemView.findViewById(R.id.sunrise_time);
        sunsetView = itemView.findViewById(R.id.sunset_time);


    }

    @Override
    public void onBindView(@NonNull WeatherModel weatherModel) {
        super.onBindView(weatherModel);

        calendar = FormatUtils.getCalendarWithCaiyunFormat(weatherModel.getDaily().getAstro()
                .get(getAdapterPosition()).getDate());

        week = TransformUtils.getWeekOf(calendar.get(Calendar.DAY_OF_WEEK));
        month = TransformUtils.getMonthOf(calendar.get(Calendar.MONTH));
        day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        sunriseTime = weatherModel.getDaily().getAstro().get(getAdapterPosition())
                .getSunrise().getTime();
        sunsetTime = weatherModel.getDaily().getAstro().get(getAdapterPosition())
                .getSunset().getTime();

        weekView.setText(week);
        monthView.setText(month);
        dayView.setText(day);
        sunriseView.setText(sunriseTime);
        sunsetView.setText(sunsetTime);

    }
}
