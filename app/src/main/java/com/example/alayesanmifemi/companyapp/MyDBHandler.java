package com.example.alayesanmifemi.companyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Alayesanmi Femi on 18/02/2019.
 */

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "company.db";
    private static final String TABLE_USERS = "users";
    private static final String TABLE_STAFFS = "staffs";
    private static final String TABLE_PROJECTS = "projects";
    private static final String COLUMN_NAME_ID = "id";
    private static final String COLUMN_NAME_USERS = "name";
    private static final String COLUMN_FIELD_USERS = "field";
    private static final String COLUMN_REGNO_USERS = "companyregNo";
    private static final String COLUMN_EMAIL_USERS = "email";
    private static final String COLUMN_PASSWORD_USERS = "password";

    private static final String COLUMN_STAFF_ID = "id";
    private static final String COLUMN_STAFF_NAME = "staff_name";
    private static final String COLUMN_STAFF_POST = "staff_post";
    private static final String COLUMN_STAFF_COMPANY = "companyregNo";

    private static final String COLUMN_PROJECT_ID = "id";
    private static final String COLUMN_PROJECT_NAME = "project_name";
    private static final String COLUMN_PROJECT_LOCATION = "location";
    private static final String COLUMN_PROJECT_START = "startDate";
    private static final String COLUMN_PROJECT_FINISH ="finishDate";
    private static final String COLUMN_PROJECT_STATUS ="status";
    private static final String COLUMN_PROJECT_COMPANY = "companyregNo";



    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME , factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT );",
                TABLE_USERS, COLUMN_NAME_ID ,COLUMN_REGNO_USERS, COLUMN_NAME_USERS, COLUMN_FIELD_USERS, COLUMN_EMAIL_USERS, COLUMN_PASSWORD_USERS);
        db.execSQL(query);

        String query2 = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT );",
                TABLE_STAFFS, COLUMN_STAFF_ID ,COLUMN_STAFF_NAME, COLUMN_STAFF_COMPANY, COLUMN_STAFF_POST);
        db.execSQL(query2);

        String query3 = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT, " +
                        "%s TEXT, " +
                        "%s TEXT, " +
                        "%s TEXT, " +
                        "%s TEXT, " +
                        "%s TEXT  );",
                TABLE_PROJECTS, COLUMN_PROJECT_ID ,
                COLUMN_PROJECT_NAME,
                COLUMN_PROJECT_LOCATION,
                COLUMN_PROJECT_START,
                COLUMN_PROJECT_COMPANY,
                COLUMN_PROJECT_FINISH,
                COLUMN_PROJECT_STATUS);
        db.execSQL(query3);

    }

    public void createUser(User user){
        ContentValues values = new ContentValues();
        values.put( COLUMN_NAME_USERS, user.getName());
        values.put( COLUMN_EMAIL_USERS, user.getEmail());
        values.put( COLUMN_PASSWORD_USERS, user.getPassword());
        values.put( COLUMN_REGNO_USERS, user.getCompanyRegNo());
        values.put( COLUMN_FIELD_USERS, user.getField());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public void createStaff(Staff staff){
        ContentValues values = new ContentValues();
        values.put( COLUMN_STAFF_NAME, staff.getName());
        values.put( COLUMN_STAFF_COMPANY, staff.getCompany());
        values.put( COLUMN_STAFF_POST, staff.getPosition());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_STAFFS, null, values);
        db.close();
    }

    public void createProject(Projects project){
        ContentValues values = new ContentValues();
        values.put( COLUMN_PROJECT_NAME, project.getName());
        values.put( COLUMN_PROJECT_STATUS, project.getStatus());
        values.put( COLUMN_PROJECT_LOCATION, project.getLocation());
        values.put( COLUMN_STAFF_COMPANY, project.getCompany());
        values.put( COLUMN_PROJECT_START, project.getStart());
        values.put( COLUMN_PROJECT_FINISH, project.getFinish());



        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PROJECTS, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STAFFS);
        onCreate(db);
    }

    public boolean checkReg(String regNo){
        String[] columns = {
                COLUMN_REGNO_USERS
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_EMAIL_USERS + " = ?";
        String[] selectionsArgs = { regNo };

        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionsArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    public boolean checkUser(String regNo, String password){
        String[] columns = {
                COLUMN_REGNO_USERS

        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_REGNO_USERS + " = ?" + " AND " + COLUMN_PASSWORD_USERS + " = ?";
        String[] selectionsArgs = { regNo , password };

        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionsArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }


    public String[] companyProfile(String regNo) {
        String[] columns = {
                COLUMN_NAME_USERS, COLUMN_REGNO_USERS, COLUMN_FIELD_USERS,
                COLUMN_EMAIL_USERS
        };
        String[] selectionsArgs = { regNo };
        SQLiteDatabase db = getWritableDatabase();
        String query = COLUMN_EMAIL_USERS + " = ?" ;
        Cursor c = db.query(TABLE_USERS, columns, query, selectionsArgs, null,null,null);
        c.moveToFirst();
        String[] dbString = new String[4];
        if(c.getCount() != 0) {
            int column_regNo = c.getColumnIndex("companyregNo");
            int column_name = c.getColumnIndex("name");
            int column_field = c.getColumnIndex("field");
            int column_email = c.getColumnIndex("email");
            dbString[0] = c.getString(column_name);
            dbString[1] = c.getString(column_regNo);
            dbString[2] = c.getString(column_email);
            dbString[3] = c.getString(column_field);
        }
        c.close();
        db.close();
        return dbString;
    }

    public int countStaffs(String id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM  " + TABLE_STAFFS + " WHERE companyregNo = '" + id + "'"   ;
        Cursor c = db.rawQuery(query, null);
        return c.getCount();
    }

    public ArrayList<Staff> displayCases(String id){
        ArrayList<Staff> staff_list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_STAFFS + " WHERE companyregNo = '" + id + "'"  ;
        Cursor c = db.rawQuery(query, null);
        if(c.moveToFirst()){
            do{
                staff_list.add(new Staff(
                        c.getString(1),
                        c.getString(3)

                ));
            }while(c.moveToNext());
        }
        return staff_list;
    }

    public int countProjects(String id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM  " + TABLE_PROJECTS + " WHERE companyregNo = '" + id + "'"   ;
        Cursor c = db.rawQuery(query, null);
        return c.getCount();
    }

    public ArrayList<Projects> displayProjects(String id){
        ArrayList<Projects> project_list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PROJECTS + " WHERE companyregNo = '" + id + "'"  ;
        Cursor c = db.rawQuery(query, null);
        if(c.moveToFirst()){
            do{
                project_list.add(new Projects(
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(5),
                        c.getString(6)
                ));
            }while(c.moveToNext());
        }
        return project_list;
    }

}
