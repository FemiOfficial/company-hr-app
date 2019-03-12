package com.example.alayesanmifemi.companyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{
    MyDBHandler dbHandler;
    CardView staff_card, projects_card;
    TextView company_no, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        company_no = (TextView) findViewById(R.id.company_no);
        logout = (TextView) findViewById(R.id.logout);

        staff_card = (CardView) findViewById(R.id.staffs);
        projects_card = (CardView) findViewById(R.id.projects);
        staff_card.setOnClickListener(this);
        projects_card.setOnClickListener(this);
        logout.setOnClickListener(this);

        String[] profileDetails = getUser();

        company_no.setText(getRegNo());

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
        String companyReg = getRegNo();
        switch (view.getId()) {
            case R.id.staffs:
                Intent intent = new Intent();
                intent.setClass(this, StaffListActivity.class);

                intent.putExtra("companyReg", companyReg);
                startActivity(intent);
                break;
            case R.id.projects:
                Intent intent1 = new Intent(this, ProjectsActivity.class);
                intent1.putExtra("companyReg", companyReg);
                startActivity(intent1);
                break;
            case R.id.logout:
                Intent intent2 = new Intent(this, LoginActivity.class);
                startActivity(intent2);
                break;
        }
    }

    public String getRegNo(){
        Intent intent = getIntent();
        String companyReg = intent.getExtras().getString("companyReg");
        return companyReg;
    }

    public String[] getUser(){
        dbHandler = new MyDBHandler(this, null, null, 1);
        String[] profileDetails =  dbHandler.companyProfile(getRegNo());
        return profileDetails;
    }





}
