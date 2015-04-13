/**
 * 
 */
package org.ringr.tally.controller;

import javax.servlet.http.HttpServletRequest;

import org.ringr.tally.exception.PageNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

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

	@ExceptionHandler(PageNotFoundException.class)
	public ModelAndView handlingNotFound(HttpServletRequest req,
			Exception exception) {
		LOG.error("Request: " + req.getRequestURL() + " raised " + exception);
		ModelAndView view = new ModelAndView("error/404");
		ModelMap model = view.getModelMap();
		model.addAttribute("exception", exception);
		model.addAttribute("url", req.getRequestURL());
		return view;
	}
}
