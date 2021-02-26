package com.example.ldg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Write extends AppCompatActivity {
    private Activity mAct;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_write);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        EditText edtid = (EditText)findViewById(R.id.edtId);

        Intent re = getIntent();
        String r = re.getStringExtra("S");
        edtid.setText(r);

        Button ok = (Button)findViewById(R.id.btnOk);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = ((EditText)findViewById(R.id.edtTime)).getText().toString();
                String content = ((EditText)findViewById(R.id.edtContent)).getText().toString();
                String id = ((EditText)findViewById(R.id.edtId)).getText().toString();

                new NetworkWirte(Write.this).execute(num,content,id);

                Intent in = new Intent(Write.this,LoginPage.class);
                in.putExtra("D",id);
                startActivity(in);
            }
        });


    }
}
