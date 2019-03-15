/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Klasse;
import java.util.List;

/**
 *
 * @author bonde
 */
public class ClassDAO implements ClassInterface
{
    private final ConnectionDAO cd;

    
    /**
     * Constructor of Class DAO. Instantiates the connection to the database.
     * 
     * @param cd 
     */
    public ClassDAO(ConnectionDAO cd)
    {
        this.cd = cd;
    }

    @Override
    public List<Klasse> getAllClasses()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
