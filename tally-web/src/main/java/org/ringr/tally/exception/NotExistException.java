/**
 * 
 */
package org.ringr.tally.exception;

/**
 * 不存在异常 .
 * @author ptzhuf
 *
 */
public class NotExistException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 5819673489457608785L;

    public NotExistException() {
    }

    public NotExistException(String msg) {
        super(msg);
    }

    public NotExistException(String msg, Throwable e) {
        super(msg, e);
    }
}
