/**
 * 
 */
package org.ringr.tally.exception;

/**
 * 不唯一异常.
 * @author ptzhuf
 *
 */
public class NotUniqueException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 3642527388287430419L;

    public NotUniqueException() {
    }

    public NotUniqueException(String msg) {
        super(msg);
    }

    public NotUniqueException(String msg, Throwable e) {
        super(msg, e);
    }
}
