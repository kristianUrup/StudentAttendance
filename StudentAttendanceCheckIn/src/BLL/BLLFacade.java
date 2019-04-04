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
    @Override
    public List<Dato> getAllDates() throws BllException
    {
            return DaM.getAllDates();     
    }
    
    @Override
    public void updateAbsence(int studentID, Date date, boolean isAbsence) throws BllException
    {
        DaM.updateAbsence(studentID, date, isAbsence);
    }
    
    @Override
    public boolean isStudentAbsence(int studentID) throws BllException
    {
        return DaM.isStudentAbsence(studentID);
    }
    
    @Override
    public List<Dato> getStudentAbsenceDates(int studentID) throws BllException
    {
        return DaM.getStudentAbsenceDates(studentID);
    }
    
    @Override
    public String updateMostDayAbsent(Student student) throws BllException {
        return DaM.updateMostDayAbsent(student);
    }
    
    //KlasseManager
    @Override
    public List<Klasse> getAllClasses() throws BllException
    {
        return KlM.getAllClasses();
    }
    
    @Override
    public List<Klasse> getTeacherClasses(int id) throws BllException
    {
        return KlM.getTeacherClasses(id);
    }
    
    @Override
    public List<Student> getStudentsFromClass(Klasse klasse) throws BllException 
    {
        return KlM.getStudentsFromClass(klasse);
    }
    
    //PersonManager
    @Override
    public List<Person> getAllPersons() throws BllException
    {
        return PeM.getAllPersons();
    }
    
    @Override
    public List<Student> getAllStudents() throws BllException
    {
        return PeM.getAllStudents();
    }
    
    @Override
    public List<Teacher> getAllTeachers() throws BllException
    {
        return PeM.getAllTeachers();
    }
    
    @Override
    public List<Student> getSortedAbsenceList() throws BllException
    {
        return PeM.getSortedAbsenceList();
    }

    @Override
    public double calculateAbsence(int studentID) throws BllException {
        return DaM.absenseCalculator(studentID);
    }

    @Override
    public void updateStudentAbsence(Student student) throws BllException {
        PeM.updateStudentAbsence(student);
    }
}
