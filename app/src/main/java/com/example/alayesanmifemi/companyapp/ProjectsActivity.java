package com.example.alayesanmifemi.companyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProjectsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView add_project, project_home;
    List<Projects> projects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        add_project = (TextView) findViewById(R.id.add_project);
        project_home = (TextView) findViewById(R.id.project_home);
        add_project.setOnClickListener(this);
        project_home.setOnClickListener(this);

        Intent intent = getIntent();
        String companyReg = intent.getExtras().getString("companyReg");

        projects = new ArrayList<>();
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        int number_cases = dbHandler.countProjects(companyReg);
        if (number_cases > 0) {
            int i = 0;
            while (i < number_cases) {
                projects.add(dbHandler.displayProjects(companyReg).get(i));
                i++;
            }
        } else {
            Toast.makeText(ProjectsActivity.this, "No Project Added Yet", Toast.LENGTH_LONG).show();

        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclyerview_project_id);
        ProjectRecyclerAdapter recyclerAdapter = new ProjectRecyclerAdapter(this, projects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);


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
            case R.id.add_project:
                Intent intent1 = getIntent();
                String companyReg = intent1.getExtras().getString("companyReg");
                Intent intent = new Intent();
                intent.setClass(this, AddProjectActivity.class);
                intent.putExtra("companyReg", companyReg);
                startActivity(intent);
                break;
            case R.id.project_home:
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
