/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Dato;
import BE.Klasse;
import BE.Person;
import BE.Student;
import BE.Teacher;
import BLL.Exceptions.BllException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Frederik
 */
public interface BLLFacade {
    //DateManger
    public List<Dato> getAllDates() throws BllException;
    
    public void updateAbsence(int studentID, Date date, boolean isAbsence) throws BllException;
    
    public boolean isStudentAbsence(int studentID) throws BllException;
    
    public List<Dato> getStudentAbsenceDates(int studentID) throws BllException;
    
    //KlasseManager
    public List<Klasse> getAllClasses() throws BllException;
    
    public List<Klasse> getTeacherClasses(int id) throws BllException;
    
    public List<Student> getStudentsFromClass(Klasse klasse) throws BllException;
    
    //PersonManager
    public List<Person> getAllPersons() throws BllException;
    
    public List<Student> getAllStudents() throws BllException;
    
    public List<Teacher> getAllTeachers() throws BllException;
    
    public List<Student> getSortedAbsenceList() throws BllException;
}
