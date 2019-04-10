/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bonde
 */
public class Klasse
{
    final private int ID;
    final private String NAME;
    final private List<Student> STUDENTS;
    /**
     * Constructor of Class. Instantiate ClassID and name of class.
     * 
     * @param id
     * @param name 
     */
    public Klasse(int id, String name)
    {
        this.ID = id;
        this.NAME = name;
        STUDENTS = new ArrayList<>();
    }
     
    /**
     * Returns ID of class.
     * @return id
     */
    public int getId()
    {
        return ID;
    }

    /**
     * Returns name of class.
     * @return name
     */
    public String getName()
    {
        return NAME;
    }
    
    /**
     * Adds a new student to the class
     * @param student 
     */
    public void addStudent(Student student) {
        STUDENTS.add(student);
    }
    
    /**
     * Gets all of the students
     * @return list of students
     */
    public List<Student> getStudents() {
        return STUDENTS;
    }
    
    @Override
    public String toString() {
        return NAME;
    }
}
