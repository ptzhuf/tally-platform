/**
 * 
 */
package org.ringr.tally.exception;

/**
 * @author ptzhuf
 *
 */
public class RestBizException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 3642527388287430419L;

    public RestBizException() {
    }

    public RestBizException(String msg) {
        super(msg);
    }

    public RestBizException(String msg, Throwable e) {
        super(msg, e);
    }
}
