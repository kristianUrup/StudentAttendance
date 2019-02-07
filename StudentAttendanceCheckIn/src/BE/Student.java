/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Frederik Jensen
 */
public class Student extends Person
{
    private double absence;
    private String klasse;
    
    public Student(int id, String name, int age, String cpr, String email, double absence, String klasse) {
        super(id, name, age, cpr, email);
        this.absence = absence;
        this.klasse = klasse;
        
    }

    public double getAbsence()
    {
        return absence;
    }

    public void setAbsence(double absence)
    {
        this.absence = absence;
    }
    
    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }
    
    public String getKlasse() {
        return klasse;
    }
}
