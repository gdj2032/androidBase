package com.example.as_test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        //创建布局管理器
        FrameLayout frameLayout = new FrameLayout(this);
        //设置背景
        frameLayout.setBackgroundResource(R.mipmap.bg);
        //添加布局管理器
        setContentView(frameLayout);
        TextView text1 = new TextView(this);
        text1.setText(R.string.start);
        text1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        text1.setTextColor(Color.rgb(17,85,114));
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        text1.setLayoutParams(params);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this).setTitle("系统提示")
                        .setMessage("确认要进入吗?")
                        .setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Log.i("XX游戏", "进入游戏");
                                    }
                                }).setNegativeButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("XX游戏", "退出游戏");
                        finish();
                    }
                }).show();
            }
        });
        frameLayout.addView(text1);
    }
}