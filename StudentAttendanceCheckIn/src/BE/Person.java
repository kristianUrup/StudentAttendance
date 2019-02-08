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

    private final StringProperty name;
    private final StringProperty cpr;
    private final StringProperty email;
    private final IntegerProperty id;
    private final IntegerProperty age;

    
    public Person(int id, String name, int age, String cpr, String email) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleIntegerProperty(id);
        this.age = new SimpleIntegerProperty(age);
        this.cpr = new SimpleStringProperty(cpr);
        this.email = new SimpleStringProperty(email);
    }
     
    public String getName()
    {
        return name.get();
    }

    public void setName(String value)
    {
        name.set(value);
    }

    public StringProperty nameProperty()
    {
        return name;
    }
    
    public String getEmail()
    {
        return email.get();
    }

    public void setEmail(String value)
    {
        email.set(value);
    }

    public StringProperty emailProperty()
    {
        return email;
    }

    public String getCpr()
    {
        return cpr.get();
    }

    public void setCpr(String value)
    {
        cpr.set(value);
    }

    public StringProperty cprProperty()
    {
        return cpr;
    }
    
    public int getAge()
    {
        return age.get();
    }

    public void setAge(int value)
    {
        age.set(value);
    }

    public IntegerProperty ageProperty()
    {
        return age;
    }
    
    public int getId()
    {
        return id.get();
    }

    public IntegerProperty idProperty()
    {
        return id;
    }
}
