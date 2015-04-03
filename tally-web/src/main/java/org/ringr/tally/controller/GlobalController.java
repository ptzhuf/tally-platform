/**
 * 
 */
package org.ringr.tally.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ringr.tally.exception.CommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

/**
 * 全局控制器.
 * 
 * @author ptzhuf
 *
 */
@Controller
public class GlobalController {

	@Autowired
	private ThymeleafViewResolver resolver;

	/**
	 * logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(GlobalController.class);

	@RequestMapping(value = "**/*", method = RequestMethod.GET)
	public String indexLoc(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String loc = new StringBuilder(request.getRequestURI())
				.append("/index").toString();
		// // 判断是否能够定位出view, 不行的话会抛出异常
		// resolver.resolveViewName(loc, Locale.getDefault()).render(null,
		// request, response);
		throw new CommonException(loc);
		// LOG.info(loc);
		// return loc;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		LOG.info("index");
		throw new CommonException("index");
//		return "index";
	}

}
