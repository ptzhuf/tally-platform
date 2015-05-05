/**
 * 
 */
package org.ringr.tally.controller.admin;

import java.util.List;

import org.ringr.tally.dto.UserDetail;
import org.ringr.tally.po.Role;
import org.ringr.tally.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理接口.
 * 
 * @author ptzhuf
 *
 */
@Controller
public class UserAdminController {

	/**
	 * logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(UserAdminController.class);

	@Autowired
	private UserService userService;

	/**
	 * 保存用户信息.
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param roles
	 *            角色列表
	 * @return 用户信息
	 */
	@RequestMapping(value = "/admin/user", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public @ResponseBody UserDetail saveUser(String username, String password,
			List<Role> roles) {
		LOG.info("调用创建用户{}, 角色:{}", username, roles);
		UserDetail result = userService.save(username, password, roles);
		return result;
	}

	@RequestMapping(value = "/admin/user", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public String index(Model model) {
		List<UserDetail> userList = userService.findAllUserDetail();
		// TODO 查询用户列表
		// 添加用户列表到model上下文
		model.addAttribute("userList", userList);
		return "admin/user/index";
	}
}
