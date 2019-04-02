/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Dato;
import BLL.Exceptions.BllException;
import DAL.DateDAO;
import DAL.DateInterface;
import DAL.Exceptions.DalException;
import java.util.Date;
import java.util.List;


/**
 *
 * @author KristianUrup
 */
public class DateManager 
{
    DateInterface ddao;
    public DateManager()
    {
        ddao = new DateDAO();
    }
    
    public List<Dato> getAllDates() throws BllException
    {
        try
        {
            return ddao.getAllDates();
        } catch (DalException ex)
        {
            throw new BllException("Could not read all songs. " + ex.getMessage());
        }
    }
    
    public void updateAbsence(int studentID, Date date, boolean isAbsence) throws BllException 
    {
        try
        {
            ddao.updateAbsence(studentID, date, isAbsence);
        } catch (DalException ex)
        {
            throw new BllException("Could not read all songs. " + ex.getMessage());
        }
    }
    
    public boolean isStudentAbsence(int studentID) throws BllException
    {
        try
        {
            return ddao.isStudentAbsence(studentID);
        } catch (DalException ex)
        {
            throw new BllException("Could not read all songs. " + ex.getMessage());
        }
    }
    
    public List<Dato> getStudentAbsenceDates(int studentID) throws BllException
    {
        try
        {
            return ddao.getStudentAbsenceDates(studentID);
        } catch (DalException ex)
        {
            throw new BllException("Could not read all songs. " + ex.getMessage());
        }
    }
}
