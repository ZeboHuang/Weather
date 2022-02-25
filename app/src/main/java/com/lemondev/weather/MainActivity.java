package com.lemondev.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lemondev.weather.databinding.ActivityMainBinding;
import com.lemondev.weather.models.PlaceModel;
import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.request.Servicey;
import com.lemondev.weather.request.WeatherApi;
import com.lemondev.weather.request.WeatherApiClient;
import com.lemondev.weather.response.WeatherResponse;
import com.lemondev.weather.ui.fragment.MainFragment;
import com.lemondev.weather.utils.Credentials;
import com.lemondev.weather.viewmodels.PlaceViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private final String TAG = "MainActivity";


    //viewbinding
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.mainFragmentContainerView, MainFragment.class, null)
                    .commit();
        }

    }


    void GetUpdate() {
        WeatherApi weatherApi = Servicey.getWeatherApi();
        weatherApi.update(
                Credentials.CAIYUN_KEY,
                String.valueOf(118.186289),
                String.valueOf(25.055955),
                12,
                15
        ).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

                if (response.code() == 200) {
                    WeatherModel weatherModel = response.body().getWeather();
                    Log.d(TAG, "onResponse: forecast:" + weatherModel.getForecast_keypoint());
                    Log.d(TAG, "onResponse: realtime");
//                    Log.d(TAG, "onResponse: temperature: " + weatherModel.getRealtime().getTemperature());
//                    Log.d(TAG, "onResponse: apparent_temperature: " + weatherModel.getRealtime().getApparent_temperature());
//                    Log.d(TAG, "onResponse: humidity: " + weatherModel.getRealtime().getHumidity());
//                    Log.d(TAG, "onResponse: skycon: " + weatherModel.getRealtime().getSkycon());
//                    Log.d(TAG, "onResponse: visibility: " + weatherModel.getRealtime().getVisibility());
//                    Log.d(TAG, "onResponse: hourly");
//                    for (int i = 0; i < weatherModel.getHourly().getTemperature().size(); i++) {
//                        Log.d(TAG, "onResponse: date: " + weatherModel.getHourly().getTemperature().get(i).getDate());
//                        Log.d(TAG, "onResponse: temp: " + weatherModel.getHourly().getTemperature().get(i).getValue());
//                        Log.d(TAG, "onResponse: skycon: " + weatherModel.getHourly().getSkycon().get(i).getValue());
//                    }
//
//                    Log.d(TAG, "onResponse: daily");
//                    for (int i = 0; i < weatherModel.getDaily().getTemperature().size(); i++) {
//                        Log.d(TAG, "onResponse: date: " + weatherModel.getDaily().getTemperature().get(i).getDate());
//                        Log.d(TAG, "onResponse: max: " + weatherModel.getDaily().getTemperature().get(i).getMax());
//                        Log.d(TAG, "onResponse: sunrize: " + weatherModel.getDaily().getAstro().get(i).getSunrise().getTime());
//                        Log.d(TAG, "onResponse: skycon_light: " + weatherModel.getDaily().getSkycon_08h_20h().get(i).getValue());
//                    }
                } else {
                    Log.d(TAG, "onResponse: failure");
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getCause());


            }
        });

    }

}