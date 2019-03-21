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
    final private int id;
    final private String name;
    final private List<Student> students;
    /**
     * Constructor of Class. Instantiate ClassID and name of class.
     * 
     * @param id
     * @param name 
     */
    public Klasse(int id, String name)
    {
        this.id = id;
        this.name = name;
        students = new ArrayList<>();
    }
     
    /**
     * Returns ID of class.
     * @return 
     */
    public int getId()
    {
        return id;
    }

    /**
     * Returns name of class.
     * @return 
     */
    public String getName()
    {
        return name;
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }
    
    public List<Student> getStudents() {
        return students;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
