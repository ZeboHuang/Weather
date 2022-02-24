package com.lemondev.weather.ui.adapters.ViewHolder;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.lemondev.weather.R;
import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.utils.TransformUtils;

import org.jetbrains.annotations.NotNull;

/**
 * 2022/2/23
 * Created by vibrantBobo
 */

public class AbstractViewHolder extends RecyclerView.ViewHolder {
    /**
     * 在子类里面调用该构造函数，传入各自的视图布局View对象
     * 相当于重写onCreateViewHolder return 的ViewHolder
     *
     * @param
     */
    public AbstractViewHolder(@NonNull View itemView) {
        super(itemView);
    }


    @CallSuper
    public void onBindView(@NotNull WeatherModel weatherModel) {
        /**
         * set Background
         */
    }
}
