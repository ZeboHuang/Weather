package com.lemondev.weather.models.transform;

import com.lemondev.weather.R;

import java.util.HashMap;
import java.util.Map;

/**
 * 2022/2/19
 * Created by vibrantBobo
 */

public class SkyconBackgroundTransform {
    private static Map<String, Integer> skyconBgOf;

    static {
        skyconBgOf = new HashMap<>();

        skyconBgOf.put("CLEAR_DAY", R.drawable.background_clear_day);
        skyconBgOf.put("CLEAR_NIGHT", R.drawable.background_clear_night);
        skyconBgOf.put("PARTLY_CLOUDY_DAY", R.drawable.background_partly_cloudy_day);
        skyconBgOf.put("PARTLY_CLOUDY_NIGHT", R.drawable.background_partly_cloudy_night);
        skyconBgOf.put("CLOUDY", R.drawable.background_cloudy);
        skyconBgOf.put("LIGHT_HAZE", R.drawable.background_haze);
        skyconBgOf.put("MODERATE_HAZE", R.drawable.background_haze);
        skyconBgOf.put("HEAVY_HAZE", R.drawable.background_haze);
        skyconBgOf.put("LIGHT_RAIN", R.drawable.background_drrizle);
        skyconBgOf.put("MODERATE_RAIN", R.drawable.background_rain);
        skyconBgOf.put("HEAVY_RAIN", R.drawable.background_heavy_rain);
        skyconBgOf.put("STORM_RAIN", R.drawable.background_thunderstorm);
        skyconBgOf.put("FOG", R.drawable.background_fog);
        skyconBgOf.put("LIGHT_SNOW", R.drawable.background_light_snow_shower);
        skyconBgOf.put("MODERATE_SNOW", R.drawable.background_snow);
        skyconBgOf.put("HEAVY_SNOW", R.drawable.background_heavy_snow_storm);
        skyconBgOf.put("STORM_SNOW", R.drawable.background_snow1);
        skyconBgOf.put("DUST", R.drawable.background_dust);
        skyconBgOf.put("SAND", R.drawable.background_sand);
        skyconBgOf.put("WIND", R.drawable.background_squalls);
    }

    public static Integer getSkyconBackground(String value) {
        return skyconBgOf.get(value);
    }
}
