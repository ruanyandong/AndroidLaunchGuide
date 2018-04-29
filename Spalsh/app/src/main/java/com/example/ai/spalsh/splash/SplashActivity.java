package com.example.ai.spalsh.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.example.ai.spalsh.MainActivity;
import com.example.ai.spalsh.R;

/**
 * Created by AI on 2017/11/23.
 */

public class SplashActivity extends Activity {
    private static final long DELAY_TIME=3000L;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        },DELAY_TIME);
    }
}
