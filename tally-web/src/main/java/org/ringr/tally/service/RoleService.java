/**
 * 
 */
package org.ringr.tally.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.ringr.tally.exception.NotUniqueException;
import org.ringr.tally.po.Role;
import org.ringr.tally.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ptzhuf
 *
 */
@Service
public class RoleService {

	/**
	 * logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(RoleService.class);

	@Autowired
	private RoleRepository roleRepository;

	/**
	 * 根据角色名查找角色.
	 * 
	 * @return Role
	 */
	public Role findByRolename(String rolename) {
		return roleRepository.findByRolename(rolename);
	}

	/**
	 * 保存角色.
	 * 
	 * @param rolename
	 *            角色名
	 * @return 返回角色对象
	 * @throws Exception
	 *             Exception
	 */
	public Role save(String rolename) throws Exception {
		// 校验rolename
		if (StringUtils.isBlank(rolename)) {
			String msg = "角色名不能为空";
			LOG.error(msg);
			throw new Exception(msg);
		}
		// 检查rolename师傅哦存在, 因为save相当于saveOrUpdate, 不会检查唯一性约束
		Role roleCheck = roleRepository.findByRolename(rolename);
		if (roleCheck != null) {
			String msg = "roleCheck : [" + roleCheck + "]已经存在";
			LOG.error(msg);
			throw new NotUniqueException(msg);
		}
		Role entity = new Role();
		entity.setRolename(rolename);
		entity = roleRepository.save(entity);
		return entity;
	}

	/**
	 * 查找全部.
	 * 
	 * @return
	 */
	public List<Role> findAll() {
		return (List<Role>) roleRepository.findAll();
	}

}
