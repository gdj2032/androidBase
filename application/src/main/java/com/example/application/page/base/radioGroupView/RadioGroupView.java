package com.example.application.page.base.radioGroupView;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.application.R;

public class RadioGroupView extends AppCompatActivity {

    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_radio_group_view);

        rg = findViewById(R.id.radio_group);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            private static final String TAG = "111";

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);

                Log.d(TAG, "onCheckedChanged: " + rb.getText() + checkedId);
                Toast.makeText(RadioGroupView.this, rb.getText(), Toast.LENGTH_SHORT);

//                for (int i = 1; i <= group.getChildCount(); i++) {
//                    if (i == checkedId) continue;
//                    RadioButton rb_i = findViewById(i);
//                    rb_i.setChecked(i == checkedId);
//                }
            }
        });
    }

}
