package com.sdz.bean;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
    private int id = 0;
    private String fName = "";
    private String lName = "";
    private Set<Matiere> listMatiere = new HashSet<Matiere>();

    public Teacher(int id, String lName, String fName){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public Teacher(){}

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

    public Set<Matiere> getListMatiere() {
        return listMatiere;
    }

    public void setListMatiere(Set<Matiere> listMatiere){
        this.listMatiere = listMatiere;
    }

    public void addMatiere(Matiere matiere){
        this.listMatiere.add(matiere);
    }

    public void removeMatiere(Matiere matiere){
        this.listMatiere.remove(matiere);
    }
}
