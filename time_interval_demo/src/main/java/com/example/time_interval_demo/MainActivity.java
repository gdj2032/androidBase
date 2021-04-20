package com.example.time_interval_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.WindowManager;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ch = findViewById(R.id.chronometer);
        ch.setBase(SystemClock.elapsedRealtime()); //当前系统时间
        ch.setFormat("%s");
        ch.start();

        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - ch.getBase();
                if (time >= 60000) {
                    ch.stop();
                }
            }
        });

    }
}
