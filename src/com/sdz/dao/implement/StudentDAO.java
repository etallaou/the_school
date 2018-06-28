package com.sdz.dao.implement;

import com.sdz.bean.Student;
import com.sdz.dao.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO extends DAO<Student> {
    public StudentDAO(Connection connection) {
        super(connection);
    }


    public boolean create(Student obj) {
        return false;
    }


    public boolean update(Student obj) {
        return false;
    }


    public boolean delete(Student obj) {
        return false;
    }


    public Student find(int id) {
        Student student = new Student();
        try {
            ResultSet resultSet = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM eleve WHERE elv_id = " + id);

            if(resultSet.first())
                student = new Student(
                        id,
                        resultSet.getString("elv_nom"),
                        resultSet.getString("elv_prenom")
                );

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return student;
    }



}
