/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author bonde
 */
public class Klasse
{
    private int id;
    private String name;

    /**
     * Constructor of Class. Instantiate ClassID and name of class.
     * 
     * @param id
     * @param name 
     */
    public Klasse(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
     
    /**
     * Returns ID of class.
     * @return 
     */
    public int getId()
    {
        return id;
    }

    /**
     * Returns name of class.
     * @return 
     */
    public String getName()
    {
        return name;
    }
}
