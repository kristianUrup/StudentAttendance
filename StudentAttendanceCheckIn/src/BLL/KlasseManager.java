/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Klasse;
import DAL.ClassDAO;
import java.util.List;

/**
 *
 * @author bonde
 */
public class KlasseManager
{
    ClassDAO cdao;

    public KlasseManager(ClassDAO cdao)
    {
        this.cdao = cdao;
    }
    
    public List<Klasse> getAllClasses()
    {
        return cdao.getAllClasses();
    }
}
