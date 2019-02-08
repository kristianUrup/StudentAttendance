/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Person;
import BE.Student;
import BE.Teacher;
import DAL.PersonDAOMock;
import DAL.PersonDaoInterface;
import java.util.List;

/**
 *
 * @author Kristian Urup laptop
 */
public class PersonManager implements BLLFacade {

    PersonDaoInterface pdao;

    public PersonManager() {
        pdao = new PersonDAOMock();
    }

    @Override
    public List<Person> getAllPersons() {
        return pdao.getAllPersons();
    }

    @Override
    public List<Student> getAllStudents() {
        return pdao.getAllStudents();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return pdao.getAllTeachers();
    }

}