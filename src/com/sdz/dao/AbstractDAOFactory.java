package com.sdz.dao;

public abstract class AbstractDAOFactory {
    public static final int DAO_FACTORY = 0;
    public static final int XML_DAO_FACTORY = 1;

    public abstract DAO getClassroomDAO();
    public abstract DAO getTeacherDAO();
    public abstract DAO getStudentDAO();
    public abstract DAO getMatiereDAO();

    public static AbstractDAOFactory getFactory(int type){
        switch (type){
            case DAO_FACTORY:
                return new DAOFactory();
            case XML_DAO_FACTORY:
                return new XMLDAOFactory();
            default:
                return null;

        }
    }

}
