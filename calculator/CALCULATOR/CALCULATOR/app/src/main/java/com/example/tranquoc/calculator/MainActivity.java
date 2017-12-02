 package com.example.tranquoc.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
    String toantu,toanhang="";
    Double soa, sob,Result=0d;
    private TextView txt1,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       int mangid []={R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.btnbang,R.id.btntru,R.id.btncong,R.id.btnnhan,R.id.btnchia,R.id.btndel,R.id.btncham};
         txt1=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);
        for(int id:mangid){
            View view=(View)findViewById(id);
            view.setOnClickListener(this);
        }
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btncong:
                soa=Double.parseDouble(txt2.getText().toString());
                toantu="+";
                Result=0d;
                txt1.setText(txt2.getText().toString());
                txt2.setText("+");
                toanhang="";
                break;
            case R.id.btntru:
                soa=Double.parseDouble(txt2.getText().toString());
                toantu="-";
                Result=0d;
                txt1.setText(txt2.getText().toString());
                txt2.setText("-");
                toanhang="";
                break;
            case R.id.btnnhan:
                soa=Double.parseDouble(txt2.getText().toString());
                toantu="x";
                Result=0d;
                txt1.setText(txt2.getText().toString());
                txt2.setText("x");
                toanhang="";
                break;
            case R.id.btnchia:
                soa=Double.parseDouble(txt2.getText().toString());
                toantu="/";
                Result=0d;
                txt1.setText(txt2.getText().toString());
                txt2.setText("/");
                toanhang="";
                break;
            case R.id.btndel:
                txt1.setText("");
                txt2.setText("");
                toanhang="";
                Result=0d;
                break;
            case R.id.btncham:
                if(!txt2.getText().toString().equals("")){
                    txt2.setText(toanhang+=".");
                }
                break;
            case R.id.btnbang:
                sob=Double.parseDouble(txt2.getText().toString());
                if(toantu=="+"){
                    try {
                    Result=soa+sob;
                    }
                    catch (Exception io)
                    {
                        txt2.setText("Exception occurred");
                    }
                }
                if(toantu=="-"){
                    try {
                        Result = soa - sob;
                    }
                     catch (Exception io)
                        {
                            txt2.setText("Exception occurred");
                        }
                }
                if(toantu=="x"){
                    try {
                    Result=soa*sob;
                    }
                    catch (Exception io)
                    {
                        txt2.setText("Exception occurred");
                    }
                }
                if(toantu=="/"){
                    try {
                        Result = soa / sob;
                    }
                    catch (Exception io)
                    {
                        txt2.setText("Exception occurred");
                    }
                }

                txt2.setText(String.valueOf(Result));
                break;
            default:
                char [] so=txt2.getText().toString().toCharArray();
                if(so.length>18){
                    return;
                }
                if(Result!=0){
                    toanhang="";
                toanhang+=((Button) v).getText().toString();
                    txt2.setText(txt2.getText().toString()+toanhang);
                }
                else {
                    toanhang +=((Button) v).getText().toString();
                    txt2.setText(toanhang);
                }
                break;
        }
    }
}