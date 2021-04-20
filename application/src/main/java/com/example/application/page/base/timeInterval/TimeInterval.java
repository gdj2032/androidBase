package com.example.application.page.base.timeInterval;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.WindowManager;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

import com.example.application.R;

public class TimeInterval extends AppCompatActivity {

    Chronometer ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_time_interval);

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
