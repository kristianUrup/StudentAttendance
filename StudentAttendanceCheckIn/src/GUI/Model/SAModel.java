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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    /**
     * Gets all the persons
     * @return List containing all persons
     * @throws BllException 
     */
    public List<Person> getAllPersons() throws BllException {
        return pm.getAllPersons();
    }
    
    /**
     * Gets all of the Students 
     * @return list of Students
     */
    public ObservableList<Student> getAllStudents() {
        return studentList;
    }
    
    /**
     * Gets all of the Teachers
     * @return list of  Students
     * @throws BllException 
     */
    public List<Teacher> getAllTeachers() throws BllException {
       return pm.getAllTeachers(); 
    }
    
    /**
     * Gets the sorted absence list, descending
     * @return sortedStudentList
     */
    public ObservableList<Student> getSortedAbsenceList() {
        return sortedStudentList;
    }
    
    /**
     * Gets classes for the specific teacher
     * @param id
     * @return List of classes
     * @throws BllException 
     */
    public ObservableList<Klasse> getTeacherClasses(int id) throws BllException
    {     
        for(Klasse klasse : pm.getTeacherClasses(id)) {
            classList.add(klasse);
        }  
        return classList;
    }
    
    /**
     * Gets students from a class
     * @return List of students in a class
     */
    public ObservableList<Student> getStudentsFromClass() {
        return studentFromClassList;
    }
    
    /**
     * 
     * @param klasse
     * @throws BllException 
     */
    public void setStudentsFromClass(Klasse klasse) throws BllException {
        if (!studentFromClassList.isEmpty()) {
            studentFromClassList.clear();
        }
        for (Student student : pm.getStudentsFromClass(klasse)) {
            studentFromClassList.add(student);
        }
    }
    
    /**
     * Checks if the student is absent or not
     * @param studentID
     * @return boolean true if absent
     * @throws BllException 
     */
    public boolean isStudentAbsence(int studentID) throws BllException
    {
        return pm.isStudentAbsence(studentID);
    }
    
    /**
     * Updates the absence of a specific student
     * 
     * @param studentID
     * @param date
     * @param isAbsent
     * @throws BllException 
     */
    public void updateAbsence(int studentID, Date date, boolean isAbsent) throws BllException {
        pm.updateAbsence(studentID, date, isAbsent);
    }
    
    /**
     * Calculates the absence for 1 student
     * 
     * @param studentID
     * @return calculatedAbsence
     */
    public double calculateAbsence(int studentID) {
        try
        {
            return pm.calculateAbsence(studentID);
        } catch (BllException ex)
        {
            Logger.getLogger(SAModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    /**
     * 
     * @param student
     * @throws BllException 
     */
    public void updateStudentAbsence(Student student) throws BllException {
        pm.updateStudentAbsence(student);
    }
    
    /**
     * Updates the day that is most absent, when a student is absent 1 day
     * @param student
     * @return
     * @throws BllException 
     */
    public String updateMostDayAbsent(Student student) throws BllException {
        return pm.updateMostDayAbsent(student);
    }
}
