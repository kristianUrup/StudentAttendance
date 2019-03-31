/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Person;
import BE.Student;
import BE.Teacher;
import BLL.Exceptions.BllException;
import DAL.Exceptions.DalException;
import DAL.PersonDaoInterface;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kristian Urup laptop
 */
public class PersonManager{

    PersonDaoInterface pdao;

    public PersonManager(PersonDaoInterface pdao) {
        this.pdao = pdao;
    }

    public List<Person> getAllPersons() throws BllException {
        try {
            return pdao.getAllPersons();
        } catch (DalException ex) {
            throw new BllException("Could not get all persons");
        }
    }

    public List<Student> getAllStudents() throws BllException {
        try {
            return pdao.getAllStudents();
        } catch (DalException ex) {
            throw new BllException("Could not get all students");
        }
    }

    public List<Teacher> getAllTeachers() throws BllException {
        try {
            return pdao.getAllTeachers();
        } catch (DalException ex) {
            throw new BllException("Could not get all teachers");
        }
    }

    public List<Student> getSortedAbsenceList() throws BllException {
        try {
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
        } catch (DalException ex) {
            throw new BllException("Could not get a sorted absence list of students");
        }
    }
}
