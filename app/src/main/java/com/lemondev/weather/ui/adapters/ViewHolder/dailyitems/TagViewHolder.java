package com.lemondev.weather.ui.adapters.ViewHolder.dailyitems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lemondev.weather.R;
import com.lemondev.weather.ui.adapters.OnTagClickListener;
import com.lemondev.weather.ui.adapters.ViewHolder.AbstractItemViewHolder;
import com.lemondev.weather.utils.TransformUtils;

/**
 * 2022/2/24
 * Created by vibrantBobo
 */

public class TagViewHolder extends AbstractItemViewHolder {
    private int mTagType;

    private TextView tagView;

    private OnTagClickListener mOnTagClickListener;

    /**
     * 在子类里面调用该构造函数，传入各自的视图布局View对象
     * 相当于重写onCreateViewHolder return 的ViewHolder
     */
    public TagViewHolder(@NonNull ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_tag_item, parent, false));
        tagView = itemView.findViewById(R.id.daily_tag_text);
    }

    public TagViewHolder(@NonNull ViewGroup parent, OnTagClickListener onTagClickListener) {
        this(parent);
        mOnTagClickListener = onTagClickListener;
    }

    public void onTagBind(int tagType) {
        mTagType = tagType;

        tagView.setText(TransformUtils.getTagType(tagType));
        tagView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnTagClickListener.onTagClick(tagType);
            }
        });

        itemView.getBackground().setAlpha(100);
    }

    public int getTagType() {
        return mTagType;
    }
}
