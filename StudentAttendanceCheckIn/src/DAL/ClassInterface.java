/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Klasse;
import BE.Student;
import BE.Teacher;
import DAL.Exceptions.DalException;
import java.util.List;

/**
 *
 * @author bonde
 */
public interface ClassInterface
{
    /**
     * Gets all classes in the list of classes.
     * 
     * @return 
     * @throws DAL.Exceptions.DalException
     */
    public List<Klasse> getAllClasses() throws DalException;
    
    public List<Klasse> getTeacherClasses(int id) throws DalException;
    
    public List<Student> getStudentsFromClass(Klasse klasse) throws DalException;
}
