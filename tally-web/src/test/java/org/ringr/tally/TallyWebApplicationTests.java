package org.ringr.tally;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ringr.tally.TallyWebApplication;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TallyWebApplication.class)
@WebAppConfiguration
public class TallyWebApplicationTests {

	@Test
	public void contextLoads() {
	}

}
