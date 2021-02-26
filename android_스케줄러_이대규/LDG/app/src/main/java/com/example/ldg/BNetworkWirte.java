package com.example.ldg;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BNetworkWirte extends AsyncTask<String, Void, String>{
    private URL Url;
    private String URL_Address = "http://192.168.219.100/MyDBProject/testDB4_bwrite.jsp";
    Activity act;

    public BNetworkWirte(BWrite act) {
        this.act=act;
    }

    @Override
    protected String doInBackground(String... strings) {
        String res = "";
        try{
            Url = new URL(URL_Address);
            HttpURLConnection conn = (HttpURLConnection) Url.openConnection();

            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=utf-8");

            //우리가 입력하는 값들을 말함
            StringBuffer buffer = new StringBuffer();
            //buffer.append("num").append("=").append(strings[0]);
            buffer.append("content").append("=").append(strings[0]);
            buffer.append("&id").append("=").append(strings[1]);

            //서버로 전송 /서버와 안드로이드 사이 통신의 경계선
            OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null){
                builder.append(line +"\n");
            }

            res = builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    protected  void onPostExecute(String s){
        super.onPostExecute(s);
        int res = 0;
        try{
            res = JsonParser.getResultJson(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(res == 0){
        }else {
            Toast.makeText(act,"등록성공",Toast.LENGTH_SHORT).show();
        }
    }
}
