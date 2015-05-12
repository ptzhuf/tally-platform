/**
 * 
 */
package org.ringr.tally.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ringr.tally.TallyWebApplication;
import org.ringr.tally.po.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author ptzhuf
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TallyWebApplication.class)
@WebAppConfiguration
public class RoleServiceTest {

	@Autowired
	private RoleService roleService;

	@Test
	public void testSave() throws Exception {

		String rolename = "ROLE_ADMIN";
		Role role = roleService.save(rolename);
		System.out.println(role);
	}
}
