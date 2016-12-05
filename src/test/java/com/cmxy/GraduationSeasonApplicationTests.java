package com.cmxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cmxy.util.SMSUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GraduationSeasonApplication.class)
@WebAppConfiguration
public class GraduationSeasonApplicationTests {

	@Test
	public void contextLoads() {
		SMSUtil.send("13777859681", "123456");
	}

}
