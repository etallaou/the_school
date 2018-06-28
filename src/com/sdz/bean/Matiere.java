package com.sdz.bean;

public class Matiere {
    private int id = 0;
    private String name = "";

    public Matiere(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Matiere(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
