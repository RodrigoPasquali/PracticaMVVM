package com.example.practicamvvm.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.practicamvvm.util.User;

import java.util.LinkedList;
import java.util.List;

public class UserViewModel extends ViewModel {
    private List<User> userList;

    public UserViewModel() {
        userList = new LinkedList<User>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        this.userList.add(user);
    }
}
