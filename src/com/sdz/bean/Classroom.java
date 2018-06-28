package com.sdz.bean;

import java.util.HashSet;
import java.util.Set;

public class Classroom {
    private int id = 0;
    private String name = "";
    private Set<Teacher> listTeacher = new HashSet<>();
    private Set<Student> listStudent = new HashSet<>();

    public Classroom(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Classroom(){}

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

    public Set<Teacher> getListTeacher() {
        return listTeacher;
    }

    public void setListTeacher(Set<Teacher> listTeacher) {
        this.listTeacher = listTeacher;
    }

    public void addTeacher(Teacher teacher){
        this.listTeacher.add(teacher);
    }

    public void removeTeacher(Teacher teacher){
        this.listTeacher.remove(teacher);
    }



    public Set<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(Set<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public void addStudent(Student student){
        this.listStudent.add(student);
    }

    public void removeStudent(Student student){
        this.listStudent.remove(student);
    }

}
