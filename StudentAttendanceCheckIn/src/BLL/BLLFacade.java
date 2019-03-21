/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Klasse;
import BE.Person;
import BE.Student;
import BE.Teacher;
import BLL.Exceptions.BllException;
import java.util.List;

/**
 *
 * @author Frederik
 */
public interface BLLFacade {
    
    public List<Person> getAllPersons();
    
    public List<Student> getAllStudents();
    
    public List<Teacher> getAllTeachers();
    
    public List<Student> getSortedAbsenceList();
}
