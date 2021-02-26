package com.example.ldg;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BcontentInfo extends AppCompatActivity {
    String reg,writetime,content,id;

    public BcontentInfo(String reg, String writetime, String content, String id){
        this.reg = reg;
        this.writetime = writetime;
        this.content = content;
        this.id = id;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
    }
}
