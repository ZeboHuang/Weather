package com.lemondev.weather.ui.adapters.ViewHolder;

import android.view.View;

import androidx.annotation.NonNull;

import com.lemondev.weather.ui.adapters.ViewHolder.AbstractViewHolder;

/**
 * 2022/2/23
 * Created by vibrantBobo
 */

public class AbstractItemViewHolder extends AbstractViewHolder {
    /**
     * 在子类里面调用该构造函数，传入各自的视图布局View对象
     * 相当于重写onCreateViewHolder return 的ViewHolder
     *
     */

    public AbstractItemViewHolder(@NonNull View itemView) {
        super(itemView);
    }


}
