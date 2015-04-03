/**
 * 
 */
package org.ringr.tally.controller;

import javax.servlet.http.HttpServletRequest;

import org.ringr.tally.exception.CommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理.
 * 
 * @author ptzhuf
 *
 */
@ControllerAdvice
public class ExcecptionHandlingController {

	/**
	 * logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(ExcecptionHandlingController.class);

	@ExceptionHandler(CommonException.class)
	public String handlingNotFound(HttpServletRequest req, Exception exception,
			Model model) {
		LOG.error("Request: " + req.getRequestURL() + " raised " + exception);

		model.addAttribute("exception", exception);
		model.addAttribute("url", req.getRequestURL());
		return "error/404";
	}
}
