package com.example.mmizukami.alohamusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask mediaTask = new TimerTask() {
            @Override
            public void run() {
                // finish it because the activity will not use anymore
                finish();
                startActivity(new Intent(SplashActivity.this,MediaActivity.class));
            }
        };
        Timer timer = new Timer();
        timer.schedule(mediaTask,5000);

    }
}
