package com.sdz.bean.classes;


import com.sdz.SdzConnection;
import com.sdz.bean.Classroom;
import com.sdz.bean.Matiere;
import com.sdz.bean.Student;
import com.sdz.bean.Teacher;
import com.sdz.dao.DAO;
import com.sdz.dao.implement.ClassroomDao;
import com.sdz.dao.implement.StudentDAO;
import com.sdz.dao.implement.TeacherDAO;

public class FirstTest {
    public static void main(String[] args) {
        DAO<Student> studentDAO = new StudentDAO(SdzConnection.getInstance());
        for (int i = 1; i < 5; i++){
            Student student = studentDAO.find(i);
            System.out.println("Student N* " + student.getId() + " - " + student.getfName() + " " + student.getlName());

        }

        System.out.println("\n*******************************************\n");

        DAO<Teacher> teacherDAO = new TeacherDAO(SdzConnection.getInstance());
        for(int i = 4; i < 8; i++){
            Teacher teacher = teacherDAO.find(i);
            System.out.println(teacher.getfName() + " " + teacher.getlName() + " teaches : ");
            for (Matiere matiere: teacher.getListMatiere())
                System.out.println("\t *" + matiere.getName());

        }


        System.out.println("\n*******************************************\n");
        DAO<Classroom> classroomDAO = new ClassroomDao(SdzConnection.getInstance());
        Classroom classroom = classroomDAO.find(11);

        System.out.println(" Classe of " + classroom.getName());
        System.out.println("\nstudents list ");

        for (Student student: classroom.getListStudent())
            System.out.println(" - " + student.getfName() + " " + student.getlName());

        System.out.println("\nteachers list ");
        for (Teacher teacher: classroom.getListTeacher())
            System.out.println(" - " + teacher.getfName() + " " + teacher.getlName());

    }
}
