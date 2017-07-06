/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centellas.nil;

/**
 *
 * @author Nil
 */
public class SortidaException extends RuntimeException {
    public SortidaException(String message) {
        super(message);
    }

    public SortidaException(Throwable cause) {
        super(cause);
    }

    public SortidaException(String message , Throwable ex) {
        super(message,ex);
    }
    
}