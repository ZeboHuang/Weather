package com.lemondev.weather;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

/**
 * 2022/2/25
 * Created by vibrantBobo
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showCustomUI();
    }

    private void showCustomUI() {
        /**
         * 状态栏 透明
         */
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION    //小白条
            );
        } else if (Build.VERSION.SDK_INT >= 30) {
            //都可以
//            WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
            getWindow().setDecorFitsSystemWindows(false);
        }
    }

}
