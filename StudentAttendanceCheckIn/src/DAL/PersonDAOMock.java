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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kristian Urup laptop
 */


public class PersonDAOMock implements PersonDaoInterface
{
    String dm = "CS2018A";
    Teacher søren = new Teacher(1, "Søren Henning", 39, "020280-1888", "Søren@gmail.com");
    Teacher jeppe = new Teacher(2, "Jeppe", 39, "030380-1022", "Jeppe@gmail.com");
    Teacher stig = new Teacher(3, "Stig", 39, "202080-1021", "Stig@hotmail.com");
    Teacher henning = new Teacher(4, "Henning", 40, "200279-1001", "Bent@gmail.com");
    Student mathias = new Student(1, "Søren Paulsen", 30, "020288-1888", "søren@gmail.com", 2.5, dm, "Torsdag");
    Student frederik = new Student(2, "Frederik Jensen", 20, "030399-1022", "noob@gmail.com", 0.3, dm, "Tirsdag");
    Student jørgen = new Student(3, "Jørgen Svendsen", 20, "202099-1021", "Flotfyr@hotmail.com", 4.7, dm, "Onsdag");
    Student kristian = new Student(4, "Kristian Bertelsen", 24, "200294-1001", "hejson@gmail.com", 3.2, dm, "Fredag");

    @Override
    public List<Student> getAllStudents()
    {
        List<Student> students = new ArrayList();

        students.add(mathias);
        students.add(frederik);
        students.add(jørgen);
        students.add(kristian);
        return students;
    }
    
    @Override
    public List<Teacher> getAllTeachers()
    {
        List<Teacher> teachers = new ArrayList();
        teachers.add(søren);
        teachers.add(jeppe);
        teachers.add(stig);
        teachers.add(henning);

        return teachers;
    }

    @Override
    public List<Person> getAllPersons()
    {
        List<Person> persons = new ArrayList();

        persons.add(mathias);
        persons.add(frederik);
        persons.add(jørgen);
        persons.add(kristian);
        persons.add(søren);
        persons.add(jeppe);
        persons.add(stig);
        persons.add(henning);

        return persons;
    }

    @Override
    public void updateStudentAbsence(Student student) throws DalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMostDayAbsent(Student student) throws DalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
