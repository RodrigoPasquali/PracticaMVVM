package com.example.practicamvvm.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practicamvvm.util.User;

public class DataBindingLiveDataViewModel extends ViewModel {
    private MutableLiveData<User> user;
    private MutableLiveData<Boolean> visible;
    private MutableLiveData<Float> textSize;

    public DataBindingLiveDataViewModel() {
        this.user = new MutableLiveData<>();

        this.visible = new MutableLiveData<>();
        this.visible.setValue(true);

        this.textSize = new MutableLiveData<>();
        this.textSize.setValue(14f);
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

    public LiveData<Boolean> getVisible() {
        return this.visible;
    }

    public void changeVisibility() {
        if (this.visible.getValue()) {
            this.visible.setValue(false);
        } else {
            this.visible.setValue(true);
        }
    }

    public void modifyView() {
        this.changeVisibility();
        textSize.setValue(textSize.getValue() + 5f);
    }

    public void setTextSize(float size) {
        this.textSize.setValue(size);
    }

    public LiveData<Float> getTextSize() {
        return this.textSize;
    }
}
