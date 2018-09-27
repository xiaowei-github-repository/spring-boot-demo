package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.utils.PageBean;

public interface UserService {

	public User queryUserDetail(Long id);

	public int insertUser(User user) throws RuntimeException;
	
	
	public PageBean<User> queryUserPage(int currentPage,int pageSize);

}
