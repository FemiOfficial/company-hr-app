package com.example.alayesanmifemi.companyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener {

    EditText companyReg;
    EditText password;
    Button btn_signin;
    MyDBHandler dbHandler;
    TextView text_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        companyReg = (EditText) findViewById(R.id.text_regNo_login);
        password = (EditText) findViewById(R.id.text_password);
        text_register = (TextView) findViewById(R.id.text_change);
        btn_signin = (Button) findViewById(R.id.btn_login);

        dbHandler = new MyDBHandler(this, null,null, 1);

        text_register.setOnClickListener(this);
        btn_signin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_login:
                if (verifyFromSQLite()){

                    Intent IntentAccounts =  new Intent(this, ProfileActivity.class);
                    IntentAccounts.putExtra("companyReg", companyReg.getText().toString().trim());
                    companyReg.setText(null);
                    password.setText(null);
                    startActivity(IntentAccounts);

                }else{

                    Snackbar.make(view,
                            "Invalid Company Registration Number or Password, please try again",
                            Snackbar.LENGTH_LONG).show();

                    companyReg.setText(null);
                    password.setText(null);

                }
                break;

            case R.id.text_change:
                Intent intent2 = new Intent();
                intent2.setClass(this, RegisterActivity.class);
                startActivity(intent2);
                break;


        }
    }

    private boolean verifyFromSQLite(){
        if(dbHandler.checkUser(
                companyReg.getText().toString(),
                password.getText().toString()
        )){
            return true;
        }else{
            return false;
        }
    }
}
