package com.example.conghau.appdemoappium;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class User extends AppCompatActivity {
    private TextView tvName,tvMail,tvPass;
    private MyDataBase databaseHelper;
    private Account user;
    private  String email=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().hide();
        Toast toast=null;
        Intent getintent = this.getIntent();
        try {
             email = getintent.getStringExtra("EMAIL");
            if (email!=null) {
                toast = Toast.makeText(this, email, Toast.LENGTH_LONG);
                toast.show();
            }
        }catch (Exception ex)
        {
            toast = Toast.makeText(this,"No catch EMAIL",Toast.LENGTH_LONG);
            toast.show();
        };
        initViews();
        initObjects();
        ShowAcc();
        /*tvName.setText(acc.getUserName());
        tvMail.setText(acc.getMail());
        tvPass.setText(acc.getPass());*/
    }

    private void initViews() {
        tvName = (TextView)findViewById(R.id.tvname);
        tvMail = (TextView)findViewById(R.id.tvEmail);
        tvPass =(TextView)findViewById(R.id.tvPass);
    }

    private void initObjects() {
        databaseHelper = new MyDataBase(this);
        user = new Account();
    }
    private  void ShowAcc()
    {
        user = databaseHelper.getUser(email);
        tvName.setText(user.getUserName());
        tvMail.setText(user.getMail());
        tvPass.setText(user.getPass());
    }

}
