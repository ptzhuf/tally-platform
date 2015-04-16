/**
 * 
 */
package org.ringr.tally.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ringr.tally.TallyWebApplication;
import org.ringr.tally.po.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author ptzhuf
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TallyWebApplication.class)
@WebAppConfiguration
public class UserServiceTest {

	@Autowired
	private UserService userService;

	/**
	 * Test method for
	 * {@link org.ringr.tally.service.UserService#save(java.lang.String, java.lang.String, java.util.List)}
	 * .
	 */
	@Test
	public final void testSave() {
		List<Role> roles = new ArrayList<Role>();
		Role e = new Role();
		String rolename = "ROLE_ADMIN";
		e.setRolename(rolename);
		roles.add(e);
		String password = new ShaPasswordEncoder().encodePassword("123456",
				null);
		String name = "ptzhuf";
		userService.save(name, password, roles);
	}

}
