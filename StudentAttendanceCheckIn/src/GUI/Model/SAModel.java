/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Klasse;
import BE.Person;
import BE.Student;
import BE.Teacher;
import BLL.BLLFacade;
import BLL.Exceptions.BllException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import BLL.IBLLFacade;
import java.util.Date;

/**
 *
 * @author Frederik
 */
public class SAModel {
    
    
    private IBLLFacade pm;
    private ObservableList<Student> studentList;
    private ObservableList<Student> sortedStudentList;
    private ObservableList<Klasse> classList;
    private ObservableList<Student> studentFromClassList;
    
    public SAModel() throws BllException {
        pm = new BLLFacade();
        studentList = FXCollections.observableArrayList();
        studentList.addAll(pm.getAllStudents());
        sortedStudentList = FXCollections.observableArrayList();
        sortedStudentList.addAll(pm.getSortedAbsenceList());
        classList = FXCollections.observableArrayList();
        studentFromClassList = FXCollections.observableArrayList();
    }
    
    public List<Person> getAllPersons() throws BllException {
        return pm.getAllPersons();
    }
    
    public ObservableList<Student> getAllStudents() {
        return studentList;
    }
    
    public List<Teacher> getAllTeachers() throws BllException {
       return pm.getAllTeachers(); 
    }
    
    public ObservableList<Student> getSortedAbsenceList() {
        return sortedStudentList;
    }
    
    public ObservableList<Klasse> getTeacherClasses(int id) throws BllException
    {     
        for(Klasse klasse : pm.getTeacherClasses(id)) {
            classList.add(klasse);
        }  
        return classList;
    }
    
    public ObservableList<Student> getStudentsFromClass(Klasse klasse) throws BllException {
        if (!studentFromClassList.isEmpty()) {
            studentFromClassList.clear();
        }
        for (Student student : pm.getStudentsFromClass(klasse)) {
            studentFromClassList.add(student);
        }
        return studentFromClassList;
    }
    
    public boolean isStudentAbsence(int studentID) throws BllException
    {
        return pm.isStudentAbsence(studentID);
    }
    
    public void updateAbsence(int studentID, Date date, boolean isAbsent) throws BllException {
        pm.updateAbsence(studentID, date, isAbsent);
    }
    
    public double calculateAbsence(int studentID) throws BllException {
        return pm.calculateAbsence(studentID);
    }
    
    public void updateStudentAbsence(Student student) throws BllException {
        pm.updateStudentAbsence(student);
    }
    
    public String updateMostDayAbsent(Student student) throws BllException {
        return pm.updateMostDayAbsent(student);
    }
}
