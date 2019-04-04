/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Person;
import BE.Student;
import BE.Teacher;
import DAL.Exceptions.DalException;
import java.util.List;

/**
 *
 * @author Kristian Urup laptop
 */
public interface PersonDaoInterface
{
    public List<Student> getAllStudents() throws DalException;
    
    public List<Teacher> getAllTeachers() throws DalException;
    
    public List<Person> getAllPersons() throws DalException;
    
    public void updateStudentAbsence(Student student) throws DalException; 
    
    public void updateMostDayAbsent(Student student) throws DalException;
}
