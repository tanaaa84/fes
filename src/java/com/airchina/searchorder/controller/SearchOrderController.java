package com.airchina.searchorder.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.airchina.searchorder.service.ISearchOrderService;
import com.fes.test.model.Test;

@Controller
public class SearchOrderController {

	@Resource(name = "searchOrderServiceImpl")
	private ISearchOrderService isos;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView system(HttpServletRequest request, HttpSession session, Test tt) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("search_order");
		return mav;
	}
	
	
}
