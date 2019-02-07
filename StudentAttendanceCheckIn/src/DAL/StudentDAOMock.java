/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kristian Urup laptop
 */
public class StudentDAOMock implements StudentDaoInterface
{
        public List<Student> getAllStudents()
    {
        String dm = "CS2018A";
        List<Student> students = new ArrayList();
        
        Student mathias = new Student(1, "Søren", 30, "020288-1888", "søren@gmail.com", 2.5, dm);
        Student frederik = new Student(2, "Frederik", 20, "030399-1022", "noob@gmail.com", 0.3, dm);
        Student jørgen = new Student(3, "Jørgen", 20, "202099-1021", "Flotfyr@hotmail.com", 4.7, dm);
        Student kristian = new Student(4, "Kristian", 24, "200294-1001", "hejson@gmail.com", 3.2, dm);
        
        students.add(mathias);
        students.add(frederik);
        students.add(jørgen);
        students.add(kristian);
        return students;
    }
}
