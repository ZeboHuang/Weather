package com.lemondev.weather.ui.adapters.ViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lemondev.weather.R;
import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.ui.recyclerview.HorizontalRecyclerView;
import com.lemondev.weather.ui.recyclerview.TrendRecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 如需实现卡片点击功能，implements OnTrendItemClick (interface)...
 * <p>
 * 在viewHolder中 填充fragment.
 *
 * <p>
 * <p>
 * 2022/2/23
 * Created by vibrantBobo
 */

public class DailyViewHolder extends AbstractViewHolder {

    private String localTime;
    private SimpleDateFormat simpleDateFormat;
    private DailyTrendAdapter dailyTrendAdapter;


    private TextView updateTimeText;
    private HorizontalRecyclerView tagView;     //标签，温度，湿度，空气质量...
    private TrendRecyclerView trendView;        //每日温度折线趋势...

    /**
     * 在子类里面调用该构造函数，传入各自的视图布局View对象
     * 相当于重写onCreateViewHolder return 的ViewHolder
     *
     * @param
     */


    public DailyViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.container_daily_weather, parent, false));

        updateTimeText = itemView.findViewById(R.id.update_time_text);
        tagView = itemView.findViewWithTag(R.id.daily_tag_recyclerview);
        trendView = itemView.findViewById(R.id.daily_trend_recyclerview);

        simpleDateFormat = new SimpleDateFormat("MM-dd hh:mm");
        localTime = simpleDateFormat.format(new Date());

        tagView = new HorizontalRecyclerView(parent.getContext());
        trendView = new TrendRecyclerView(parent.getContext());
        dailyTrendAdapter = new DailyTrendAdapter();
    }

    @Override
    public void onBindView(@NonNull WeatherModel weatherModel) {
        super.onBindView(weatherModel);
        updateTimeText.setText("更新于 " + localTime);

        dailyTrendAdapter.setDailyModel(weatherModel.getDaily());
        trendView.setAdapter(dailyTrendAdapter);
    }
}
