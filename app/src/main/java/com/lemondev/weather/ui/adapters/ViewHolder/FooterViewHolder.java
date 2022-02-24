package com.lemondev.weather.ui.adapters.ViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemondev.weather.R;
import com.lemondev.weather.models.WeatherModel;

/**
 * 2022/2/23
 * Created by vibrantBobo
 */

public class FooterViewHolder extends AbstractViewHolder {

    private TextView authorView, linkView;

    public FooterViewHolder(@NonNull ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.container_footer, parent, false));
        authorView = itemView.findViewById(R.id.author);
        linkView = itemView.findViewById(R.id.link);

    }

    @Override
    public void onBindView(@NonNull WeatherModel weatherModel) {
        super.onBindView(weatherModel);

        if (weatherModel.getRealtime().getSkycon().contains("NIGHT")) {
            authorView.setTextColor(itemView.getResources().getColor(R.color.grainsboro));
            linkView.setTextColor(itemView.getResources().getColor(R.color.grainsboro));
        }
    }
}
