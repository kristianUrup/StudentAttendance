/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Klasse;
import DAL.Exceptions.DalException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public List<Klasse> getAllClasses() throws DalException
    {
        List<Klasse> klasser = new ArrayList<>();
        
        try(Connection con = cd.getConnection()){
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Klasse;");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("klassename");
                
                Klasse klasse = new Klasse(id, name);
                klasser.add(klasse);
            }
            
        }catch(SQLException ex){
            throw new DalException("Could not get all classes: " + ex.getMessage());
        }
        return klasser;
    }
}
