package com.example.alayesanmifemi.companyapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alayesanmifemi.companyapp.LoginActivity;
import com.example.alayesanmifemi.companyapp.MyDBHandler;
import com.example.alayesanmifemi.companyapp.R;
import com.example.alayesanmifemi.companyapp.RegisterActivity;
import com.example.alayesanmifemi.companyapp.Staff;
import com.example.alayesanmifemi.companyapp.StaffListActivity;

public class AddStaffActivity extends AppCompatActivity implements View.OnClickListener {

    EditText staff_name, staff_post;
    Button add;

    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHandler = new MyDBHandler(this, null,null, 1);

        staff_name = (EditText) findViewById(R.id.staff_add_name);
        staff_post = (EditText) findViewById(R.id.staff_add_post);
        add = (Button) findViewById(R.id.add_staff_btn);


        add.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_staff_btn:
                addStaff();

                break;

        }
    }

    public void addStaff(){
        Intent intent = getIntent();
        String companyReg = intent.getExtras().getString("companyReg");
        Staff staff = new Staff( staff_name.getText().toString(), staff_post.getText().toString(),companyReg );
            dbHandler.createStaff(staff);
            Toast.makeText(AddStaffActivity.this, "Staff added Successfully" , Toast.LENGTH_LONG).show();
        Intent intent1 = new Intent();
        intent1.setClass(this, StaffListActivity.class);
        intent1.putExtra("companyReg", companyReg);
        startActivity(intent1);
    }

}
