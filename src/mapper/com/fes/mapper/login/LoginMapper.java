package com.fes.mapper.login;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.airchina.login.model.User;

@Service("loginMapper")
public interface LoginMapper {

	public List<User> login(@Param(value = "userName") String username, @Param(value = "password") String password);

	public List<User> loginByUserID(@Param(value = "userID") String userID);

}
