package com.example.practicamvvm.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practicamvvm.util.User;

public class DataBindingLiveDataViewModel extends ViewModel {
    private MutableLiveData<User> user;
    private MutableLiveData<Boolean> visible;

    public DataBindingLiveDataViewModel() {
        this.user = new MutableLiveData<>();
        this.visible = new MutableLiveData<>();
        this.visible.setValue(true);
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

    public void setVisible(boolean visible) {
        this.visible.setValue(visible);
    }

    public MutableLiveData<Boolean> getVisible() {
        return this.visible;
    }

    public void changeVisibility() {
        if (this.visible.getValue()) {
            this.visible.setValue(false);
        } else {
            this.visible.setValue(true);
        }
    }
}
