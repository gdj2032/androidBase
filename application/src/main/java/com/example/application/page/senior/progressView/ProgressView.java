package com.example.application.page.senior.progressView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.application.R;

public class ProgressView extends AppCompatActivity {

    private ProgressBar progressBar;

    private int progress = 0;

    private Handler handler;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senior_progress_view);

        progressBar = findViewById(R.id.progress_bar);

        handler = new Handler(){
            @SuppressLint(value = "HandlerLeak")
            @Override
            public void handleMessage(Message msg) {
                Log.d("message", "handleMessage: " + progress);
                if (msg.what == 0x111) {
                    progressBar.setProgress(progress);
                } else if (msg.what == 0x110) {
                    Toast.makeText(ProgressView.this,"进度条已完成", Toast.LENGTH_LONG);
                };
            };
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    progress = doWork();
                    Message m = new Message();
                    if (progress < 100) {
                        m.what = 0x111;
                        handler.sendMessage(m);
                    } else {
                        m.what = 0x110;
                        handler.sendMessage(m);
                        break;
                    }
                }
            }
            private int doWork () {
                progress += Math.random() * 10;
                if (progress >= 100) {
                    progress = 100;
                }
                Log.d("progress", "doWork: " + progress);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return  progress;
            }
        }).start();

        SeekBar seekBar = findViewById(R.id.seek_bar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(ProgressView.this, "改变了"+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
