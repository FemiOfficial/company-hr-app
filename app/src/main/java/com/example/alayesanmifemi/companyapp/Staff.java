package com.example.alayesanmifemi.companyapp;

/**
 * Created by Alayesanmi Femi on 25/02/2019.
 */

public class Staff {
    private int id;
    private String name;
    private String position;
    private String company;

    public Staff(int id, String name, String position, String company) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.company = company;
    }

    public Staff(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public Staff(String name, String position, String company) {
        this.name = name;
        this.position = position;
        this.company = company;
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


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
