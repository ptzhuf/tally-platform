/**
 * 
 */
package org.ringr.tally.service;

import org.ringr.tally.dto.UserDetail;
import org.ringr.tally.po.User;
import org.ringr.tally.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ptzhuf
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userReposiotry;

	/**
	 * 获取用户.
	 * 
	 * @param name
	 * @return
	 */
	public UserDetail get(String name) {
		User user = userReposiotry.findByName(name);
		UserDetail result = new UserDetail();
		BeanUtils.copyProperties(user, result);
		return result;
	}

}
