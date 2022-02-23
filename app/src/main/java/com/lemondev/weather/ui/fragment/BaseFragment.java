package com.lemondev.weather.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.lemondev.weather.databinding.FragmentMainBinding;
import com.lemondev.weather.viewmodels.MainFragmentViewModel;
import com.lemondev.weather.viewmodels.WeatherViewModel;

/**
 * 2022/2/23
 * Created by vibrantBobo
 */

public class BaseFragment extends Fragment {

    protected WeatherViewModel weatherViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
    }


}
