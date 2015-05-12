/**
 * 
 */
package org.ringr.tally.controller.admin;

import java.util.Arrays;

import org.ringr.tally.exception.RestBizException;
import org.ringr.tally.po.Role;
import org.ringr.tally.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ptzhuf
 *
 */
@Controller
public class RoleAdminController {

	/**
	 * logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(RoleAdminController.class);
	@Autowired
	private RoleService roleService;

	/**
	 * 新增角色.
	 * 
	 * @param rolename
	 *            角色串
	 * @return
	 */
	@RequestMapping(value = "/admin/role", method = RequestMethod.POST)
	public @ResponseBody Role saveRole(String rolename) {

		try {
			Role result = roleService.save(rolename);
			return result;
		} catch (Exception e) {
			String msg = "调用saveRole出错 : {" + e.getMessage() + "}";
			String errMsg = new StringBuilder(msg).append(", 请求参数为:[{}]")
					.toString();
			LOG.error(errMsg, Arrays.asList(new Object[] { rolename }));
			LOG.error("错误信息:", e);
			throw new RestBizException(msg, e);
		}
	}
}
