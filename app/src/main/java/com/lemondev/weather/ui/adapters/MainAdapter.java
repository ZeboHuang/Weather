package com.lemondev.weather.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.ui.adapters.ViewHolder.AbstractViewHolder;
import com.lemondev.weather.ui.adapters.ViewHolder.DailyViewHolder;
import com.lemondev.weather.ui.adapters.ViewHolder.FooterViewHolder;
import com.lemondev.weather.ui.adapters.ViewHolder.HeaderViewHolder;
import com.lemondev.weather.ui.adapters.ViewHolder.HourlyViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022/2/23
 * Created by vibrantBobo
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Integer> cardViewTypeList;     //edit by setting, but not working now.
    private WeatherModel weatherModel;

    public MainAdapter() {
        //cardViewTypeList
        if (cardViewTypeList == null) {
            cardViewTypeList = new ArrayList<>();
            cardViewTypeList.add(ViewType.HEADER);
            cardViewTypeList.add(ViewType.DAILY);
            cardViewTypeList.add(ViewType.HOURLY);
            cardViewTypeList.add(ViewType.FOOTER);

        }
    }

    @NonNull
    @Override
    public AbstractViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //不同的type有不同的view
        switch (viewType) {
            case ViewType.HEADER:
                return new HeaderViewHolder(parent);
            case ViewType.DAILY:
                return new DailyViewHolder(parent);
            case ViewType.HOURLY:
                return new HourlyViewHolder(parent);
            default:
                return new FooterViewHolder(parent);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        /**
         * notes:
         * 几何天气的处理方案；
         * 在ViewHolder中处理 onBindView
         * 其所有ViewHolder都继承自同一AbstractViewHolder
         *
         * ********************************************************************************
         * AbstractViewHolder中的 onBindView 方法有 CallSuper注解
         * 其用法：
         * Denotes that any overriding methods should invoke this method as well.
         * Example:
         *     @CallSuper
         *     public abstract void onFocusLost();
         * 含义：任何子类重写该方法需要调用此父类方法。
         *      如某一子类重写方法中需要调用 super.onFocusLost();
         *
         * 目的：重用父类方法，参数初始化更方便，属于重用代码；
         *      为了防止子类中参数没有初始化而出现空异常。
         ***********************************************************************************
         *
         * 在各自的ViewHolder中，HeaderViewHolder, DailyViewHolder处理数据的绑定
         * 而在此方法中对 AbstractViewHolder的onBindView方法的调用。
         * e.g:
         * if(holder instanceof AbstractViewHolder){
         *     ((AbstractViewHolder)holder).onBindView(...);
         * }else{
         *     ...
         * }
         *
         * Q: 这里调用到的 onBindView 是父类的还是子类的？
         *      当将子类对象强转为父类对象时，调用的会是子类还是父类的方法？
         * A: java基础，子类对象调用的时子类的重载方法。上述例子的强转类似 Father f=new Son();
         *      f调用的重载方法将是子类重载后的方法。
         */
        if (holder instanceof AbstractViewHolder) {
            ((AbstractViewHolder) holder).onBindView(weatherModel);
        }
    }

    @Override
    public int getItemCount() {

        return cardViewTypeList.size();
    }

    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        return cardViewTypeList.get(position);
    }

    public void setWeatherModel(WeatherModel weatherModel) {

        this.weatherModel = weatherModel;
        notifyDataSetChanged();
    }

}
