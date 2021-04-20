package com.example.application.page.base.timePicker;

import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.application.R;

public class TimePickerView extends AppCompatActivity {

    TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_time_picker_view);
        tp = findViewById(R.id.time_picker);

        tp.setIs24HourView(true);

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String str = hourOfDay + "时" + minute + "分";
                Toast.makeText(TimePickerView.this, str, Toast.LENGTH_LONG).show();
            }
        });
    }
}
