/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Dato;
import BE.Student;
import DAL.Exceptions.DalException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Frederik Jensen
 */
public class DateDAO implements DateInterface
{

    ConnectionDAO dc;

    public DateDAO()
    {
        dc = new ConnectionDAO();
    }

    /**
     * Gets all the schooldates from the SchoolDates Table. 
     * 
     * @return dates
     * @throws DalException 
     */
    @Override
    public List<Dato> getAllDates() throws DalException
    {
        List<Dato> dates = new ArrayList<>();
        try (Connection con = dc.getConnection())
        {
            String sql = "SELECT * FROM SchoolDates";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("id");
                String stringDate = rs.getString("date");
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
                String day = rs.getString("day");

                Dato dato = new Dato(id, date, day);
                dates.add(dato);
            }
        } catch (SQLException | ParseException ex)
        {
            throw new DalException("Could not get all dates on database");
        }
        return dates;
    }
    
    /**
     * Updates the absence of a student
     * 
     * @param studentID
     * @param date
     * @param isAbsence
     * @throws DalException 
     */
    @Override
    public void updateAbsence(int studentID, Date date, boolean isAbsence) throws DalException
    {
        try (Connection con = dc.getConnection())
        {
            String sql = "UPDATE StudentAbsenceDates SET isabsent = ? "
                    + "FROM StudentAbsenceDates INNER JOIN SchoolDates ON StudentAbsenceDates.dateID = SchoolDates.id "
                    + "WHERE studentID = ? AND SchoolDates.date = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            if (isAbsence) {
                pst.setInt(1, 0);
            } else {
                pst.setInt(1, 1);
            }
            pst.setInt(2, studentID);
            pst.setString(3, new SimpleDateFormat("dd/MM/yyyy").format(date));

            pst.executeUpdate();

        } catch (SQLException ex)
        {
            throw new DalException("Could not update students absence");
        }
    }

    /**
     * Checks if the student is absent or not
     * 
     * @param studentID
     * @return false
     * @throws DalException 
     */
    @Override
    public boolean isStudentAbsence(int studentID) throws DalException
    {
        try (Connection con = dc.getConnection())
        {
            String sql = "SELECT * FROM StudentAbsenceDates INNER JOIN SchoolDates on StudentAbsenceDates.dateID = SchoolDates.id "
                    + "WHERE studentID = ? AND SchoolDates.date = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, studentID);
            LocalDate local = LocalDate.now();
            pst.setString(2, DateTimeFormatter.ofPattern("dd/MM/yyyy").format(local));

            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                return rs.getInt("isAbsent") == 0;
            }
        } catch (SQLException ex)
        {
            throw new DalException("Could not get the students absent");
        }
        return false;
    }

    /**
     * Gets a list of all the dates that the student was absent
     * 
     * @param studentID
     * @return studentDateList
     * @throws DalException 
     */
    @Override
    public List<Dato> getStudentAbsenceDates(int studentID) throws DalException
    {
        List<Dato> studentDateList = new ArrayList<>();
        try (Connection con = dc.getConnection())
        {
            LocalDate locatdate = LocalDate.now();
            String localdateString = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(locatdate);
            Date today = new SimpleDateFormat("dd/MM/yyyy").parse(localdateString);
            String sql = "SELECT * FROM StudentAbsenceDates INNER JOIN SchoolDates on StudentAbsenceDates.dateID = SchoolDates.id "
                    + "WHERE studentID = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, studentID);

            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("dateID");
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("date"));
                String day = rs.getString("day");
                boolean isAbsent;
                int absence = rs.getInt("isAbsent");
                if(absence == 0) {
                    isAbsent = false;
                }else {
                    isAbsent = true;
                }
                Dato dato = new Dato(id, date, day, isAbsent);
                if (!dato.getDate().after(today))
                {
                    studentDateList.add(dato);
                }
            }
        } catch (SQLException | ParseException ex)
        {
            throw new DalException("Could not get student absence");
        }
        return studentDateList;
    }

    /**
     * 
     * 
     * @param student
     * @throws DalException 
     */
    @Override
    public void updateMostDayAbsent(Student student) throws DalException {
        try (Connection con =dc.getConnection()) {
            String sql = "UPDATE Student SET daymostabsence = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, student.getDayMostAbsent());
            pst.setInt(2, student.getId());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new DalException("Could not update students most day where he/her is absent");
        } 
    }
}
