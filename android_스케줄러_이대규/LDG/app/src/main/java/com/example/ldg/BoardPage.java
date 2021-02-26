package com.example.ldg;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BoardPage extends AppCompatActivity {

    private Button searchBtn1,writeBtn1,refreshBtn1;
    private ListView listView1;
    private Bcustom_Adapter adapter1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boardpage);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        TextView tv_id1 = (TextView) findViewById(R.id.tv_id1); //TextView 바인딩

        Intent intent = getIntent();
        String d = intent.getStringExtra("D");
        tv_id1.setText(d);


        listView1 = (ListView) findViewById(R.id.listView1);
        adapter1 = new Bcustom_Adapter(BoardPage.this,R.layout.adapter_bcontent, new ArrayList<BcontentInfo>(), d);
        listView1.setAdapter(adapter1);

        writeBtn1 = (Button) findViewById(R.id.btnWrite1);
        writeBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = tv_id1.getText().toString();
                Intent in = new Intent(BoardPage.this,BWrite.class);
                in.putExtra("S",s);
                startActivity(in);
            }
        });

        refreshBtn1 = (Button) findViewById(R.id.refreshBtn1);
        refreshBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"asdf",Toast.LENGTH_LONG).show();
                String a1 = tv_id1.getText().toString();
                new BNetworkGet((Bcustom_Adapter) listView1.getAdapter()).execute(a1);
            }
        });

        searchBtn1 = (Button) findViewById(R.id.btn_Search1) ;
        searchBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search1 = ((EditText)findViewById(R.id.edt_search1)).getText().toString();
                Toast.makeText(getApplicationContext(),"asdf",Toast.LENGTH_LONG).show();
                String content1 = ((EditText) findViewById(R.id.edt_search1)).getText().toString();
                new BNetworkSearch(adapter1).execute(content1);
            }
        });

        String a = tv_id1.getText().toString();
         new BNetworkGet((Bcustom_Adapter) listView1.getAdapter()).execute(a);
    }
    public void getId(){
        TextView tv_id1 = (TextView)findViewById(R.id.tv_id1);
        Intent intent = getIntent();
        String d = intent.getStringExtra("D");
        tv_id1.setText(d);
    }
}
