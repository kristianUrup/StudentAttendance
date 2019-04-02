/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentattendancecheckin;

import BLL.DateManager;
import BLL.Exceptions.BllException;
import DAL.DateDAO;
import DAL.Exceptions.DalException;



/**
 *
 * @author bonde
 */
public class Testermain
{
    public static void main(String[] args) throws BllException, DalException 
    {
        DateManager d = new DateManager();
        d.absenseCalculator(1);
    }
}
