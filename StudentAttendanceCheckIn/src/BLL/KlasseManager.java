/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Klasse;
import BE.Teacher;
import BLL.Exceptions.BllException;
import DAL.ClassDAO;
import DAL.Exceptions.DalException;
import java.util.List;

/**
 *
 * @author bonde
 */
public class KlasseManager
{
    ClassDAO cdao;

    public KlasseManager(ClassDAO cdao)
    {
        this.cdao = cdao;
    }
    
    public List<Klasse> getAllClasses() throws BllException
    {
        try
        {
            return cdao.getAllClasses();
        }catch(DalException ex){
            throw new BllException("");
        }
        
    }
    
    public List<Klasse> getTeacherClasses(Teacher teacher) throws BllException
    {
        try
        {
            return cdao.getTeacherClasses(teacher);
        }catch(DalException ex){
            throw new BllException("");
        }
    }
}
