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
public abstract class Person
{
    private final int ID;
    private String name;
    private int age;
    private String cpr;
    private String email;
    
    public Person(int id, String name, int age, String cpr, String email) {
        this.ID = id;
        this.name = name;
        this.age = age;
        this.cpr = cpr;
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getCpr()
    {
        return cpr;
    }

    public String getEmail()
    {
        return email;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setCpr(String cpr)
    {
        this.cpr = cpr;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getID()
    {
        return ID;
    }
    
}
