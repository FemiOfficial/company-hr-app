package com.example.alayesanmifemi.companyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity  implements View.OnClickListener {

    EditText name;
    EditText field;
    EditText companyReg;
    EditText password;
    EditText co_password;
    EditText email;
    Button btn_signup;

    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = (EditText) findViewById(R.id.text_name);
        field = (EditText) findViewById(R.id.text_field);
        companyReg = (EditText) findViewById(R.id.text_regNo);
        password = (EditText) findViewById(R.id.text_password);
        co_password = (EditText) findViewById(R.id.text_con_password);
        email = (EditText) findViewById(R.id.text_email);
        btn_signup = (Button) findViewById(R.id.btn_register);
        dbHandler = new MyDBHandler(this, null,null, 1);

        btn_signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_register:
                signUp();
                break;
        }
    }

    public void signUp(){
        User user = new User( companyReg.getText().toString(), name.getText().toString(), email.getText().toString(),
                password.getText().toString(), field.getText().toString());
        if(password.getText().toString().equals(co_password.getText().toString())){
            dbHandler.createUser(user);
            Toast.makeText(RegisterActivity.this, "User Registered Successfully" , Toast.LENGTH_LONG).show();
            Intent intent = new Intent();
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
        }

        else {
            Toast.makeText(RegisterActivity.this, "Passwords must match" , Toast.LENGTH_LONG).show();
        }

    }

}
