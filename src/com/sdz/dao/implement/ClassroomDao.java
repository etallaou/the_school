package com.sdz.dao.implement;

import com.sdz.bean.Classroom;
import com.sdz.bean.Teacher;
import com.sdz.dao.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassroomDao extends DAO<Classroom> {
    public ClassroomDao(Connection connection) {
        super(connection);
    }
    public boolean create(Classroom obj) {
        return false;
    }


    public boolean update(Classroom obj) {
        return false;
    }


    public boolean delete(Classroom obj) {
        return false;
    }

    public Classroom find(int id) {
        Classroom classroom = new Classroom();
        try {
            ResultSet resultSet = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery(
                    "SELECT * FROM classe WHERE cls_id =  "+id
            );

            if(resultSet.first())
                classroom = new Classroom(
                        id,
                        resultSet.getString("cls_nom")
                );
                resultSet = this.connection.createStatement().executeQuery(
                        "SELECT prof_id, prof_nom, prof_prenom FROM professeur " +
                                "INNER JOIN j_mat_prof ON prof_id = j_mat_prof.jmp_prof_k "+
                                "INNER JOIN j_cls_jmp ON jmp_id = jcm_jmp_k AND jcm_cls_k = " + id
                );

            TeacherDAO teacherDAO = new TeacherDAO(this.connection);

                while (resultSet.next())
                    classroom.addTeacher(teacherDAO.find(resultSet.getInt("prof_id")));

            StudentDAO studentDAO = new StudentDAO(this.connection);
            resultSet = this.connection.createStatement().executeQuery(
                    "SELECT elv_id, elv_nom, elv_prenom FROM eleve " +
                            "INNER JOIN classe ON elv_cls_k = cls_id AND cls_id = " + id
            );

            while (resultSet.next())
                classroom.addStudent(studentDAO.find(resultSet.getInt("elv_id")));



        }catch(SQLException e) {
            e.printStackTrace();
        }
        return classroom;
    }

}
