package com.example.application.page.base.datePicker;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.application.R;

import java.util.Calendar;

public class DatePickerView extends AppCompatActivity {

    int year, month, day;

    DatePicker dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_date_picker_view);

        dp = findViewById(R.id.date_picker);

        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                DatePickerView.this.year = year;
                DatePickerView.this.month = month;
                DatePickerView.this.day = dayOfMonth;
                show(year, month, dayOfMonth);
            }
        });

    }

    private void show (int year, int month, int day) {
        String str = year + "年" + (month + 1) + "月" + day + "日";
        Toast.makeText(DatePickerView.this, str, Toast.LENGTH_LONG).show();
    }
}
