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
import DAL.PersonDAO;
import DAL.PersonDaoInterface;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author Kristian Urup laptop
 */
public class PersonManager{

    PersonDaoInterface pdao;

    public PersonManager() {
        pdao = new PersonDAO();
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
            students = (Student o1, Student o2) -> Double.compare(o2.getAbsence(), o1.getAbsence());
            Collections.sort(sortedStudentList, students);
            return sortedStudentList;
        } catch (DalException ex) {
            throw new BllException("Could not get a sorted absence list of students");
        }
    }
    
    public void updateStudentAbsence(Student student) throws BllException {
        try {
            pdao.updateStudentAbsence(student);
        } catch (DalException ex) {
            throw new BllException("Could not update the students absence");
        }
    }
}
