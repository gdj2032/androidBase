package com.example.ordinary_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * 普通按钮添加单击事件
     * 1. 匿名内部类作为单击事件
     * 2. 通过onClick属性实现
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button b = findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "单击了按钮-----1", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void myClick(View v) {
        //要执行动作的代码
        Toast.makeText(MainActivity.this, "单击了按钮-----2", Toast.LENGTH_SHORT).show();
    }
}
