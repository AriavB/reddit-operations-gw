package com.ariavbar.redditoperationsgw;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ariavbar.redditoperationsgw.controller.RedditOperationsController;

@SpringBootTest
class RedditOperationsGwApplicationTests {

	@Autowired
	private RedditOperationsController redditOperationsController;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void getUserIdentityTest() {
		String result = null;
				try {
					result = redditOperationsController.getUserIdentity();
				} catch(Exception e) {
					e.getMessage();
					e.getCause();
				}
		assertNotNull(result);
	}

}
