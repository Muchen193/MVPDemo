package com.example.mvpdemo.model;

import android.util.Log;

import com.example.mvpdemo.bean.User;

import org.litepal.crud.DataSupport;

import java.util.List;

public class UserModel implements IUserModel {

    public UserModel(){

    }

    @Override
    public void saveUserData(User user) {
        user.save();
    }

    @Override
    public User readUserData(String name) {
        List<User> userList = DataSupport.where("username = ?",name).find(User.class);
        if (userList.size() > 0 )
            return userList.get(0);
        return null;
    }
}
