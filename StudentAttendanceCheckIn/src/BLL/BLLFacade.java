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
import DAL.ClassDAO;
import DAL.DateDAO;
import DAL.PersonDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KristianUrup
 */
public class BLLFacade implements IBLLFacade{
    DateManager DaM;
    KlasseManager KlM;
    PersonManager PeM;
    
    public BLLFacade()
    {
        DaM = new DateManager();
        KlM = new KlasseManager();
        PeM = new PersonManager();
    }
    //DateManager
    public List<Dato> getAllDates() throws BllException
    {
            return DaM.getAllDates();     
    }
    
    public void updateAbsence(int studentID, Date date, boolean isAbsence) throws BllException
    {
        DaM.updateAbsence(studentID, date, isAbsence);
    }
    
    public boolean isStudentAbsence(int studentID) throws BllException
    {
        return DaM.isStudentAbsence(studentID);
    }
    
    public List<Dato> getStudentAbsenceDates(int studentID) throws BllException
    {
        return DaM.getStudentAbsenceDates(studentID);
    }
    
    //KlasseManager
    public List<Klasse> getAllClasses() throws BllException
    {
        return KlM.getAllClasses();
    }
    
    public List<Klasse> getTeacherClasses(int id) throws BllException
    {
        return KlM.getTeacherClasses(id);
    }
    
    public List<Student> getStudentsFromClass(Klasse klasse) throws BllException 
    {
        return KlM.getStudentsFromClass(klasse);
    }
    
    //PersonManager
    public List<Person> getAllPersons() throws BllException
    {
        return PeM.getAllPersons();
    }
    
    public List<Student> getAllStudents() throws BllException
    {
        return PeM.getAllStudents();
    }
    
    public List<Teacher> getAllTeachers() throws BllException
    {
        return PeM.getAllTeachers();
    }
    
    public List<Student> getSortedAbsenceList() throws BllException
    {
        return PeM.getSortedAbsenceList();
    }
}
