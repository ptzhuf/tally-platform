/**
 * 
 */
package org.ringr.tally.exception;


/**
 * @author ptzhuf
 *
 */
public class CommonException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3234786803646925544L;

	public CommonException() {
	}

	public CommonException(String message, Exception e) {
		super(message, e);
	}

	public CommonException(String message) {
		super(message);
	}

	public CommonException(Exception e) {

	}

}
