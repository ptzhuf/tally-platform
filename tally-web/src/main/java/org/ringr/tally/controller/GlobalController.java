/**
 * 
 */
package org.ringr.tally.controller;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ringr.tally.exception.PageNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

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
	@Autowired
	private TemplateResolver thymeleafResolver;
	@Value("${spring.thymeleaf.prefix}")
	private String prefix;
	@Value("${spring.thymeleaf.suffix}")
	private String suffix;

	/**
	 * logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(GlobalController.class);

	@RequestMapping(value = "**/*", method = RequestMethod.GET)
	public String indexLoc(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String returnLoc = new StringBuilder(request.getRequestURI()).append(
				"/index").toString();
		String loc = new StringBuilder(prefix).append(returnLoc).append(suffix)
				.toString();
		// 判断是否存在对应的页面
		URL filePath = new PathMatchingResourcePatternResolver().getResource(
				loc).getURL();
		if (filePath != null) {
			return returnLoc;
		} else {
			String errorMsg = "index页面不存在, request path : {}, file path : {}";
			LOG.error(errorMsg, request.getRequestURI(), loc);
			throw new PageNotFoundException(loc);
		}

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		LOG.info("index");
		return "index";
	}

}
