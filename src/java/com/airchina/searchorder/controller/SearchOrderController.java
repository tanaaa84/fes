package com.airchina.searchorder.controller;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.airchina.searchorder.model.SearchOrder;
import com.airchina.searchorder.service.ISearchOrderService;
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
		if(orderNo != null && !orderNo.isEmpty()){
			List<SearchOrder> sList = isos.searchOrderListByOrderNo(orderNo);
			model.addAttribute("sList", sList );
			System.out.println("1");
		}else {
			List<SearchOrder> sList = isos.searchOrderListByAll();
			model.addAttribute("sList", sList );
			System.out.println("n");
		}
		
		return "search_order";
	}
	
	
	
	
	
}
