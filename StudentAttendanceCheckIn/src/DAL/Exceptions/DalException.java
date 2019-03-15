/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Exceptions;

/**
 *
 * @author bonde
 */
public class DalException extends Exception
{
    /**
     * A cunstructor of the exception class MTDalException
     */
    public DalException() 
    {
        super();
    }
    
    /**
     * A cunstructor of the exception class MTDalException class. 
     * Throws a message if an exception has been catched
     * @param message the message getting thrown
     */
    public DalException(String message)
    {
        super(message);
    }
    
    /**
     * A cunstructor of the exception class MTDalExceptio class.
     * Throws a message and the exception if an exception has been catched
     * @param message the message getting thrown
     * @param ex the exception getting thrown
     */
    public DalException(String message, Exception ex)
    {
        super(message, ex);
    }    
}
