package com.example.practicamvvm.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practicamvvm.util.User;

import java.util.LinkedList;
import java.util.List;

public class LiveDataViewModel extends ViewModel {
    private MutableLiveData<List<User>> userListLiveData;
    private List<User> userList;

    public LiveData<List<User>> getUserList() {
        if(userListLiveData == null) {
            userListLiveData = new MutableLiveData<>();
            userList = new LinkedList<User>();
        }

        return userListLiveData;
    }

    public void addUser(User user) {
        userList.add(user);
        userListLiveData.setValue(userList);
    }
}
