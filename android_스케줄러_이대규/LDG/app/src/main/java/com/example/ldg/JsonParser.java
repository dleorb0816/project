package com.example.ldg;


import com.example.ldg.ContentInfo;
import com.example.ldg.UserInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class JsonParser {

    static public int getUserInfoJson(String response, ArrayList<UserInfo> userList) throws JSONException{
        String strId;
        String strName;
        String strPhone;
        String strPw;

        JSONObject rootJSON = new JSONObject(response);
        JSONArray jsonArray = new JSONArray(rootJSON.getString("datas"));

        for(int i=0; i<jsonArray.length();i++){
            JSONObject jsonObj = (JSONObject)jsonArray.get(i);

            if(jsonObj.getString("ID").toString().equals("null"))
                strId="-";
            else
                strId=jsonObj.getString("ID").toString();

            if(jsonObj.getString("PW").toString().equals("null"))
                strPw="-";
            else
                strPw=jsonObj.getString("PW").toString();

            if(jsonObj.getString("NAME").toString().equals("null"))
                strName="-";
            else
                strName=jsonObj.getString("NAME").toString();

            if(jsonObj.getString("PHONE").toString().equals("null"))
                strPhone="-";
            else
                strPhone=jsonObj.getString("PHONE").toString();



            userList.add(new UserInfo(strId, strPw, strName, strPhone));
        }
        return jsonArray.length();
    }

    static public int getContentInfoJson(String response, ArrayList<ContentInfo> contentList) throws JSONException{
        String strReg;
        String strNum;
        String strContent;
        String strId;

        JSONObject rootJSON = new JSONObject(response);
        JSONArray jsonArray = new JSONArray(rootJSON.getString("datas"));

        for(int i = 0; i<jsonArray.length();i++){
            JSONObject jsonObj = (JSONObject)jsonArray.get(i);

            if(jsonObj.getString("REG").toString().equals("null"))
                strReg="-";
            else
                strReg=jsonObj.getString("REG").toString();

            if(jsonObj.getString("NUM").toString().equals("null"))
                strNum="-";
            else
                strNum=jsonObj.getString("NUM").toString();

            if(jsonObj.getString("CONTENT").toString().equals("null"))
                strContent="-";
            else
                strContent=jsonObj.getString("CONTENT").toString();

            if(jsonObj.getString("ID").toString().equals("null"))
                strId="-";
            else
                strId=jsonObj.getString("ID").toString();
            contentList.add(new ContentInfo(strReg,strNum, strContent, strId));
        }
        return jsonArray.length();
    }

    static public int getBcontentInfoJson(String response, ArrayList<BcontentInfo> bcontentList) throws JSONException{
        String strReg;
        String strWritetime;
        String strContent;
        String strId;

        JSONObject rootJSON = new JSONObject(response);
        JSONArray jsonArray = new JSONArray(rootJSON.getString("datas"));

        for(int i = 0; i<jsonArray.length();i++){
            JSONObject jsonObj = (JSONObject)jsonArray.get(i);

            if(jsonObj.getString("REG").toString().equals("null"))
                strReg="-";
            else
                strReg=jsonObj.getString("REG").toString();

            if(jsonObj.getString("WRITETIME").toString().equals("null"))
                strWritetime="-";
            else
                strWritetime=jsonObj.getString("WRITETIME").toString();

            if(jsonObj.getString("CONTENT").toString().equals("null"))
                strContent="-";
            else
                strContent=jsonObj.getString("CONTENT").toString();

            if(jsonObj.getString("ID").toString().equals("null"))
                strId="-";
            else
                strId=jsonObj.getString("ID").toString();
            bcontentList.add(new BcontentInfo(strReg,strWritetime,strContent,strId));
        }
        return jsonArray.length();
    }



    static public int getResultJson(String response) throws JSONException{
        JSONArray jsonArray = new JSONArray(response);
        JSONObject jsonObject = new JSONObject(jsonArray.getString(0));
        return Integer.parseInt(jsonObject.getString("RESULT_OK"));
    }

}
