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
    
    
    private BLLFacade pm;
    private KlasseManager km;
    private ObservableList<Student> studentList;
    private ObservableList<Student> sortedStudentList;
    private ObservableList<Klasse> classList;
    
    public SAModel() {
        pm = new PersonManager(new PersonDAO());
        studentList = FXCollections.observableArrayList();
        studentList.addAll(pm.getAllStudents());
        sortedStudentList = FXCollections.observableArrayList();
        sortedStudentList.addAll(pm.getSortedAbsenceList());
        classList = FXCollections.observableArrayList();
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
    
    public ObservableList<Klasse> getTeacherClasses(Teacher teacher) throws BllException
    {
        
        for (Klasse klasse : km.getTeacherClasses(teacher)) {
            classList.add(klasse);
        }
        return classList;
        
    }
}
