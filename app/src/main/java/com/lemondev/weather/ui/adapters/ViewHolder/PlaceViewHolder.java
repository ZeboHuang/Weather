package com.lemondev.weather.ui.adapters.ViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lemondev.weather.R;
import com.lemondev.weather.models.PlaceModel;
import com.lemondev.weather.ui.adapters.OnPlaceItemClickListener;

/**
 * 2022/2/25
 * Created by vibrantBobo
 */

public class PlaceViewHolder extends AbstractViewHolder {

    private String name;
    private String formattedAddress;

    private TextView nameView, formattedAddrView;

    private OnPlaceItemClickListener mOnPlaceItemClickListener;


    /**
     * 在子类里面调用该构造函数，传入各自的视图布局View对象
     * 相当于重写onCreateViewHolder return 的ViewHolder
     */
    public PlaceViewHolder(@NonNull ViewGroup parent, OnPlaceItemClickListener onPlaceItemClickListener) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.query_place_item, parent, false));

        nameView = itemView.findViewById(R.id.place_name);
        formattedAddrView = itemView.findViewById(R.id.place_formatted_address);

        mOnPlaceItemClickListener = onPlaceItemClickListener;
    }

    public void setmOnPlaceItemClickListener(OnPlaceItemClickListener mOnPlaceItemClickListener) {
        this.mOnPlaceItemClickListener = mOnPlaceItemClickListener;
    }

    public void onBindView(PlaceModel placeModel) {
        name = placeModel.getName();
        formattedAddress = placeModel.getFormatted_address();

        nameView.setText(name);
        formattedAddrView.setText(formattedAddress);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnPlaceItemClickListener.onPlaceChanged(placeModel);
            }
        });

        itemView.getBackground().setAlpha(180);
    }
}
