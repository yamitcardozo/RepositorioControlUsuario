/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlException;

import org.apache.log4j.Logger;

/**
 *
 * @author Administrator2
 */
public class ExceptionFlujo extends Exception {

    private Logger log = Logger.getLogger(ExceptionFlujo.class);

    public ExceptionFlujo(Throwable cause) {
        super(cause);
        log.error(cause.getMessage(),cause);
    }

    public ExceptionFlujo(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public ExceptionFlujo(String message) {
        super(message);
        log.error(message,this);
    }

    public ExceptionFlujo() {
        log.error(this.getMessage(),this);
    }

    
}
