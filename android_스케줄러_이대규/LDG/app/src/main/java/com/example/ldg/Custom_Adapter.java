package com.example.ldg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Custom_Adapter  extends BaseAdapter {
    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<ContentInfo> mContentInfoObjArr;
    int mListLayout;

    public Custom_Adapter(Activity a, int listLayout, ArrayList<ContentInfo> contentInfoObjArrayListT){
        mAct = a;
        mListLayout = listLayout;
        mContentInfoObjArr = contentInfoObjArrayListT;
        mInflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<ContentInfo> arrayList){
        mContentInfoObjArr = arrayList;
    }

    @Override
    public int getCount() {
        return mContentInfoObjArr.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
            view= mInflater.inflate(mListLayout,viewGroup,false);

        final TextView tvREG = (TextView) view.findViewById(R.id.tv_reg);
        tvREG.setText(mContentInfoObjArr.get(i).reg);

        final TextView tvNUM = (TextView) view.findViewById(R.id.tv_num);
        tvNUM.setText(mContentInfoObjArr.get(i).num);

        final TextView tvCONTENT = (TextView) view.findViewById(R.id.tv_content);
        tvCONTENT.setText(mContentInfoObjArr.get(i).content);

        final TextView tvID = (TextView) view.findViewById(R.id.tv_id);
        tvID.setText(mContentInfoObjArr.get(i).id);//아이디값 세팅

        Button updateButton  = (Button) view.findViewById(R.id.btnUpdate);//수정버튼 바인딩
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = mAct.getLayoutInflater().inflate(R.layout.dialog_update,null);
                EditText edtReg = (EditText)v.findViewById(R.id.edtReg);
                EditText edtTime = (EditText)v.findViewById(R.id.edtTime);
                EditText edtContent = (EditText)v.findViewById(R.id.edtContent);
                EditText edtId = (EditText)v.findViewById(R.id.edtId);

                edtReg.setText(tvREG.getText());
                edtReg.setFocusable(false);

                edtId.setText(tvID.getText());
                edtId.setFocusable(false);



                new AlertDialog.Builder(mAct)
                        .setTitle("수정하기")
                        .setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String reg = ((EditText)v.findViewById(R.id.edtReg)).getText().toString();
                                String num = ((EditText)v.findViewById(R.id.edtTime)).getText().toString();
                                String content = ((EditText)v.findViewById(R.id.edtContent)).getText().toString();
                                String id = ((EditText)v.findViewById(R.id.edtId)).getText().toString();

                                new NetworkUpdate(Custom_Adapter.this).execute(reg,num,content,id);
                                Toast.makeText(mAct,"수정완료", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).setCancelable(false).show();
            }
        });

        Button deleteButton = (Button) view.findViewById(R.id.btn_delete);//삭제버튼 바인딩
        deleteButton.setOnClickListener(new View.OnClickListener() {//삭제버튼 클릭
            @Override
            public void onClick(View v) {
                String conNum = tvREG.getText().toString();
                AlertDialog.Builder ad = new AlertDialog.Builder(mAct);
                ad.setTitle("삭제하기");
                ad.setMessage(conNum+ "의 내용을 정말 삭제하시겠습니까?");

                ad.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new NetworkDelete(Custom_Adapter.this).execute(tvREG.getText().toString());
                    }
                });

                ad.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mAct,"취소하였습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.show();
                
            }
        });

        return view;
    }
}
