package com.example.practicamvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practicamvvm.R;
import com.example.practicamvvm.util.User;
import com.example.practicamvvm.viewModel.LiveDataViewModel;

import java.util.List;

public class LiveDataActivity extends AppCompatActivity {
    private TextView tvLiveData;
    private Button btSave;
    private int numero = 0;
    private LiveDataViewModel liveDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        setUpView();
    }

    private void setUpView(){
        liveDataViewModel = ViewModelProviders.of(this).get(LiveDataViewModel.class);
        tvLiveData = findViewById(R.id.tvLiveData);
        btSave = findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUsers();
            }
        });

        final Observer<List<User>> listObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                String texto = "";

                for (User user : users) {
                    texto += user.getNombre() + " " + user.getEdad() + "\n";
                }

                tvLiveData.setText(texto);
            }
        };

        liveDataViewModel.getUserList().observe(this, listObserver);
    }

    private void addUsers() {
        User user = new User();

        switch (numero) {
            case 0:
                user.setNombre("Alberto");
                user.setEdad("30");
                liveDataViewModel.addUser(user);

                break;
            case 1:
                user.setNombre("Maria");
                user.setEdad("23");
                liveDataViewModel.addUser(user);

                break;
            case 2:
                user.setNombre("Manuel");
                user.setEdad("40");
                liveDataViewModel.addUser(user);

                break;
        }
        numero++;
    }
}