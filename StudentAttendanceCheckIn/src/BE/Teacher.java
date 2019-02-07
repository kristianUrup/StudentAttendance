/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frederik Jensen
 */
public class Teacher extends Person
{
 
    ArrayList<String> klasser;
    
    public Teacher(int id, String name, int age, String cpr, String email)
    {
        super(id, name, age, cpr, email);
        klasser = new ArrayList<>();
    }
    
    public List<String> getKlasser() {
        return klasser;
    }
    
}
