/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BE.Person;
import BE.Student;
import BE.Teacher;
import DAL.Exceptions.DalException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Kristian Urup laptop
 */
public class PersonDAO implements PersonDaoInterface
{
    ConnectionDAO cdao;
    public PersonDAO() {
        cdao = new ConnectionDAO();
    }
    public List<Student> getAllStudents() throws DalException 
    {
        boolean studentAbsentToday = false;
        List<Student> studentList = new ArrayList<>();
        try (Connection con = cdao.getConnection()) {
            String sql = "SELECT * FROM Student INNER JOIN Klasse ON Student.klasseid = Klasse.id";
            PreparedStatement pst = con.prepareStatement(sql);
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
                String klasse = rs.getString("klassename");
                
                Student student = new Student(id, fullname, age, cpr, email, absence, klasse,dayMostAbsence, studentAbsentToday);
                studentList.add(student); 
            }
            return studentList;
        } catch (SQLException ex)
        {
            throw new DalException("Could not get all students");
        }
        
    }
    
    public List<Teacher> getAllTeachers() throws DalException
    {
        List<Teacher> teacherList = new ArrayList<>();
        try (Connection con = cdao.getConnection()) {
            String sql = "SELECT * FROM Teacher";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String fullname = firstName + " " + lastName;
                String cpr = rs.getString("cpr");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                Teacher teacher = new Teacher(id, fullname, age, cpr, email);
                teacherList.add(teacher);
            }
            return teacherList;
        } catch (SQLException ex) {
            throw new DalException("Could not get all Teachers");
        }
        
    }

    public List<Person> getAllPersons() throws DalException
    {
        try {
            List<Person> personList = new ArrayList<>();
            List<Student> studentList = getAllStudents();
            List<Teacher> teacherList = getAllTeachers();
            
            for (Student student : studentList) {
                personList.add(student);
            }
            
            for (Teacher teacher : teacherList) {
                personList.add(teacher);
            }
            
            return personList;
        } catch (DalException ex) {
            throw new DalException("Could not get all students or teachers");
        }
    }
    
    public void updateStudentAbsence(Student student) throws DalException {
        try (Connection con = cdao.getConnection()) {
            String sql = "UPDATE Student SET absence = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setDouble(1, student.getAbsence());
            pst.setInt(2, student.getId());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new DalException("Could not update students absence");
        }
    }
}
