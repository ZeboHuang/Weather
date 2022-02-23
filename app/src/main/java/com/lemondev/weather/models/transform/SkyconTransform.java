package com.lemondev.weather.models.transform;

import java.util.HashMap;
import java.util.Map;

/**
 * 2022/2/18
 * Created by vibrantBobo
 */

public class SkyconTransform {

    private static Map<String, String> skyconOf;

    static {
        skyconOf = new HashMap<>();
        skyconOf.put("CLEAR_DAY", "晴（白天）");
        skyconOf.put("CLEAR_NIGHT", "晴（夜间）");
        skyconOf.put("PARTLY_CLOUDY_DAY", "多云（白天）");
        skyconOf.put("PARTLY_CLOUDY_NIGHT", "多云（夜间）");
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
    }

    /**
     * 转换函数
     *
     * @return
     */
    public static String getSkycon(String value) {
        return skyconOf.get(value);
    }
}
