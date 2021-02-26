package com.example.ldg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class Bcustom_Adapter extends BaseAdapter {
    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<BcontentInfo> mBcontentInfoObjArr;
    int mListLayout;
    String id;

    private BoardPage boardAct;

    public Bcustom_Adapter(Activity a, int listLayout, ArrayList<BcontentInfo> bcontentInfoObjArrayListT, String id){
        mAct = a;
        mListLayout = listLayout;
        mBcontentInfoObjArr = bcontentInfoObjArrayListT;
        mInflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.id = id;
    }

    public void setDatas(ArrayList<BcontentInfo> arrayList){
        mBcontentInfoObjArr = arrayList;
    }

    @Override
    public int getCount() {
        return mBcontentInfoObjArr.size();
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

        final TextView tvREG = (TextView) view.findViewById(R.id.tv_reg1);
        tvREG.setText(mBcontentInfoObjArr.get(i).reg);

        final TextView tvWRITETIME = (TextView) view.findViewById(R.id.tv_write_time1);
        tvWRITETIME.setText(mBcontentInfoObjArr.get(i).writetime);

        final TextView tvCONTENT = (TextView) view.findViewById(R.id.tv_content1);
        tvCONTENT.setText(mBcontentInfoObjArr.get(i).content);

        final TextView tvID = (TextView) view.findViewById(R.id.tv_id1);
        tvID.setText(mBcontentInfoObjArr.get(i).id);//아이디값 세팅

        Button updateButton  = (Button) view.findViewById(R.id.btnUpdate1);//수정버튼 바인딩

        if(id.equals(mBcontentInfoObjArr.get(i).id)){
            updateButton.setVisibility(View.VISIBLE);
        }else
        {
            updateButton.setVisibility(View.INVISIBLE);
        }

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = mAct.getLayoutInflater().inflate(R.layout.dialog_bupdate,null);
                EditText edtReg = (EditText)v.findViewById(R.id.edtReg1);
//                EditText edtTime = (EditText)v.findViewById(R.id.edtTime);
                EditText edtContent = (EditText)v.findViewById(R.id.edtContent1);
                EditText edtId = (EditText)v.findViewById(R.id.edtId1);

                edtId.setText(tvID.getText());
                edtId.setFocusable(false);

                edtReg.setText(tvREG.getText());
                edtReg.setFocusable(false);

                    new AlertDialog.Builder(mAct)
                            .setTitle("수정하기")
                            .setView(v)
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                String reg = ((EditText)v.findViewById(R.id.edtReg1)).getText().toString();
//                                String num = ((EditText)v.findViewById(R.id.edtTime)).getText().toString(); 없어도 될듯
                                    String content = ((EditText)v.findViewById(R.id.edtContent1)).getText().toString();
                                    String id = ((EditText)v.findViewById(R.id.edtId1)).getText().toString();

                                    new BNetworkUpdate(Bcustom_Adapter.this).execute(reg, content,id);
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

        Button deleteButton = (Button) view.findViewById(R.id.btn_delete1);//삭제버튼 바인딩

        if(id.equals(mBcontentInfoObjArr.get(i).id)){
            deleteButton.setVisibility(View.VISIBLE);
        }else
        {
            deleteButton.setVisibility(View.INVISIBLE);
        }


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
                        new BNetworkDelete(Bcustom_Adapter.this).execute(tvREG.getText().toString());
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
