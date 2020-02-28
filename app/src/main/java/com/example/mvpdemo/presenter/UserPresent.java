package com.example.mvpdemo.presenter;

import com.example.mvpdemo.bean.User;
import com.example.mvpdemo.model.IUserModel;
import com.example.mvpdemo.model.UserModel;
import com.example.mvpdemo.view.IUserView;

public class UserPresent {
    private IUserView mIUserView;
    private IUserModel mIUserModel;
    public UserPresent(IUserView mIUserView){
        this.mIUserView = mIUserView;
        mIUserModel = new UserModel();
    }

    public void saveUser(User user){
        mIUserModel.saveUserData(user);
        System.out.println("保存成功");
    }

    public void readUser(String name){
        User user = mIUserModel.readUserData(name);
        if (user != null){
            mIUserView.setUserName(user.getUsername());
            mIUserView.setPassword(user.getPassword());
        } else {
            mIUserView.error("没有找到");
        }
    }
}
