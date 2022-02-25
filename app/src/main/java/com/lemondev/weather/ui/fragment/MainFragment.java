package com.lemondev.weather.ui.fragment;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.lemondev.weather.QueryActivity;
import com.lemondev.weather.R;
import com.lemondev.weather.models.LocationModel;
import com.lemondev.weather.models.PlaceModel;
import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.request.WeatherApiClient;
import com.lemondev.weather.ui.adapters.MainAdapter;
import com.lemondev.weather.utils.TransformUtils;
import com.lemondev.weather.viewmodels.WeatherViewModel;

/**
 * 2022/2/22
 * Created by vibrantBobo
 */

public class MainFragment extends BaseFragment {
    private final int REQUEST_FOR_LOCATION = 1;


    private ImageView mBackground;

    private MaterialToolbar toolbar;

    private MainAdapter mainAdapter;

    private RecyclerView recyclerView;

    protected WeatherViewModel weatherViewModel;



    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = view.findViewById(R.id.mainFragmentRecyclerView);
        mBackground = view.findViewById(R.id.background);
        toolbar = view.findViewById(R.id.toolbar);

        initView();

        return view;
    }

    void startQueryActivity() {
        Intent intent = new Intent(getActivity(), QueryActivity.class);
        startActivityForResult(intent, REQUEST_FOR_LOCATION);
    }

    void initView() {
        //toolbar
        toolbar.inflateMenu(R.menu.menu_top_bar);
        toolbar.setOnMenuItemClickListener(new MaterialToolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_top_bar_search:
                        startQueryActivity();
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

        ObserveWeatherChanged();

        WeatherApiClient.getInstance().
                update(
                        String.valueOf(118.186289),
                        String.valueOf(25.055955));
    }

    void update(LocationModel location) {
        Log.d("MTAG", "update address " + location.getLocation());
        WeatherApiClient.getInstance().
                update(
                        location.getLongitude(),
                        location.getLatitude());
    }


    void ObserveWeatherChanged() {
        weatherViewModel.getWeather().observe(getViewLifecycleOwner(), new Observer<WeatherModel>() {
            @Override
            public void onChanged(WeatherModel weatherModel) {
                /**
                 * set background
                 */
                mBackground.setImageResource(TransformUtils.getSkyconBackground(weatherModel.getRealtime().getSkycon()));


                mainAdapter.setWeatherModel(weatherModel);
                recyclerView.setAdapter(mainAdapter);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_FOR_LOCATION) {
            if (resultCode == AppCompatActivity.RESULT_OK) {

                Bundle bundle = data.getBundleExtra("place");
                PlaceModel placeModel = bundle.getParcelable("placeModel");
                toolbar.setTitle(placeModel.getName());
                update(placeModel.getLocation());
            }
        }
    }
}
