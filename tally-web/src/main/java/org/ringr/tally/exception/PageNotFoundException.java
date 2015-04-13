/**
 * 
 */
package org.ringr.tally.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ptzhuf
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "没找到页面")
public class PageNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3234786803646925544L;

	public PageNotFoundException() {
	}

	public PageNotFoundException(String message, Exception e) {
		super(message, e);
	}

	public PageNotFoundException(String message) {
		super(message);
	}

	public PageNotFoundException(Exception e) {

	}

}
