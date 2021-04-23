package com.example.application.page.senior.imageSwiper;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.application.R;

public class ImageSwiper extends AppCompatActivity {

    private int[] imgs = new int[]{
            R.mipmap.img1,
            R.mipmap.img2,
            R.mipmap.img3,
            R.mipmap.img4,
            R.mipmap.img5,
            R.mipmap.img6,
            R.mipmap.img7,
    };

    private ImageSwitcher is2;
    private int index;
    private float touchDownX, touchUpX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senior_image_swiper);

        onSwitch1();
        onSwitch2();

    }

    public void onSwitch1() {
        ImageSwitcher is = findViewById(R.id.image_switcher1);
        is.setOutAnimation(AnimationUtils.loadAnimation(ImageSwiper.this, android.R.anim.fade_out));
        is.setInAnimation(AnimationUtils.loadAnimation(ImageSwiper.this, android.R.anim.fade_in));
        is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView iv = new ImageView(ImageSwiper.this);
                iv.setImageResource(R.mipmap.img1);
                return iv;
            }
        });
        is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageSwitcher)v).setImageResource(R.mipmap.img2);
            }
        });
    }

    public void onSwitch2() {
        is2 = findViewById(R.id.image_switcher2);
        is2.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView iv = new ImageView(ImageSwiper.this);
                iv.setImageResource(imgs[index]);
                return iv;
            }
        });
        is2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    touchDownX = event.getX();
                    return true;
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    touchUpX = event.getX();
                    if (touchUpX - touchDownX > 100) {
                        //从左往右滑
                        index = index == 0 ? imgs.length - 1 : index - 1;
                        is2.setInAnimation(AnimationUtils.loadAnimation(ImageSwiper.this, R.anim.slide_in_left));
                        is2.setOutAnimation(AnimationUtils.loadAnimation(ImageSwiper.this, R.anim.slide_out_right));
                        is2.setImageResource(imgs[index]);
                    } else if (touchDownX - touchUpX > 100){
                        index = index == imgs.length - 1 ? 0 : index + 1;
                        is2.setInAnimation(AnimationUtils.loadAnimation(ImageSwiper.this, R.anim.slide_in_right));
                        is2.setOutAnimation(AnimationUtils.loadAnimation(ImageSwiper.this, R.anim.slide_out_left));
                        is2.setImageResource(imgs[index]);
                    }
                    return true;
                }
                return false;
            }
        });
    }
}
