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
import BLL.PersonManager;
import DAL.PersonDAO;
import DAL.PersonDAOMock;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Frederik
 */
public class SAModel {
    
    
    private ObservableList<Klasse> classList;
    private BLLFacade pm;
    private ObservableList<Student> studentList;
    private ObservableList<Student> sortedStudentList;
    
    public SAModel() {
        pm = new PersonManager(new PersonDAOMock());
        studentList = FXCollections.observableArrayList();
        studentList.addAll(pm.getAllStudents());
        sortedStudentList = FXCollections.observableArrayList();
        sortedStudentList.addAll(pm.getSortedAbsenceList());
        
        classList = FXCollections.observableArrayList();
        Klasse CS2018A = new Klasse(1,"CS2018A");
        classList.add(CS2018A);
    }
    
    public List<Person> getAllPersons() {
        return pm.getAllPersons();
    }
    
    public ObservableList<Student> getAllStudents() {
        return studentList;
    }
    
    public List<Teacher> getAllTeachers() {
       return pm.getAllTeachers(); 
    }
    
    public ObservableList<Student> getSortedAbsenceList() {
        return sortedStudentList;
    }
    
    public ObservableList<Klasse> getAllClasses()
    {
        return classList;
    }
}
