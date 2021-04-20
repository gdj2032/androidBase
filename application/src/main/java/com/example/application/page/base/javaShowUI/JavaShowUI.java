package com.example.application.page.base.javaShowUI;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.application.R;

public class JavaShowUI extends AppCompatActivity {

    private ImageView[] img = new ImageView[12];
    private int[] imagePath = new int[] {
            R.mipmap.img1,
            R.mipmap.img2,
            R.mipmap.img3,
            R.mipmap.img4,
            R.mipmap.img5,
            R.mipmap.img6,
            R.mipmap.img7,
            R.mipmap.img3,
            R.mipmap.img4,
            R.mipmap.img5,
            R.mipmap.img6,
            R.mipmap.img7,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_java_show_ui);
        GridLayout layout = findViewById(R.id.java_show_ui);
        for (int i = 0; i < imagePath.length; i++) {
            img[i] = new ImageView(JavaShowUI.this);
            img[i].setImageResource(imagePath[i]);
            img[i].setPadding(2,2,2,2);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(116,68);
            img[i].setLayoutParams(params);
            layout.addView(img[i]);
        }
//        for (int i = 0; i < imagePath.length; i++) {
//
//        }
    }
}
