package com.example.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdemo.bean.User;
import com.example.mvpdemo.presenter.UserPresent;
import com.example.mvpdemo.view.IUserView;

public class MainActivity extends AppCompatActivity implements IUserView {
    private TextView mUserEditText, mPassEditText, mNameRead;
    private UserPresent mUserpresent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserEditText = (TextView) findViewById(R.id.m_UserName);
        mPassEditText = (TextView)findViewById(R.id.m_Password);
        mNameRead = (TextView)findViewById(R.id.q_UserName);

        mUserpresent = new UserPresent(this);

    }

    @Override
    public void setUserName(String userName) {
        mUserEditText.setText(userName);
    }

    @Override
    public void setPassword(String password) {
        mPassEditText.setText(password);
    }

    @Override
    public void error(String errormsg) {
        Toast.makeText(this, errormsg, Toast.LENGTH_SHORT).show();
    }

    public void  save(View view){
        User user = new User();
        user.setUsername(mUserEditText.getText().toString());
        user.setPassword(mPassEditText.getText().toString());
        mUserpresent.saveUser(user);
        mUserEditText.setText("");
        mPassEditText.setText("");
        Toast.makeText(this,"已保存", Toast.LENGTH_SHORT).show();
    }

    public void read(View view){
        mUserpresent.readUser(mNameRead.getText().toString());
    }

    public void clear(View view){
        mUserEditText.setText("");
        mPassEditText.setText("");
    }
}
