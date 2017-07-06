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
public class ItemPercuException extends RuntimeException {
    public ItemPercuException(String message) {
        super(message);
    }

    public ItemPercuException(Throwable cause) {
        super(cause);
    }

    public ItemPercuException(String message , Throwable ex) {
        super(message,ex);
    }
    
}
