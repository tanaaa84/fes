package com.airchina.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fes.test.model.Test;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView system(HttpServletRequest request, HttpSession session, Test tt) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	
	@RequestMapping(value = "/weixin", method = RequestMethod.GET)
	public ModelAndView weixin(HttpServletRequest request, HttpSession session, Test tt) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("weixin_share");
		return mav;
	}
	
	
	
}
