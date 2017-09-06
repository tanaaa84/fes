package com.airchina.login.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.airchina.login.model.User;
import com.airchina.login.service.ILoginService;
import com.fes.mapper.login.LoginMapper;


@Service("loginServiceImpl")
public class LoginServiceImpl implements ILoginService {

	
	@Resource(name = "loginMapper")
	private LoginMapper lm;
	

	
	@Override
	public List<User> login(String username, String password) {
		// TODO Auto-generated method stub
		return lm.login(username, password);
	}

	
	@Override
	public List<User> login(String userID) {
		// TODO Auto-generated method stub
		return lm.loginByUserID(userID);
	}
	
	
}
