package com.airchina.searchorder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.airchina.searchorder.model.SearchOrder;
import com.airchina.searchorder.service.ISearchOrderService;
import com.alibaba.fastjson.JSON;
import com.fes.common.mvc.model.JsonMes;
import com.fes.test.model.Test;

@Controller
public class SearchOrderController {

	@Resource(name = "searchOrderServiceImpl")
	private ISearchOrderService isos;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView system(HttpServletRequest request, HttpSession session, Test tt) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("search_order");
		return mav;
	}
	
	

	
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		String orderNo = request.getParameter("order_no");
		if(orderNo != null){
			List<SearchOrder> sList = isos.searchOrderListByAll();
			model.addAttribute("sList", sList );
			System.out.println(sList.get(0).getUSER_ID());
		}
		
		return "search_order";
	}
	
	
	
	
	
}
