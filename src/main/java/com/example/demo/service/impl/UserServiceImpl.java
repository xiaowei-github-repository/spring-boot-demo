package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserDetail(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int insertUser(User user) throws RuntimeException{
		int i = userMapper.insert(user);
		if (i == 1) {
			throw new RuntimeException();
		}
		return i;

	}

	@Override
	public PageBean<User> queryUserPage(int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<User> userList = userMapper.queryUserList();
		
		if(userList instanceof Page) {
			System.out.println("userList is page");
		}
		
		PageInfo<User> pageInfo = new PageInfo<>(userList);
		
		int totalNum = pageInfo.getPages();
		
		PageBean<User> pageBean = new PageBean<>(currentPage, pageSize, totalNum);
		pageBean.setItems(userList);
		
		return pageBean;
	}

}
