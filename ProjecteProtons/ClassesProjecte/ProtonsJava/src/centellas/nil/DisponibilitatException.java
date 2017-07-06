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
public class DisponibilitatException extends RuntimeException {
    public DisponibilitatException(String message) {
        super(message);
    }

    public DisponibilitatException(Throwable cause) {
        super(cause);
    }

    public DisponibilitatException(String message , Throwable ex) {
        super(message,ex);
    }
}
