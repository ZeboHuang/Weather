package com.lemondev.weather.ui.recyclerview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * trend view 趋势图。
 * 2022/2/23
 * Created by vibrantBobo
 */

public class TrendRecyclerView extends HorizontalRecyclerView {
    public TrendRecyclerView(@NonNull Context context) {
        super(context);
    }

    public TrendRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TrendRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 实现画趋势图的功能
     */
}
