package com.lemondev.weather.ui.recyclerview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 2022/2/14
 * Created by vibrantBobo
 */

public class HorizontalRecyclerView extends RecyclerView {
    private LinearLayoutManager horizontalLinearLayoutManager;

    public HorizontalRecyclerView(@NonNull Context context) {
        super(context);
        initialLayoutManager();
    }

    public HorizontalRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialLayoutManager();
    }

    public HorizontalRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialLayoutManager();
    }

    void initialLayoutManager() {
        horizontalLinearLayoutManager = new LinearLayoutManager(getContext());
        horizontalLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        setLayoutManager(horizontalLinearLayoutManager);
    }

}
