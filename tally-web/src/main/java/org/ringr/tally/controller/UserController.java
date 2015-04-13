package org.ringr.tally.controller;

import org.ringr.tally.dto.UserDetail;
import org.ringr.tally.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户.
 * 
 * @author ptzhuf
 *
 */
@Controller
public class UserController {

	/**
	 * logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public @ResponseBody UserDetail get(@PathVariable String name) {
		LOG.debug("获取用户信息:{}", name);
		UserDetail result = userService.get(name);
		return result;
	}
	
}
