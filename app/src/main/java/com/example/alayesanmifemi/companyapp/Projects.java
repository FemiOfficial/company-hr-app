package com.example.alayesanmifemi.companyapp;

/**
 * Created by Alayesanmi Femi on 26/02/2019.
 */

public class Projects {
    private int id;
    private String name;
    private String location;
    private String status;
    private String finish;
    private String start;
    private String company;


    public Projects(int id, String company, String name, String location, String status, String finish, String start) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.status = status;
        this.finish = finish;
        this.start = start;
        this.company = company;

    }

    public Projects(String company, String name, String location, String status, String finish, String start) {
        this.name = name;
        this.location = location;
        this.status = status;
        this.finish = finish;
        this.start = start;
        this.company = company;
    }

    public Projects(String name, String location, String status, String finish, String start) {
        this.name = name;
        this.location = location;
        this.status = status;
        this.finish = finish;
        this.start = start;
    }


    public Projects() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
