/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Person;
import BE.Student;
import BE.Teacher;
import java.util.List;

/**
 *
 * @author Kristian Urup laptop
 */
public interface PersonDaoInterface
{
    public List<Student> getAllStudents();
    public List<Teacher> getAllTeachers();
    public List<Person> getAllPersons();
}
