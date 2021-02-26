package com.example.ldg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoginPage extends AppCompatActivity {

    private Button searchBtn,writeBtn,refreshBtn;
    private ListView listView;
    private Custom_Adapter adapter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        TextView tv_id = (TextView) findViewById(R.id.tv_id); //TextView 바인딩



        listView = (ListView) findViewById(R.id.listView);
        adapter = new Custom_Adapter(LoginPage.this,R.layout.adapter_content, new ArrayList<ContentInfo>());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        Intent intent = getIntent();
        String d = intent.getStringExtra("D");
        tv_id.setText(d);

        searchBtn = (Button) findViewById(R.id.btnSearch);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = ((EditText) findViewById(R.id.edt_search)).getText().toString();
            }
        });

        writeBtn = (Button) findViewById(R.id.btnWrite);
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = tv_id.getText().toString();
                Intent in = new Intent(LoginPage.this,Write.class);
                in.putExtra("S",s);
                startActivity(in);

            }
        });

        refreshBtn = (Button) findViewById(R.id.refreshBtn);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = tv_id.getText().toString();
                new NetworkGet((Custom_Adapter) listView.getAdapter()).execute(a1);
            }
        });

        searchBtn = (Button) findViewById(R.id.btnSearch) ;
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = ((EditText)findViewById(R.id.edt_search)).getText().toString();
                new NetworkSearch(adapter).execute(search);
            }
        });


        String a = tv_id.getText().toString();
         new NetworkGet((Custom_Adapter) listView.getAdapter()).execute(a);
    }
    public void getId(){
        TextView tv_id = (TextView)findViewById(R.id.tv_id);
        Intent intent = getIntent();
        String d = intent.getStringExtra("D");
        tv_id.setText(d);
    }
}
