/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Frederik Jensen
 */
public abstract class Person
{

    private final StringProperty NAME;
    private final StringProperty CPR;
    private final StringProperty EMAIL;
    private final IntegerProperty ID;
    private final IntegerProperty AGE;

    
    public Person(int id, String name, int age, String cpr, String email) {
        this.NAME = new SimpleStringProperty(name);
        this.ID = new SimpleIntegerProperty(id);
        this.AGE = new SimpleIntegerProperty(age);
        this.CPR = new SimpleStringProperty(cpr);
        this.EMAIL = new SimpleStringProperty(email);
    }
     
    public String getName()
    {
        return NAME.get();
    }

    public void setName(String value)
    {
        NAME.set(value);
    }

    public StringProperty nameProperty()
    {
        return NAME;
    }
    
    public String getEmail()
    {
        return EMAIL.get();
    }

    public void setEmail(String value)
    {
        EMAIL.set(value);
    }

    public StringProperty emailProperty()
    {
        return EMAIL;
    }

    public String getCpr()
    {
        return CPR.get();
    }

    public void setCpr(String value)
    {
        CPR.set(value);
    }

    public StringProperty cprProperty()
    {
        return CPR;
    }
    
    public int getAge()
    {
        return AGE.get();
    }

    public void setAge(int value)
    {
        AGE.set(value);
    }

    public IntegerProperty ageProperty()
    {
        return AGE;
    }
    
    public int getId()
    {
        return ID.get();
    }

    public IntegerProperty idProperty()
    {
        return ID;
    }
}
