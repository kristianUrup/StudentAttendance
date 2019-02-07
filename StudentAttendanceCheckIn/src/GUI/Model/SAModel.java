/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Person;
import BE.Student;
import BE.Teacher;
import BLL.BLLFacade;
import BLL.PersonManager;
import java.util.List;

/**
 *
 * @author Frederik
 */
public class SAModel {
    
    BLLFacade pm;
    public SAModel() {
        pm = new PersonManager();
    }
    
    public List<Person> getAllPersons() {
        return pm.getAllPersons();
    }
    
    public List<Student> getAllStudents() {
        return pm.getAllStudents();
    }
    
    public List<Teacher> getAllTeachers() {
       return pm.getAllTeachers(); 
    }
}
