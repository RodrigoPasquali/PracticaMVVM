package com.example.practicamvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practicamvvm.R;
import com.example.practicamvvm.util.User;
import com.example.practicamvvm.viewModel.UserViewModel;

import java.util.LinkedList;
import java.util.List;

public class UserViewModelActivity extends AppCompatActivity {
    private EditText etNombre;
    private EditText etEdad;
    private Button btSalvar;
    private Button btVerUser;
    private TextView tvUser;
    private TextView tvUserViewModel;
    private List<User> userList;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_model);

        setUpView();
    }

    private void setUpView(){
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        userList = new LinkedList<User>();
        tvUser = findViewById(R.id.tvUser);
        tvUserViewModel = findViewById(R.id.tvUserViewModel);

        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);

        btSalvar = findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                String edad = etEdad.getText().toString();
                String nombre = etNombre.getText().toString();

                if(!edad.equals("")) {
                    user.setEdad(edad);
                    user.setNombre(nombre);

                    userList.add(user);
                    userViewModel.addUser(user);
                }
            }
        });

        btVerUser = findViewById(R.id.btVer);
        btVerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = "";

                texto = chequearListaNula(userList, texto);

                for (User user : userList) {
                    texto += user.getNombre() + " " + user.getEdad() + "\n";
                }

                tvUser.setText(texto);

                texto = chequearListaNula(userViewModel.getUserList(), texto);

                for (User user : userViewModel.getUserList()) {
                    texto += user.getNombre() + " " + user.getEdad() + "\n";
                }

                tvUserViewModel.setText(texto);
            }
        });
    }

    private String chequearListaNula(List<User> list, String texto) {
        if(list.size() == 0) {
            texto = "vacio";
        } else {
            texto = "";
        }

        return texto;
    }
}