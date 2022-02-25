package com.lemondev.weather.request;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.lemondev.weather.AppExcutors;
import com.lemondev.weather.models.PlaceModel;
import com.lemondev.weather.models.WeatherModel;
import com.lemondev.weather.response.PlaceResponse;
import com.lemondev.weather.response.WeatherResponse;
import com.lemondev.weather.utils.Credentials;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class WeatherApiClient {

    private static final String TAG = "MTAG";

    private static WeatherApiClient instance;

    private MutableLiveData<WeatherModel> weather;


    private WeatherApiClient() {
        weather = new MutableLiveData<>();
        placeList = new MutableLiveData<>();
    }

    public static WeatherApiClient getInstance() {
        if (instance == null) {
            synchronized (WeatherApiClient.class) {
                if (instance == null) {
                    instance = new WeatherApiClient();
                }
            }
        }
        return instance;
    }

    public MutableLiveData<WeatherModel> getWeather() {
        return weather;
    }

    private WeatherRunnable weatherRunnable;

    /**
     * weather data update
     */
    public void update(String longitude, String latitude) {
        Log.d("MTAG", "update: ");

        if (weatherRunnable != null) {
            weatherRunnable = null;
        }

        weatherRunnable = new WeatherRunnable(longitude, latitude);

        //implements Runnable interface
        Future mHandler = AppExcutors.getInstance().getmNetwork().submit(weatherRunnable);

        //cancel the request
        AppExcutors.getInstance().getmNetwork().schedule(new Runnable() {
            @Override
            public void run() {
                mHandler.cancel(true);
            }
        }, 5000, TimeUnit.MICROSECONDS);
    }

    private class WeatherRunnable implements Runnable {
        //the params;
        private String longitude, latitude;

        public WeatherRunnable(String longitude, String latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }

        @Override
        public void run() {
            //网络请求，retrofit
            try {
                Response<WeatherResponse> responseCall = Servicey.getWeatherApi().update(Credentials.CAIYUN_KEY,
                        longitude,
                        latitude,
                        Credentials.HOURLY_STEPS,
                        Credentials.DAILY_STEPS).execute();

                if (responseCall.code() == 200) {
                    if (responseCall.body() != null) {
                        weather.postValue(responseCall.body().getWeather());
                    }

                    Log.d("MTAG", "run: " + responseCall.body().getWeather().getForecast_keypoint());
                } else {
                    Log.e("ERROR", "run: " + responseCall.errorBody());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private MutableLiveData<List<PlaceModel>> placeList;
    private PlaceRunnable placeRunnable;

    /**
     * query places
     */
    public void query(String query) {
        if (placeRunnable != null) {
            placeRunnable = null;
        }

        placeRunnable = new PlaceRunnable(query);

        Future mHandler = AppExcutors.getInstance().getmNetwork().submit(placeRunnable);
        AppExcutors.getInstance().getmNetwork().schedule(new Runnable() {
            @Override
            public void run() {
                mHandler.cancel(true);
            }
        }, 5000, TimeUnit.MICROSECONDS);

    }

    private class PlaceRunnable implements Runnable {

        private String query;

        public PlaceRunnable(String query) {
            this.query = query;
        }

        @Override
        public void run() {
            try {
                Response<PlaceResponse> response = Servicey.getWeatherApi().queryPlaces(Credentials.CAIYUN_KEY, query).execute();

                if (response.code() == 200) {
                    if (response.body() != null) {
                        placeList.postValue(response.body().getPlaces());
                        Log.d("MTAG", "run: " + response.body().getQuery());
                    }
                } else {
                    Log.e("ERROR", "run: " + response.errorBody());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public MutableLiveData<List<PlaceModel>> getPlaces() {
        return placeList;
    }
}
