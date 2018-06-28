package com.sdz.dao.implement;

import com.sdz.bean.Matiere;
import com.sdz.bean.Student;
import com.sdz.dao.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatiereDAO extends DAO<Matiere> {

    public MatiereDAO(Connection connection) {
        super(connection);
    }
    public boolean create(Matiere obj) {
        return false;
    }


    public boolean update(Matiere obj) {
        return false;
    }


    public boolean delete(Matiere obj) {
        return false;
    }

    public Matiere find(int id) {
        Matiere matiere = new Matiere();
        try {
            ResultSet resultSet = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM matiere WHERE mat_id = " + id);

            if(resultSet.first())
                matiere = new Matiere(
                        id,
                        resultSet.getString("mat_nom")
                );

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return matiere;
    }
}
