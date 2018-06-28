package com.sdz.bean;

public class Student {
    private int id = 0;
    private String fName = "";
    private String lName = "";

    public Student(int id, String lName, String fName){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public Student(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setlName(String lName){
        this.lName = lName;
    }

    public String getlName() {
        return lName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfName() {
        return fName;
    }
}
