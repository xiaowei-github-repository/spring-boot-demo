package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.conf.Configuration;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.PageBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Configuration configuration;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void queryUserList() {
		PageBean<User> page = userService.queryUserPage(1, 1);
		
		System.out.println(page);
	}

	
	@Test
	public void testConfiguration() {
		System.out.println(configuration.getName());
		System.out.println(configuration.getPassword());
	}
}
