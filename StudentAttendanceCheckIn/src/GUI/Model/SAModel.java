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
import BLL.KlasseManager;
import BLL.PersonManager;
import DAL.ClassDAO;
import DAL.PersonDAO;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Frederik
 */
public class SAModel {
    
    
    private BLLFacade pm;
    private KlasseManager km;
    private ObservableList<Student> studentList;
    private ObservableList<Student> sortedStudentList;
    private ObservableList<Klasse> classList;
    private ObservableList<Student> studentFromClassList;
    
    public SAModel() {
        pm = new PersonManager(new PersonDAO());
        km = new KlasseManager(new ClassDAO());
        studentList = FXCollections.observableArrayList();
        studentList.addAll(pm.getAllStudents());
        sortedStudentList = FXCollections.observableArrayList();
        sortedStudentList.addAll(pm.getSortedAbsenceList());
        classList = FXCollections.observableArrayList();
        studentFromClassList = FXCollections.observableArrayList();
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
    
    public ObservableList<Klasse> getTeacherClasses(int id) throws BllException
    {     
        for(Klasse klasse : km.getTeacherClasses(id)) {
            classList.add(klasse);
        }  
        return classList;
    }
    
    public ObservableList<Student> getStudentsFromClass(Klasse klasse) {
        if (!studentFromClassList.isEmpty()) {
            studentFromClassList.clear();
        }
        for (Student student : km.getStudentsFromClass(klasse)) {
            studentFromClassList.add(student);
        }
        return studentFromClassList;
    }
}
