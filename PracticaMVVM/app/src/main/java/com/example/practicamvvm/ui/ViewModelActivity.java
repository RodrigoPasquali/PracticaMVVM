package com.example.practicamvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practicamvvm.R;
import com.example.practicamvvm.util.Sumar;
import com.example.practicamvvm.viewModel.SumarViewModel;

public class ViewModelActivity extends AppCompatActivity {
    private TextView tvSumar;
    private TextView tvSumarViewModel;
    private Button btSumar;
    private Integer resultado;
    private SumarViewModel sumarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        setUpView();
    }

    private void setUpView() {
        sumarViewModel = ViewModelProviders.of(this).get(SumarViewModel.class);

        tvSumar = findViewById(R.id.tvSumar);
        tvSumarViewModel = findViewById(R.id.tvSumarViewModel);
        btSumar = findViewById(R.id.btSumar);

        try {
            resultado = Integer.valueOf((String) tvSumar.getText());
        }catch (NumberFormatException e) {
            resultado = 0;
        }

        tvSumar.setText("sumar " + resultado);
        tvSumarViewModel.setText("sumar view model " + sumarViewModel.getResultado());
        btSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado = Sumar.sumar(resultado);
                tvSumar.setText("sumar " + resultado);

                sumarViewModel.setResultado(Sumar.sumar(sumarViewModel.getResultado()));
                tvSumarViewModel.setText("sumar view model " + sumarViewModel.getResultado());
            }
        });
    }
}