package com.lemondev.weather;

import java.time.chrono.MinguoChronology;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * 2022/2/12
 * Created by vibrantBobo
 */

public class AppExcutors {
    private static AppExcutors instance;
    private ScheduledExecutorService mNetwork;

    private AppExcutors() {
        mNetwork = new ScheduledThreadPoolExecutor(1);
    }

    public static AppExcutors getInstance() {
        if (instance == null) {
            synchronized (AppExcutors.class) {
                if (instance == null) {
                    instance = new AppExcutors();
                }
            }
        }
        return instance;
    }


    public ScheduledExecutorService getmNetwork() {
        return mNetwork;
    }
}
