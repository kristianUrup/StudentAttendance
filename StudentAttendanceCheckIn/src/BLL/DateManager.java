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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            throw new BllException("Could not read all dates. " + ex.getMessage());
        }
    }

    public void updateAbsence(int studentID, Date date, boolean isAbsence) throws BllException
    {
        try
        {
            ddao.updateAbsence(studentID, date, isAbsence);
        } catch (DalException ex)
        {
            throw new BllException("Could not update absence. " + ex.getMessage());
        }
    }

    public boolean isStudentAbsence(int studentID) throws BllException
    {
        try
        {
            return ddao.isStudentAbsence(studentID);
        } catch (DalException ex)
        {
            throw new BllException("Could not determine if student was absent. " + ex.getMessage());
        }
    }

    public List<Dato> getStudentAbsenceDates(int studentID) throws BllException
    {
        try
        {
            return ddao.getStudentAbsenceDates(studentID);
        } catch (DalException ex)
        {
            throw new BllException("Could not read all absent dates. " + ex.getMessage());
        }
    }

    public double absenseCalculator(int studentID) throws BllException
    {
        double absencePercentage = 0;
        try
        {
            List<Dato> tmp = new ArrayList();
            List<Dato> list = new ArrayList();
            list = ddao.getStudentAbsenceDates(studentID);
            for (Dato dato : list)
            {
                if(dato.getIsAbsent() == true)
                {
                    tmp.add(dato);
                }
            }
            
            int totalDays = list.size();
            int absentDays = tmp.size();
            
            System.out.println("All dates: " + totalDays);
            System.out.println("Absent days" + absentDays);
            
            absencePercentage = ((absentDays / totalDays) * 100);
            System.out.println("Yo dawg: " + absencePercentage + "% absence");
        } catch (DalException ex)
        {
            Logger.getLogger(DateManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return absencePercentage;
    }
}
