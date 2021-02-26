package com.example.ldg;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfo extends AppCompatActivity {
    String id,pw,name,phone;
    public UserInfo(String id, String pw, String name, String phone){
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}