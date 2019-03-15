/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BE.Person;
import BE.Student;
import BE.Teacher;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
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
    public List<Student> getAllStudents() 
    {
        List<Student> studentList = new ArrayList<>();
        try (Connection con = cdao.getConnection()) {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Student INNER JOIN Klasse ON Student.klasseid = Klasse.id");
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
                
                Student student = new Student(id, fullname, age, cpr, email, absence, klasse,dayMostAbsence);
                studentList.add(student); 
            }
            return studentList;
        } catch (SQLException ex)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    public List<Teacher> getAllTeachers()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Person> getAllPersons()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
