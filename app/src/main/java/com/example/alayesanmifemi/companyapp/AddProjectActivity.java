package com.example.alayesanmifemi.companyapp;

import android.app.ListActivity;
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

public class AddProjectActivity extends AppCompatActivity implements View.OnClickListener  {

    EditText project_name, project_location, project_status, project_start, project_finish;
    Button add;

    MyDBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHandler = new MyDBHandler(this, null,null, 1);

        project_name = (EditText) findViewById(R.id.project_add_name);
        project_finish = (EditText) findViewById(R.id.project_add_finish);
        project_location = (EditText) findViewById(R.id.project_add_location);
        project_status = (EditText) findViewById(R.id.project_add_status);
        project_start = (EditText) findViewById(R.id.project_add_start);


        add = (Button) findViewById(R.id.add_project_btn);


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
            case R.id.add_project_btn:
                addProject();
                break;
        }

    }

    public void addProject(){
        Intent intent = getIntent();
        String companyReg = intent.getExtras().getString("companyReg");
        Projects projects = new Projects( companyReg, project_name.getText().toString(),
                project_location.getText().toString(),
                project_status.getText().toString(),
                project_finish.getText().toString(),
                project_start.getText().toString());
        dbHandler.createProject(projects);
        Toast.makeText(AddProjectActivity.this, "Project added Successfully" , Toast.LENGTH_LONG).show();
        Intent intent1 = new Intent();
        intent1.setClass(this, ProjectsActivity.class);
        intent1.putExtra("companyReg", companyReg);
        startActivity(intent1);
    }
}
