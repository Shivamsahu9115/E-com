package com.ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.ValidationUtils;

import com.ecomm.bean.LoginBean;
import com.ecomm.dao.UserDao;
import com.ecomm.entity.User;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDao dao;
	
	public void saveUser(User user) {
		
		this.dao.saveUser(user );
	}
	
	public void login(LoginBean user) {
		
		
		
	User u=	this.dao.auth(user);
	
	System.out.println(u);
	
	}
}
