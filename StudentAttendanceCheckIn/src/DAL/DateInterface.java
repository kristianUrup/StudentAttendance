/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Dato;
import DAL.Exceptions.DalException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Frederik Jensen
 */
public interface DateInterface
{
    public List<Dato> getAllDates() throws DalException;
    
    public void updateAbsence(int studentID, Date date, boolean isAbsence) throws DalException;
    
    public boolean isStudentAbsence(int studentID) throws DalException;
    
    public List<Dato> getStudentAbsenceDates(int studentID) throws DalException;
}
