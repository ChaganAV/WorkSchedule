package com.example.WorkSchedule.models;

public class Person {
    private int id;
    private String lastname;
    private String firstname;
    private String secondname;
    private String fio;
    private String fullname;
    private String tabnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getFio() {
        return fio;
    }

    public void setFio() {
        this.fio = String.format("{0} {1}.{2}.",this.getLastname().trim(),
                this.getFirstname().trim().substring(1,1).toUpperCase(),
                this.getSecondname().trim().substring(1,1).toUpperCase());
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname() {
        this.fullname = String.format("{0} {1} {2}",this.getLastname().trim(),
                this.getFirstname().trim(),
                this.getSecondname().trim());
    }

    public String getTabnum() {
        return tabnum;
    }

    public void setTabnum(String tabnum) {
        this.tabnum = tabnum;
    }
}
