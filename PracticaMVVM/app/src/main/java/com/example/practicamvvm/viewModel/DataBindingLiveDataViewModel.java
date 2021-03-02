package com.example.practicamvvm.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practicamvvm.util.User;

public class DataBindingLiveDataViewModel extends ViewModel {
    private MutableLiveData<User> user;

    public DataBindingLiveDataViewModel() {
        this.user = new MutableLiveData<>();
    }

    public LiveData<User> getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user.setValue(user);
    }

    public void updateUser() {
        User userEjemplo = new User("Roberto", "47");
        this.user.setValue(userEjemplo);
    }
}
