package com.sdz.dao;

import com.sdz.SdzConnection;
import com.sdz.dao.implement.ClassroomDao;
import com.sdz.dao.implement.MatiereDAO;
import com.sdz.dao.implement.StudentDAO;
import com.sdz.dao.implement.TeacherDAO;

import java.sql.Connection;

public class DAOFactory extends AbstractDAOFactory{

    protected static final Connection connection = SdzConnection.getInstance();

    public  DAO getClassroomDAO(){
        return new ClassroomDao(connection);
    }

    public  DAO getTeacherDAO(){
        return new TeacherDAO(connection);
    }

    public  DAO getStudentDAO(){
        return new StudentDAO(connection);
    }

    public  DAO getMatiereDAO(){
        return new MatiereDAO(connection);
    }
}
