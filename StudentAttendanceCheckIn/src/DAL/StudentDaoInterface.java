/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Student;
import java.util.List;

/**
 *
 * @author Kristian Urup laptop
 */
public interface StudentDaoInterface
{
    public List<Student> getAllStudents();
}
