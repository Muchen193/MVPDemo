package com.example.mvpdemo.model;

import com.example.mvpdemo.bean.User;

public interface IUserModel {
    void saveUserData(User user);
    User readUserData(String name);
}
