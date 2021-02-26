package com.example.ldg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Add extends AppCompatActivity {
    private Activity mAct;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        Button check = (Button)findViewById(R.id.btnCheck);//중복확인
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ((EditText)findViewById(R.id.edtId)).getText().toString();
                new NetworkCheck(Add.this).execute(id);
            }
        });

        Button ok = (Button)findViewById(R.id.btnOk);//확인버튼
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ((EditText)findViewById(R.id.edtId)).getText().toString();
                String pw = ((EditText)findViewById(R.id.edtPw)).getText().toString();
                String name = ((EditText)findViewById(R.id.edtName)).getText().toString();
                String phone = ((EditText)findViewById(R.id.edtPhone)).getText().toString();
                new NetworkInsert(Add.this).execute(id,pw,name,phone);

                Intent in = new Intent(Add.this,MainActivity.class);
                startActivity(in);
            }
        });


    }
}
