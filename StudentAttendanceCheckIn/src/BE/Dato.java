/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.util.Date;

/**
 *
 * @author Frederik Jensen
 */
public class Dato
{
    private int id;
    private Date date;
    private String day;
    private boolean isAbsent;

    public Dato(int id, Date date, String day)
    {
        this.id = id;
        this.date = date;
        this.day = day;
    }
    
    public Dato(int id, Date date, String day, boolean isAbsent) {
        this.id = id;
        this.date = date;
        this.day = day;
        this.isAbsent = isAbsent;
    }


    
    public int getId()
    {
        return id;
    }

    public Date getDate()
    {
        return date;
    }

    public String getDay()
    {
        return day;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public void setDay(String day)
    {
        this.day = day;
    }

    public boolean isIsAbsent()
    {
        return isAbsent;
    }

    public void setIsAbsent(boolean isAbsent)
    {
        this.isAbsent = isAbsent;
    }
    
    
    
    
}
