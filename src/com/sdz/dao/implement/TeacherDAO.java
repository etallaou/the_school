package com.sdz.dao.implement;

import com.sdz.bean.Matiere;
import com.sdz.bean.Student;
import com.sdz.bean.Teacher;
import com.sdz.dao.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAO extends DAO<Teacher> {
    public TeacherDAO(Connection connection) {
        super(connection);
    }
    public boolean create(Teacher obj) {
        return false;
    }


    public boolean update(Teacher obj) {
        return false;
    }


    public boolean delete(Teacher obj) {
        return false;
    }

    public Teacher find(int id) {
        Teacher teacher = new Teacher();
        try {
            ResultSet resultSet = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery(
                    "SELECT * FROM professeur "+
                            "LEFT JOIN j_mat_prof ON jmp_prof_k = prof_id " +
                            "AND prof_id = "+ id +
                            " INNER JOIN matiere ON jmp_mat_k = mat_id"
            );

            if(resultSet.first())
                teacher = new Teacher(
                        id,
                        resultSet.getString("prof_nom"),
                        resultSet.getString("prof_prenom")
                );
                resultSet.beforeFirst();
                MatiereDAO matiereDAO = new MatiereDAO(this.connection);

                while (resultSet.next())
                    teacher.addMatiere(matiereDAO.find(resultSet.getInt("mat_id")));


        }catch(SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}
