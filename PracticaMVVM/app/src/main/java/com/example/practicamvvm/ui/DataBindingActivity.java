package com.example.practicamvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;

import com.example.practicamvvm.R;
import com.example.practicamvvm.databinding.ActivityDataBindingBinding;
import com.example.practicamvvm.util.User;

public class DataBindingActivity extends AppCompatActivity {
    private User user;
    private ActivityDataBindingBinding activityDataBindingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding);
        activityDataBindingBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_data_binding);

        user = new User("Ernesto", "24");
        activityDataBindingBinding.setUser(user);

        setUp();
    }

    private void setUp() {
        user = new User("Ernesto", "24");
        activityDataBindingBinding.setUser(user);
    }
}