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

    private final DoubleProperty absence;
    private final StringProperty klasse;
    private final StringProperty dayMostAbsent;
    
    public Student(int id, String name, int age, String cpr, String email, double absence, String klasse, String dayMostAbsent) {
        super(id, name, age, cpr, email);
        this.absence = new SimpleDoubleProperty(absence);
        this.klasse = new SimpleStringProperty(klasse);
        this.dayMostAbsent = new SimpleStringProperty(dayMostAbsent);
    }
    
    public String getDayMostAbsent()
    {
        return dayMostAbsent.get();
    }

    public void setDayMostAbsent(String value)
    {
        dayMostAbsent.set(value);
    }

    public StringProperty dayMostAbsentProperty()
    {
        return dayMostAbsent;
    } 

    public String getKlasse()
    {
        return klasse.get();
    }

    public void setKlasse(String value)
    {
        klasse.set(value);
    }

    public StringProperty klasseProperty()
    {
        return klasse;
    }

    public double getAbsence()
    {
        return absence.get();
    }

    public void setAbsence(double value)
    {
        absence.set(value);
    }

    public DoubleProperty absenceProperty()
    {
        return absence;
    }
}
