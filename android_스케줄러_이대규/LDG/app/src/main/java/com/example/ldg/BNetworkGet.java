package com.example.ldg;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BNetworkGet extends AsyncTask<String, Void, String> {
    private URL Url;
    private String URL_Address = "http://192.168.219.100/MyDBProject/testDB_B.jsp";
    private Bcustom_Adapter adapter;

    public BNetworkGet(Bcustom_Adapter adapter){
        this.adapter = adapter;
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

            StringBuffer buffer = new StringBuffer();
            buffer.append("id").append("=").append(strings[0]);

            OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(),"utf-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder= new StringBuilder();
            BufferedReader in = new BufferedReader((new InputStreamReader(conn.getInputStream(),"utf-8")));
            String line;
            while ((line = in.readLine()) != null){
                builder.append(line + "\n");
            }
            res = builder.toString();

        }  catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("Get Result",res);
        return res;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        ArrayList<BcontentInfo> contentList = new ArrayList<BcontentInfo>();
        int count = 0;
        try{
            count = JsonParser.getBcontentInfoJson(s,contentList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(count ==0){
            adapter.setDatas(contentList);
        }else {
            adapter.setDatas(contentList);
            adapter.notifyDataSetInvalidated();
        }
    }

}
