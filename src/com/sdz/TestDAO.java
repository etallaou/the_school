package com.sdz;

import com.sdz.bean.Classroom;
import com.sdz.bean.Matiere;
import com.sdz.bean.Student;
import com.sdz.bean.Teacher;
import com.sdz.dao.AbstractDAOFactory;
import com.sdz.dao.DAO;
import com.sdz.dao.DAOFactory;
import com.sdz.dao.implement.ClassroomDao;
import com.sdz.dao.implement.StudentDAO;
import com.sdz.dao.implement.TeacherDAO;

public class TestDAO {
    public static void main(String[] args) {
        System.out.println("");

        AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);

        DAO<Student> studentDAO = abstractDAOFactory.getStudentDAO();
        for (int i = 1; i < 5; i++){
            Student student = studentDAO.find(i);
            System.out.println("Student N* " + student.getId() + " - " + student.getfName() + " " + student.getlName());

        }

        System.out.println("\n*******************************************\n");

        DAO<Teacher> teacherDAO = abstractDAOFactory.getTeacherDAO();

        Teacher teacher = teacherDAO.find(3);
        System.out.println(teacher.getfName() + " " + teacher.getlName() + " teaches : ");
        for (Matiere matiere: teacher.getListMatiere())
            System.out.println("\t *" + matiere.getName());




        System.out.println("\n*******************************************\n");
        DAO<Classroom> classroomDAO = abstractDAOFactory.getClassroomDAO();
        Classroom classroom = classroomDAO.find(10);

        System.out.println(" Class of " + classroom.getName());
        System.out.println("\nstudents list of " + classroom.getListStudent().size() );

        for (Student student: classroom.getListStudent())
            System.out.println(" - " + student.getfName() + " " + student.getlName());

        System.out.println("\nteachers list " + classroom.getListTeacher().size());
        for (Teacher fTeacher: classroom.getListTeacher())
            System.out.println(" - " + fTeacher.getfName() + " " + fTeacher.getlName());

    }
}
