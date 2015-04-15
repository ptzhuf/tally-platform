/**
 * 
 */
package org.ringr.tally.controller;

import org.ringr.tally.po.User;
import org.ringr.tally.service.XiaofeiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * expense records, 老子就是不想用英文. 消费记录.
 * 
 * @author ptzhuf
 *
 */
@Controller
@SessionAttributes(value = "user")
public class XiaofeiController {

	/**
	 * logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(XiaofeiController.class);
	@Autowired
	private XiaofeiService xiaofeiService;

	/**
	 * 记录一笔消费.
	 * 
	 * @param time
	 *            时间戳
	 * @param amount
	 *            金额
	 * @param addr
	 *            地点
	 * @param desc
	 *            摘要
	 */
	@RequestMapping(value = "/xiaofei", method = RequestMethod.POST)
	public @ResponseBody void post(Long time, Double amount, String addr,
			String desc, @ModelAttribute User user) {

		LOG.info("用户{}记录消费", user.getName());
		xiaofeiService.save(amount, addr, desc, time, user);
	}
	

}
