package com.lemondev.weather.ui.adapters.ViewHolder;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lemondev.weather.R;
import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.ui.adapters.DailyTagAdapter;
import com.lemondev.weather.ui.adapters.DailyTrendAdapter;
import com.lemondev.weather.ui.adapters.OnTagClickListener;
import com.lemondev.weather.ui.adapters.ViewType;
import com.lemondev.weather.ui.recyclerview.HorizontalRecyclerView;
import com.lemondev.weather.ui.recyclerview.TrendRecyclerView;
import com.lemondev.weather.utils.FormatUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 如需实现卡片点击功能，implements OnTrendItemClick (interface)...
 * <p>
 *
 *
 * <p>
 * <p>
 * 2022/2/23
 * Created by vibrantBobo
 */

public class DailyViewHolder extends AbstractCardViewHolder implements OnTagClickListener {
    private int mTagViewType;
    private List<Integer> tagList;


    private String localTime;
    private DailyTrendAdapter dailyTrendAdapter;
    private DailyTagAdapter dailyTagAdapter;

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
        tagView = itemView.findViewById(R.id.daily_tag_recyclerview);
        trendView = itemView.findViewById(R.id.daily_trend_recyclerview);

        initView();
        dailyTrendAdapter = new DailyTrendAdapter();
        dailyTagAdapter = new DailyTagAdapter(this, tagList);

        tagView.setAdapter(dailyTagAdapter);
    }

    private void initView() {
        mTagViewType = ViewType.TEMPERATURE;

        tagList = new ArrayList<>();
        tagList.add(ViewType.TEMPERATURE);
        tagList.add(ViewType.HUMIDITY);
        tagList.add(ViewType.AIR_QUALITY);
        tagList.add(ViewType.AIR_QUALITY);
        tagList.add(ViewType.AIR_QUALITY);

        localTime = FormatUtils.getFormatDate("MM-dd hh:mm", new Date());
    }

    @Override
    public void onBindView(@NonNull WeatherModel weatherModel) {
        super.onBindView(weatherModel);
        updateTimeText.setText("更新于 " + localTime);
        itemView.getBackground().setAlpha(180);

        dailyTrendAdapter.setWeatherModel(weatherModel);
        trendView.setAdapter(dailyTrendAdapter);
    }

    @Override
    public void onTagClick(int tagType) {
        if (mTagViewType != tagType) {
            mTagViewType = tagType;
            dailyTrendAdapter.setmItemViewType(mTagViewType);
        }
    }
}
