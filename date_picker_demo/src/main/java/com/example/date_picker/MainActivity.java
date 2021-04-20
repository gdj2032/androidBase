package com.example.date_picker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int year, month, day;

    DatePicker dp;

    TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.date_picker);

        tp = findViewById(R.id.time_picker);

        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year = year;
                MainActivity.this.month = month;
                MainActivity.this.day = dayOfMonth;
                show(year, month, dayOfMonth);
            }
        });

        tp.setIs24HourView(true);

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String str = hourOfDay + "时" + minute + "分";
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
            }
        });


    }

    private void show (int year, int month, int day) {
        String str = year + "年" + (month + 1) + "月" + day + "日";
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
    }

}
