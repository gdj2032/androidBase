package com.example.application;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    String pkg = "com.example.application";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void onIntent(String cls) {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(pkg, cls);
        intent.setComponent(componentName);
        startActivity(intent);
    }

    public void onTable(View view) {
        onIntent("com.example.application.page.base.tableView.TableView");
    }

    public void onDatePicker(View view) {
        onIntent("com.example.application.page.base.datePicker.DatePickerView");
    }

    public void onTimePicker(View view) {
        onIntent("com.example.application.page.base.timePicker.TimePickerView");
    }

    public void onCustomView(View view) {
        onIntent("com.example.application.page.base.customView.CustomView");
    }

    public void onRadioGroup(View view) {
        onIntent("com.example.application.page.base.radioGroupView.RadioGroupView");
    }

    public void onJavaShowUI(View view) {
        onIntent("com.example.application.page.base.javaShowUI.JavaShowUI");
    }

    public void onTimeInterval(View view) {
        onIntent("com.example.application.page.base.timeInterval.TimeInterval");
    }

    public void onProgressView(View view) {
        onIntent("com.example.application.page.senior.progressView.ProgressView");
    }

    public void onImageSwiper(View view) {
        onIntent("com.example.application.page.senior.imageSwiper.ImageSwiper");
    }
}
