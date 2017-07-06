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
public class PeticioException extends RuntimeException {
    public PeticioException(String message) {
        super(message);
    }

    public PeticioException(Throwable cause) {
        super(cause);
    }

    public PeticioException(String message , Throwable ex) {
        super(message,ex);
    }
}
