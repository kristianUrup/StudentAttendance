/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Person;
import BE.Student;
import BE.Teacher;
import DAL.PersonDaoInterface;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Kristian Urup laptop
 */
public class PersonManager implements BLLFacade {

    PersonDaoInterface pdao;

    public PersonManager(PersonDaoInterface pdao) {
        this.pdao = pdao;
    }

    @Override
    public List<Person> getAllPersons() {
        return pdao.getAllPersons();
    }

    @Override
    public List<Student> getAllStudents() {
        return pdao.getAllStudents();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return pdao.getAllTeachers();
    }

    @Override
    public List<Student> getSortedAbsenceList() {
        List<Student> sortedStudentList = pdao.getAllStudents();
        Comparator<Student> students;
        students = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getAbsence(), o1.getAbsence());
            }
            
        };
        Collections.sort(sortedStudentList, students);
        return sortedStudentList;
    }

}
