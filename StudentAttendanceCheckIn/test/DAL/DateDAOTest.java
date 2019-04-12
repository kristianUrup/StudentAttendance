/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Dato;
import DAL.Exceptions.DalException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Frederik Jensen
 */
public class DateDAOTest
{
    
    public DateDAOTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }

    /**
     * Test of isStudentAbsence method, of class DateDAO.
     */
    @Test
    public void testIsStudentAbsence() throws Exception
    {
    }

    /**
     * Test of getStudentAbsenceDates method, of class DateDAO.
     */
    @Test
    public void testGetStudentAbsenceDates() throws Exception
    {
        DateDAO ddao = new DateDAO();
        List<Dato> studentAbsenceDates = ddao.getStudentAbsenceDates(1009);
        int expectedListSize = 3;
        
        assertEquals(expectedListSize, studentAbsenceDates.size(), 1E-3);
    }
    
    @Test(expected = DalException.class)
    public void testIncorrectDateFormat() throws DalException {
        DateDAO ddao = new DateDAO();
        List<Dato> studentAbsenceDates = ddao.getStudentAbsenceDates(1009);
    }
    
}
