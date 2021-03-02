package com.example.practicamvvm.viewModel;

import androidx.lifecycle.ViewModel;

public class SumarViewModel extends ViewModel {
    int resultado;

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
