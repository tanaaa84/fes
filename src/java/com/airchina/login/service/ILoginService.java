package com.airchina.login.service;

import java.util.List;

import com.airchina.login.model.User;


public interface ILoginService {
		public List<User> login(String username, String password);
		public List<User> login(String userID);
	
}
