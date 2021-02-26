package com.example.ldg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class titlepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        TextView tvid = (TextView)findViewById(R.id.tvid);

        Intent intent = getIntent();
        String a = intent.getStringExtra("D");
        tvid.setText(a);

        Button btnschedule = (Button)findViewById(R.id.btn_schedule);
        btnschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String D = ((TextView)findViewById(R.id.tvid)).getText().toString();

                Intent in = new Intent(titlepage.this,LoginPage.class);
                in.putExtra("D",D);
                startActivity(in);
            }
        });

        Button btnMap = (Button)findViewById(R.id.btn_map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1 = new Intent(titlepage.this,myMap.class);
                startActivity(in1);
            }
        });

        Button btnMail = (Button)findViewById(R.id.btn_mail);
        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2 = new Intent(titlepage.this, Mailpage.class);
                startActivity(in2);
            }
        });

        Button btnBoard = (Button)findViewById(R.id.btn_board);
        btnBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String D = ((TextView)findViewById(R.id.tvid)).getText().toString();

                Intent in3 = new Intent(titlepage.this,BoardPage.class);
                in3.putExtra("D",D);
                startActivity(in3);
            }
        });
    }
}