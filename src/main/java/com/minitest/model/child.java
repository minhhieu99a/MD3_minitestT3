package com.minitest.model;

public class child {
    private int idS;
    private String fullname;
    private int age;
    private String gender;
    private int idF;

    public child() {
    }

    public child(int idS, String fullname, int age, String gender, int idF) {
        this.idS = idS;
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
        this.idF = idF;
    }

    public child(String fullname, int age, String gender, int idF) {
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
        this.idF = idF;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }
}
