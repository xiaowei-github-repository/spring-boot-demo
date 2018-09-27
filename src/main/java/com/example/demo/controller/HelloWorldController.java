package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

	@Autowired
	private UserService userService;

	@GetMapping("/hi")
	public String helloWorld() {

		return "helloWorld";

	}

	@GetMapping("/userInfo/{id}")
	public User queryUserDetail(@PathVariable("id") Long id) {
		return userService.queryUserDetail(id);
	}

	@PostMapping("/userInfo/add")
	public int addUserInfo(@RequestBody User user) throws Exception {
		return userService.insertUser(user);
		
	}

}
