package com.minitest.model;

public class Father {
    private int id;
    private String fullname;
    private int age ;

    public Father() {
    }

    public Father(int id, String typeofhouse) {
        this.id = id;
        this.fullname = typeofhouse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
