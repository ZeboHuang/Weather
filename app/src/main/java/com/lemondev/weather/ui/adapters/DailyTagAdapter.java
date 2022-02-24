package com.lemondev.weather.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemondev.weather.ui.adapters.ViewHolder.dailyitems.TagViewHolder;

import java.util.List;

/**
 *
 *
 *
 * 2022/2/24
 * Created by vibrantBobo
 */

public class DailyTagAdapter extends RecyclerView.Adapter<TagViewHolder> {
    /**
     * @param onTagClickListener    传参给TagViewHolder 便于实现点击的不同效果，方便回调
     *                                 在 DailyTrendAdapter具体实现。
     */
    private OnTagClickListener onTagClickListener;

    private List<Integer> tagList;

    public DailyTagAdapter(OnTagClickListener onTagClickListener, List<Integer> tagList) {
        this.onTagClickListener = onTagClickListener;
        this.tagList = tagList;
    }

    @NonNull
    @Override
    public TagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new TagViewHolder(parent, onTagClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TagViewHolder holder, int position) {
        holder.onTagBind(tagList.get(position));
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    public void setTagList(List<Integer> tagList) {
        this.tagList = tagList;
    }

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        this.onTagClickListener = onTagClickListener;
    }
}
