package com.example.alayesanmifemi.companyapp;

/**
 * Created by Alayesanmi Femi on 18/02/2019.
 */

public class User {
    private  int id;
    private  String name;
    private String companyRegNo;
    private String field;
    private String email;
    private String password;


    public User(int id ,String companyRegNo, String name, String email, String password, String field) {
        this.id = id;
        this.name = name;
        this.companyRegNo = companyRegNo;
        this.field = field;
        this.email = email;
        this.password = password;
    }

    public User(String companyRegNo, String name, String email, String password, String field) {
        this.name = name;
        this.companyRegNo = companyRegNo;
        this.field = field;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User(){

    }

    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

