package com.lemondev.weather.ui.fragment;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.lemondev.weather.R;
import com.lemondev.weather.databinding.FragmentMainBinding;
import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.request.WeatherApiClient;
import com.lemondev.weather.ui.adapters.MainAdapter;
import com.lemondev.weather.utils.Credentials;
import com.lemondev.weather.viewmodels.MainFragmentViewModel;

/**
 * 2022/2/22
 * Created by vibrantBobo
 */

public class MainFragment extends BaseFragment {
    private FragmentMainBinding binding;

    private Toolbar toolbar;

    private MainAdapter mainAdapter;

    private RecyclerView recyclerView;


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(getLayoutInflater(), container, false);

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = view.findViewById(R.id.mainFragmentRecyclerView);

        initView();

        return view;
    }

    void initView() {
        //menu
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbar);
        binding.toolbar.inflateMenu(R.menu.menu_top_bar);
        binding.toolbar.setOnMenuItemClickListener(new androidx.appcompat.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d("MTAG", "onMenuItemClick: ");

                switch (item.getItemId()) {
                    case R.id.menu_top_bar_search:
                        Log.d("MTAG", "onMenuItemClick: ");
                        Toast.makeText(getContext(), "searching...", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_top_bar_setting:
                        Toast.makeText(getContext(), "setting...", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });

        //test
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        binding.mainFragmentRecyclerView.setLayoutManager(linearLayoutManager);
//
//        binding.mainFragmentRecyclerView.setBackgroundColor(Color.YELLOW);
        mainAdapter = new MainAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);

        /**
         * binding.mainFragmentRecyclerView 与 findViewById 不一样？
         */
        Log.d("MTAG", "initView: binding : " + binding.mainFragmentRecyclerView.toString());
        Log.d("MTAG", "initView: findViewById: " + recyclerView.toString());


        ObserveWeatherChanged();

        WeatherApiClient.getInstance().update(
                String.valueOf(118.186289),
                String.valueOf(25.055955));
    }

    void ObserveWeatherChanged() {
        weatherViewModel.getWeather().observe(this, new Observer<WeatherModel>() {
            @Override
            public void onChanged(WeatherModel weatherModel) {
                mainAdapter.setWeatherModel(weatherModel);
                recyclerView.setAdapter(mainAdapter);
            }
        });
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_top_bar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_top_bar_search:
                Log.d("MTAG", "onMenuItemClick: ");
                Toast.makeText(getContext(), "searching...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_top_bar_setting:
                Toast.makeText(getContext(), "setting...", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}
