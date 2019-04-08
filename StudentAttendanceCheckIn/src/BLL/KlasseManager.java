/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Klasse;
import BE.Student;
import BLL.Exceptions.BllException;
import DAL.ClassDAO;
import DAL.ClassInterface;
import DAL.Exceptions.DalException;
import java.util.List;

/**
 *
 * @author bonde
 */
public class KlasseManager
{
    ClassInterface cli;

    public KlasseManager()
    {
        cli = new ClassDAO();
    }
    
    /**
     * Gets all of the classes from the Klasse table
     * 
     * @return all Classes
     * @throws BllException 
     */
    public List<Klasse> getAllClasses() throws BllException
    {
        try
        {
            return cli.getAllClasses();
        }catch(DalException ex){
            throw new BllException("");
        }
        
    }
    
    /**
     * Gets all of the specific classes to a specific teacher
     * 
     * @param id
     * @return
     * @throws BllException 
     */
    public List<Klasse> getTeacherClasses(int id) throws BllException
    {
        try
        {
            return cli.getTeacherClasses(id);
        }catch(DalException ex){
            throw new BllException("");
        }
    }
    
    /**
     * Gets all students in a specific class
     * 
     * @param klasse
     * @return List of class
     * @throws BllException 
     */
    public List<Student> getStudentsFromClass(Klasse klasse) throws BllException {
        try {
            return cli.getStudentsFromClass(klasse);
        } catch (DalException ex) {
            throw new BllException("Could not get students from class");
        }
    }
}
