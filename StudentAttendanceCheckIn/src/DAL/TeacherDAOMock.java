/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kristian Urup laptop
 */
public class TeacherDAOMock implements TeacherDaoInterface
{
    public List<Teacher> getAllTeachers()
    {
        List<Teacher> teachers = new ArrayList();
        
        Teacher mathias = new Teacher(2, "Mathias", 19, "020200-1888", "Megasej@gmail.com");
        Teacher frederik = new Teacher(1, "Frederik", 20, "030399-1022", "noob@gmail.com");
        Teacher jørgen = new Teacher(3, "Jørgen", 20, "202099-1021", "Flotfyr@hotmail.com");
        Teacher kristian = new Teacher(4, "Kristian", 24, "200294-1001", "hejson@gmail.com");
        
        teachers.add(mathias);
        teachers.add(frederik);
        teachers.add(jørgen);
        teachers.add(kristian);
        return teachers;
    } 
}
