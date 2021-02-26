package com.example.ldg;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ContentInfo extends AppCompatActivity {
    String reg,num,content,id;

    public ContentInfo(String reg, String num, String content, String id){
        this.reg = reg;
        this.num = num;
        this.content = content;
        this.id = id;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
    }
}
