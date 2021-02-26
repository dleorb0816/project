package com.example.ldg;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button btn1 = (Button) findViewById(R.id.btn_login);//로그인 버튼
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = ((EditText)findViewById(R.id.et_id)).getText().toString();
                String pw = ((EditText)findViewById(R.id.et_pass)).getText().toString();

               new NetworkLogin(MainActivity.this).execute(id,pw);
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn_register);//회원가입 버튼
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,Add.class);
                startActivity(in);
            }
        });
    }

    public void LoginSuccess(){
        Toast myToast = Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_SHORT);
        myToast.show();
        String D = ((EditText)findViewById(R.id.et_id)).getText().toString();

        Intent in = new Intent(getApplicationContext(),titlepage.class);
        in.putExtra("D",D);
        startActivity(in);
    }

    public void LoginFail(){
        Toast myToast = Toast.makeText(getApplicationContext(),"로그인 실패",Toast.LENGTH_SHORT);
        myToast.show();
    }
}