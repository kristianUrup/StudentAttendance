/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Klasse;
import BE.Student;
import DAL.Exceptions.DalException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bonde
 */
public class ClassDAO implements ClassInterface {

    private final ConnectionDAO cd;

    /**
     * Constructor of Class DAO. Instantiates the connection to the database.
     *
     * @param cd
     */
    public ClassDAO() {
        cd = new ConnectionDAO();
    }
    
    @Override
    public List<Klasse> getAllClasses() throws DalException {
        List<Klasse> klasser = new ArrayList<>();
        
        try (Connection con = cd.getConnection()) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Klasse;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("klassename");
                
                Klasse klasse = new Klasse(id, name);
                klasser.add(klasse);
            }
            
        } catch (SQLException ex) {
            throw new DalException("Could not get all classes: " + ex.getMessage());
        }
        return klasser;
    }
    
    @Override
    public List<Klasse> getTeacherClasses(int teacherID) throws DalException {
        List<Klasse> teacherclasses = new ArrayList<>();
        
        try (Connection con = cd.getConnection()) {
            String sql = "SELECT * FROM TeacherKlasse INNER JOIN Klasse ON TeacherKlasse.klasseID = Klasse.id WHERE TeacherKlasse.teacherID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, teacherID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("klasseID");
                String name = rs.getString("klassename");
                Klasse klasse = new Klasse(id, name);
                teacherclasses.add(klasse);
            }
        } catch (SQLException ex) {
            throw new DalException("Could not get the teacher's classes");
        }
        return teacherclasses;
    }
    
    @Override
    public List<Student> getStudentsFromClass(Klasse klasse) throws DalException {
        boolean studentAbsentToday = false;
        List<Student> studentsInClass = new ArrayList<>();
        try (Connection con = cd.getConnection()) {

                String sql = "SELECT * FROM Student INNER JOIN Klasse ON Student.klasseid = Klasse.id WHERE klasseid = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, klasse.getId());
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String fullname = firstname + " " + lastname;
                    String cpr = rs.getString("cpr");
                    int age = rs.getInt("age");
                    String email = rs.getString("email");
                    double absence = rs.getDouble("absence");
                    String dayMostAbsence = rs.getString("daymostabsence");
                    
                    Student student = new Student(id, fullname, age, cpr, email, absence, klasse.getName(),dayMostAbsence);
                    studentsInClass.add(student);
                }
        } catch (SQLException ex) {
            throw new DalException("Could not get students from class");
        }
        return studentsInClass;
    }
    
}
