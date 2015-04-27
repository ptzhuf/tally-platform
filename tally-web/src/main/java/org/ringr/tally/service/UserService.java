/**
 * 
 */
package org.ringr.tally.service;

import java.util.ArrayList;
import java.util.List;

import org.ringr.tally.dto.UserDetail;
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
	 */
	public UserDetail save(String name, String password, List<Role> roles) {
		LOG.info("创建用户 : {}, 角色 : {}", name, roles);
		// TODO 检查用户重名
		// TODO 检查角色是否允许被分配

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
}
