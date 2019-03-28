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
import java.util.logging.Level;
import java.util.logging.Logger;
import studentattendancecheckin.StudentAttendanceCheckIn;

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

    @Override
    public void updateAbsence(int studentID, Date date, boolean isAbsence) throws DalException
    {
        try (Connection con = dc.getConnection())
        {
            String sql = "UPDATE StudentAbsenceDates INNER JOIN SchoolDates on StudentAbsenceDates.dateID = SchoolDates.id "
                    + "SET isabsent = ? WHERE studentID = ? AND SchoolDates.date = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, String.valueOf(isAbsence));
            pst.setInt(2, studentID);
            pst.setString(3, new SimpleDateFormat("dd/MM/yyyy").format(date));
            
            pst.executeUpdate();
            
        } catch (SQLException ex)
        {
            throw new DalException("Could not update students absence");
        }
    }
    
    @Override
    public boolean isStudentAbsence(int studentID) throws DalException {
        try(Connection con = dc.getConnection()) {
            String sql = "SELECT * FROM StudentAbsenceDates INNER JOIN SchoolDates on StudentAbsenceDates.dateID = SchoolDates.id "
                    + "WHERE studentID = ? AND SchoolDates.date = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, studentID);
            LocalDate local = LocalDate.now();
            pst.setString(2, DateTimeFormatter.ofPattern("dd/MM/yyyy").format(local));
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                return Boolean.parseBoolean(rs.getString("isabsent"));
            }
        } catch (SQLException ex)
        {
            throw new DalException("Could not get the students absent");
        }
        return false;
    }
    
    @Override
    public List<Dato> getStudentAbsenceDates(int studentID) throws DalException {
        List<Dato> studentDateList = new ArrayList<>();
        
        try(Connection con = dc.getConnection()) {
            String sql = "SELECT * FROM StudentAbsenceDates INNER JOIN SchoolDates on StudentAbsenceDates.dateID = SchoolDates.id "
                    + "WHERE studentID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, studentID);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("dateID");
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("date"));
                String day = rs.getString("day");
                boolean isAbsent = Boolean.parseBoolean(rs.getString("isabsent"));
                Dato dato = new Dato(id, date, day, isAbsent);
                studentDateList.add(dato);
            }
        } catch (SQLException | ParseException ex)
        {
            throw new DalException("Could not get student absence");
        }
        return studentDateList;
    }

    //We dont need this method anymore. This was just for adding random mockdata
    //to the database so we can calculate a students absent
    public void addStudentAbsenceToTable() throws DalException
    {
        try
        {
            PersonDAO pdao = new PersonDAO();
            String[] isAbsent = new String[2];
            LocalDate locatdate = LocalDate.now();
            String localdateString = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(locatdate);
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(localdateString);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            isAbsent[0] = "true";
            isAbsent[1] = "false";

            Random random = new Random();

            List<Student> studentList = pdao.getAllStudents();
            List<Dato> dateList = getAllDates();
            try (Connection con = dc.getConnection())
            {
                for (Student student : studentList)
                {
                    for (Dato dato : dateList)
                    {
                        String sql = "INSERT INTO StudentAbsenceDates (dateID, studentID, isabsent) VALUES(?,?,?);";
                        PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        pst.setInt(1, dato.getId());
                        pst.setInt(2, student.getId());
                        if (date1.after(dato.getDate()))
                        {
                            pst.setString(3, isAbsent[random.nextInt(isAbsent.length)]);
                        } else if (date1.before(dato.getDate()))
                        {
                            pst.setString(3, isAbsent[1]);
                        } else if (date1.equals(dato.getDate()))
                        {
                            pst.setString(3, isAbsent[random.nextInt(isAbsent.length)]);
                        }

                        pst.executeUpdate();
                    }
                }
            } catch (SQLException ex)
            {
                throw new DalException("Shouldnt use this method");
            }
        } catch (ParseException | DalException ex)
        {
            throw new DalException("Seriously dont use this method it was just for adding things to the database easier for one time");
        }
    }
}
