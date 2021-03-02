package com.example.practicamvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.practicamvvm.R;
import com.example.practicamvvm.databinding.ActivityDataBiningLiveDataBinding;
import com.example.practicamvvm.util.User;
import com.example.practicamvvm.viewModel.DataBindingLiveDataViewModel;

public class DataBindingLiveDataActivity extends AppCompatActivity {
    private ActivityDataBiningLiveDataBinding activityLiveDataBinding;
    private DataBindingLiveDataViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_bining_live_data);
        activityLiveDataBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_data_bining_live_data);

        setUp();
    }

    private void setUp() {
        activityLiveDataBinding.setLifecycleOwner(this);

        viewModel = ViewModelProviders.of(this).get(DataBindingLiveDataViewModel.class);
        User user = new User("Pipo", "14");
        viewModel.setUser(user);
        activityLiveDataBinding.setViewModel(viewModel);
    }
}