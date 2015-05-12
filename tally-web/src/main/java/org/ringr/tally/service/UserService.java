/**
 * 
 */
package org.ringr.tally.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.ringr.tally.dto.UserDetail;
import org.ringr.tally.exception.NotExistException;
import org.ringr.tally.exception.NotUniqueException;
import org.ringr.tally.po.Role;
import org.ringr.tally.po.User;
import org.ringr.tally.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ptzhuf
 *
 */
@Service
public class UserService implements UserDetailsService {

	/**
	 * logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleService roleService;

	/**
	 * 获取用户.
	 * 
	 * @param name
	 * @return
	 */
	public UserDetail get(String name) {
		User user = userRepository.findByName(name);
		UserDetail result = new UserDetail();
		BeanUtils.copyProperties(user, result);
		return result;
	}

	/**
	 * 保存用户.
	 * 
	 * @param name
	 *            用户名
	 * @param password
	 *            用户密码
	 * @param roles
	 *            角色集
	 * @return 用户信息
	 * @throws NotUniqueException
	 *             NotUniqueException
	 * @throws NotExistException
	 *             NotExistException
	 */
	public UserDetail save(String name, String password, List<Role> roles)
			throws NotUniqueException, NotExistException {
		LOG.info("创建用户 : {}, 角色 : {}", name, roles);
		// 检查用户重名
		User userCheck = userRepository.findByName(name);
		if (userCheck != null) {
			String msg = "用户[" + name + "]重名";
			LOG.error(msg);
			throw new NotUniqueException(msg);
		}
		// 检查角色是否存在
		for (Role role : roles) {
			String rolename = role.getRolename();
			if (StringUtils.isBlank(rolename)) {
				roles.remove(role);
			} else {
				// 检查角色存在
				Role roleCheck = roleService.findByRolename(rolename);
				if (roleCheck == null) {
					String msg = "角色[" + rolename + "]不存在";
					LOG.error(msg);
					throw new NotExistException(msg);
				}
			}
		}

		User user = new User();
		user.setName(name);
		String sha1Password = new ShaPasswordEncoder().encodePassword(password,
				null);
		user.setPassword(sha1Password);
		user.setRoles(roles);
		user = userRepository.save(user);
		UserDetail detail = new UserDetail();
		BeanUtils.copyProperties(user, detail);
		return detail;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		UserDetails userDetails = null;
		if (user != null) {
			List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			List<Role> roles = user.getRoles();
			if (roles != null) {
				for (Role role : roles) {
					SimpleGrantedAuthority e = new SimpleGrantedAuthority(
							role.getRolename());
					authorities.add(e);
				}
			}
			String password = user.getPassword();
			userDetails = new org.springframework.security.core.userdetails.User(
					username, password, authorities);
		}
		return userDetails;
	}

	/**
	 * 用户列表.
	 * 
	 * @return
	 */
	public List<UserDetail> findAllUserDetail() {
		Iterable<User> userList = userRepository.findAll();
		List<UserDetail> userDetailList = null;
		if (userList != null && userList != null) {
			userDetailList = new ArrayList<>();
			for (User user : userList) {
				UserDetail userDetail = new UserDetail();
				BeanUtils.copyProperties(user, userDetail);
				userDetailList.add(userDetail);
			}
		}
		return userDetailList;
	}
}
