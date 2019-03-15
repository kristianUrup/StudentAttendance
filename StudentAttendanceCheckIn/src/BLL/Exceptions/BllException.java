/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL.Exceptions;

/**
 *
 * @author bonde
 */
public class BllException extends Exception
{
    /**
     * A cunstructor of the exception class MTBllException
     */
    public BllException() 
    {
        super();
    }
    
    /**
     * A cunstructor of the exception class MTBllException class. 
     * Throws a message if an exception has been catched
     * @param message the message getting thrown
     */
    public BllException(String message)
    {
        super(message);
    }
    
    /**
     * A cunstructor of the exception class MTBllExceptio class.
     * Throws a message and the exception if an exception has been catched
     * @param message the message getting thrown
     * @param ex the exception getting thrown
     */
    public BllException(String message, Exception ex)
    {
        super(message, ex);
    }
}
