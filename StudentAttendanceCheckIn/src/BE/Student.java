/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Frederik Jensen
 */
public class Student extends Person
{

    private final DoubleProperty ABSENCE;
    private final StringProperty KLASSE;
    private final StringProperty DAYMOSTABSENT;
    
    public Student(int id, String name, int age, String cpr, String email, double absence, String klasse, String dayMostAbsent) {
        super(id, name, age, cpr, email);
        this.ABSENCE = new SimpleDoubleProperty(absence);
        this.KLASSE = new SimpleStringProperty(klasse);
        this.DAYMOSTABSENT = new SimpleStringProperty(dayMostAbsent);
    }
    
    /**
     * Gets the day that the student is most absent
     * @return dayMostAbsent
     */
    public String getDayMostAbsent()
    {
        return DAYMOSTABSENT.get();
    }

    /**
     * Sets the day that the student is most absent
     * @param value 
     */
    public void setDayMostAbsent(String value)
    {
        DAYMOSTABSENT.set(value);
    }

    
    public StringProperty dayMostAbsentProperty()
    {
        return DAYMOSTABSENT;
    } 

    /**
     * Gets the student's klasse
     * @return klasse
     */
    public String getKlasse()
    {
        return KLASSE.get();
    }

    /**
     * Sets the klasse of a student
     * @param value 
     */
    public void setKlasse(String value)
    {
        KLASSE.set(value);
    }

    public StringProperty klasseProperty()
    {
        return KLASSE;
    }

    /**
     * Gets the absence of a student
     * @return absence
     */
    public double getAbsence()
    {
        return ABSENCE.get();
    }

    public void setAbsence(double value)
    {
        ABSENCE.set(value);
    }

    public DoubleProperty absenceProperty()
    {
        return ABSENCE;
    }
    
}
