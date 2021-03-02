package com.example.practicamvvm.util;

public class User {
    private String nombre;
    private String edad;

    public User(){}

    public User(String nombre, String edad) {
        nombre = nombre;
        edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
