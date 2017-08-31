package com.airchina.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fes.test.model.Test;

@Controller
public class AirportController {

	
	
	@RequestMapping(value = "/queryAirport", method = RequestMethod.POST)
	public ModelAndView system(HttpServletRequest request, HttpSession session, Test tt) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("search_order");
		return mav;
	}
	
}
