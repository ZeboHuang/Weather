package com.lemondev.weather.utils;

import com.lemondev.weather.R;
import com.lemondev.weather.ui.adapters.ViewType;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 2022/2/24
 * Created by vibrantBobo
 */

public class TransformUtils {

    /**
     * skycon
     */
    private static Map<String, String> skyconOf;
    private static Map<String, Integer> skyconIconOf;
    private static Map<String, Integer> skyconBgOf;

    static {
        skyconOf = new HashMap<>();
        skyconOf.put("CLEAR_DAY", "晴");
        skyconOf.put("CLEAR_NIGHT", "晴");
        skyconOf.put("PARTLY_CLOUDY_DAY", "多云");
        skyconOf.put("PARTLY_CLOUDY_NIGHT", "多云");
        skyconOf.put("CLOUDY", "阴");
        skyconOf.put("LIGHT_HAZE", "轻度雾霾");
        skyconOf.put("MODERATE_HAZE", "中度雾霾");
        skyconOf.put("HEAVY_HAZE", "重度雾霾");
        skyconOf.put("LIGHT_RAIN", "小雨");
        skyconOf.put("MODERATE_RAIN", "中雨");
        skyconOf.put("HEAVY_RAIN", "大雨");
        skyconOf.put("STORM_RAIN", "暴雨");
        skyconOf.put("FOG", "雾");
        skyconOf.put("LIGHT_SNOW", "小雪");
        skyconOf.put("MODERATE_SNOW", "中雪");
        skyconOf.put("HEAVY_SNOW", "大雪");
        skyconOf.put("STORM_SNOW", "暴雪");
        skyconOf.put("DUST", "浮尘");
        skyconOf.put("SAND", "沙尘");
        skyconOf.put("WIND", "大风");

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

    public static String getSkycon(String value) {
        return skyconOf.get(value);
    }

    public static Integer getSkyconIcon(String value) {
        return skyconIconOf.get(value);
    }

    public static Integer getSkyconBackground(String value) {
        return skyconBgOf.get(value);
    }


    /**
     * week month
     */
    private static final Map<Integer, String> weekOf;
    private static final Map<Integer, String> monthOf;

    static {
        weekOf = new HashMap<>();
        weekOf.put(1, "周日");
        weekOf.put(2, "周一");
        weekOf.put(3, "周二");
        weekOf.put(4, "周三");
        weekOf.put(5, "周四");
        weekOf.put(6, "周五");
        weekOf.put(7, "周六");

        monthOf = new HashMap<>();
        monthOf.put(0, "正月");
        monthOf.put(1, "二月");
        monthOf.put(2, "三月");
        monthOf.put(3, "四月");
        monthOf.put(4, "五月");
        monthOf.put(5, "六月");
        monthOf.put(6, "七月");
        monthOf.put(7, "八月");
        monthOf.put(8, "九月");
        monthOf.put(9, "十月");
        monthOf.put(10, "十一月");
        monthOf.put(11, "十二月");
    }

    public static String getWeekOf(int number) {
        return weekOf.get(number);
    }

    public static String getMonthOf(int number) {
        return monthOf.get(number);
    }


    private static final Map<Integer, String> tagTypeOf;

    static {
        tagTypeOf = new HashMap<>();
        tagTypeOf.put(ViewType.TEMPERATURE, "温度");
        tagTypeOf.put(ViewType.HUMIDITY, "湿度");
        tagTypeOf.put(ViewType.AIR_QUALITY, "空气质量");
        tagTypeOf.put(ViewType.SUN_CONDITION, "日出日落");
    }

    public static String getTagType(int type) {
        return tagTypeOf.get(type);
    }
}
