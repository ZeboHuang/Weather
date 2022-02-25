package com.lemondev.weather.ui.adapters;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemondev.weather.models.LocationModel;
import com.lemondev.weather.models.PlaceModel;
import com.lemondev.weather.ui.adapters.ViewHolder.AbstractViewHolder;
import com.lemondev.weather.ui.adapters.ViewHolder.PlaceViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022/2/25
 * Created by vibrantBobo
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceViewHolder> {

    private List<PlaceModel> places;
    private OnPlaceItemClickListener onPlaceItemClickListener;


    public PlaceAdapter(OnPlaceItemClickListener onPlaceItemClickListener) {
        this.places = new ArrayList<>();
        this.onPlaceItemClickListener = onPlaceItemClickListener;
    }


    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlaceViewHolder(parent, onPlaceItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        holder.onBindView(places.get(position));
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public void setPlaces(List<PlaceModel> places) {
        this.places = places;
        notifyDataSetChanged();
    }


}
