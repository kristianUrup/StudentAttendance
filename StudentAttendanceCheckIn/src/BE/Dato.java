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


    /**
     * returns id of Dato
     * @return id
     */
    public int getId()
    {
        return id;
    }

    /**
     * returns the date
     * @return date
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * returns the day 
     * @return day
     */
    public String getDay()
    {
        return day;
    }

    /**
     * Sets the date
     * @param date 
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * Sets the day
     * @param day 
     */
    public void setDay(String day)
    {
        this.day = day;
    }

    /**
     * Returns absent of the day
     * @return isAbsent
     */
    public boolean getIsAbsent()
    {
        return isAbsent;
    }

    /**
     * Sets the to is absent or not
     * @param isAbsent 
     */
    public void setIsAbsent(boolean isAbsent)
    {
        this.isAbsent = isAbsent;
    }
    
    
    
    
}
