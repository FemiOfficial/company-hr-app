package com.example.alayesanmifemi.companyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StaffListActivity extends AppCompatActivity implements View.OnClickListener {

    List<Staff> staff_list;
    TextView add_staff, staff_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String companyReg = intent.getExtras().getString("companyReg");

        staff_list = new ArrayList<>();
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        int number_cases = dbHandler.countStaffs(companyReg);
        if (number_cases > 0) {
            int i = 0;
            while (i < number_cases) {
                staff_list.add(dbHandler.displayCases(companyReg).get(i));
                i++;
            }
        } else {
            Toast.makeText(StaffListActivity.this, "No Staff Added Yet", Toast.LENGTH_LONG).show();

        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclyerview_id);
        StaffRecyclerAdapter recyclerAdapter = new StaffRecyclerAdapter(this, staff_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);


        add_staff = (TextView) findViewById(R.id.add_staff);
        staff_home = (TextView) findViewById(R.id.staff_home);

        add_staff.setOnClickListener(this);
        staff_home.setOnClickListener(this);

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
            case R.id.add_staff:
                Intent intent1 = getIntent();
                String companyReg = intent1.getExtras().getString("companyReg");
                Intent intent = new Intent();
                intent.setClass(this, AddStaffActivity.class);
                intent.putExtra("companyReg", companyReg);
                startActivity(intent);
                break;
            case R.id.staff_home:
                Intent intent2 = getIntent();
                companyReg = intent2.getExtras().getString("companyReg");
                Intent intent3 = new Intent();
                intent3.setClass(this, ProfileActivity.class);
                intent3.putExtra("companyReg", companyReg);
                startActivity(intent3);
                break;
        }
    }

}
