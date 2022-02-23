package com.lemondev.weather.models.transform;

import com.lemondev.weather.R;

import java.util.HashMap;
import java.util.Map;

/**
 * 2022/2/18
 * Created by vibrantBobo
 */

public class SkyconIconTransform {
    private static Map<String, Integer> skyconIconOf;

    static {
        skyconIconOf = new HashMap<>();

        skyconIconOf.put("CLEAR_DAY", R.drawable.icons8_sun_100);
        skyconIconOf.put("CLEAR_NIGHT", R.drawable.icons8_moon_and_stars_100);
        skyconIconOf.put("PARTLY_CLOUDY_DAY", R.drawable.icons8_partly_cloudy_day_100);
        skyconIconOf.put("PARTLY_CLOUDY_NIGHT", R.drawable.icons8_night_100);
        skyconIconOf.put("CLOUDY", R.drawable.icons8_cloud_100);
        skyconIconOf.put("LIGHT_HAZE", R.drawable.icons8_haze_100);
        skyconIconOf.put("MODERATE_HAZE", R.drawable.icons8_haze_100);
        skyconIconOf.put("HEAVY_HAZE", R.drawable.icons8_haze_100);
        skyconIconOf.put("LIGHT_RAIN", R.drawable.icons8_light_rain_100);
        skyconIconOf.put("MODERATE_RAIN", R.drawable.icons8_moderate_rain_100);
        skyconIconOf.put("HEAVY_RAIN", R.drawable.icons8_heavy_rain_100);
        skyconIconOf.put("STORM_RAIN", R.drawable.icons8_storm_100);
        skyconIconOf.put("FOG", R.drawable.icons8_fog_100);
        skyconIconOf.put("LIGHT_SNOW", R.drawable.icons8_light_snow_100);
        skyconIconOf.put("MODERATE_SNOW", R.drawable.icons8_snow_100);
        skyconIconOf.put("HEAVY_SNOW", R.drawable.icons8_snow_storm_100);
        skyconIconOf.put("STORM_SNOW", R.drawable.icons8_snow_storm_100);
        skyconIconOf.put("DUST", R.drawable.icons8_broom_100);
        skyconIconOf.put("SAND", R.drawable.icons8_sandbox_50);
        skyconIconOf.put("WIND", R.drawable.icons8_windy_weather_100);
    }

    public static Integer getSkyconIcon(String value) {
        return skyconIconOf.get(value);
    }
}
