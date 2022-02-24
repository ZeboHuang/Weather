package com.lemondev.weather.ui.adapters.ViewHolder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lemondev.weather.R;
import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.utils.TransformUtils;

/**
 * 2022/2/23
 * Created by vibrantBobo
 */

public class HeaderViewHolder extends AbstractViewHolder {
    private int mTemperature;
    private int mApparentTempe;
    private String mTemperatureUnit;
    private String mSkycon;
    private String mLifeIndex;
    private String mKeypoint;
    private int mSkyconIconRes;

    private final TextView tempText, descText, keypointText;
    private final ImageView skyconIcon;


    /**
     * ViewHolder 里面有 itemView。
     *
     * @param parent //inflate layout
     */
    public HeaderViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.container_realtime_weather, parent, false));

        tempText = itemView.findViewById(R.id.realtime_temp_text);
        descText = itemView.findViewById(R.id.realtime_desc_text);
        keypointText = itemView.findViewById(R.id.realtime_keypoint_text);
        skyconIcon = itemView.findViewById(R.id.realtime_skycon_icon);

        mTemperature = 0;
        mApparentTempe = 0;
        mTemperatureUnit = "°";       // 通过设置可以设置。SettingManager.getInstance().getTemperatureUnit();...
        mSkycon = "-";
        mLifeIndex = "-";
        mKeypoint = "暂未获取到数据";
        mSkyconIconRes = R.drawable.abc_vector_test;
    }


    /**
     * 几何天气 中有其他的数据，如context, 其目的是对布局进行修改
     * 我这里只需要获取数据绑定即可。
     *
     * @param weatherModel
     */
    @Override
    public void onBindView(@NonNull WeatherModel weatherModel) {
        super.onBindView(weatherModel);

        mTemperature = (int) weatherModel.getRealtime().getTemperature();
        mApparentTempe = (int) weatherModel.getRealtime().getApparent_temperature();
        mSkycon = TransformUtils.getSkycon(weatherModel.getRealtime().getSkycon());
        mLifeIndex = weatherModel.getRealtime().getLife_index().getComfort().getDesc();
        mKeypoint = weatherModel.getForecast_keypoint();
        mSkyconIconRes = TransformUtils.getSkyconIcon(weatherModel.getRealtime().getSkycon());


        /**
         * 后续可以写个具体类控制
         *  根据时区时间来控制吧
         */

        if (weatherModel.getRealtime().getSkycon().contains("NIGHT")) {
            tempText.setTextColor(itemView.getResources().getColor(R.color.grainsboro));
            descText.setTextColor(itemView.getResources().getColor(R.color.grainsboro));
            keypointText.setTextColor(itemView.getResources().getColor(R.color.grainsboro));
        }

        //set
        tempText.setText(mTemperature + mTemperatureUnit);
        descText.setText(mSkycon + " | " + mLifeIndex + " | 体感 " + mApparentTempe + mTemperatureUnit);
        keypointText.setText(mKeypoint);
        skyconIcon.setImageResource(mSkyconIconRes);
    }
}
