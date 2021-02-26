package com.example.ldg;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUpdate extends AsyncTask<String, Void, String> {
    private URL Url;
    private String URL_Address = "http://192.168.219.100/MyDBProject/testDB4_update.jsp";
    private Custom_Adapter adapter;

    public NetworkUpdate(Custom_Adapter adapter){
        this.adapter = adapter;
    }

    @Override
    protected String doInBackground(String... strings) {
        String res ="";
        try{
            Url = new URL(URL_Address);
            HttpURLConnection conn = (HttpURLConnection) Url.openConnection();

            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=utf-8");

            StringBuffer buffer = new StringBuffer();
            buffer.append("reg").append("=").append((strings[0]));
            buffer.append("&num").append("=").append(strings[1]);
            buffer.append("&content").append("=").append(strings[2]);
            buffer.append("&id").append("=").append(strings[3]);

            OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
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
    protected void onPostExecute(String s){
        super.onPostExecute(s);
        int res = 0;
        try{
            res = JsonParser.getResultJson(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (res==0){

        }
        else {
            new NetworkGet(adapter).execute("");
        }
    }
}
