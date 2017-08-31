package com.airchina.searchorder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
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
	
	
	
	@RequestMapping(value = "/paymentRate", method = RequestMethod.GET)
	public void paymentRate(Locale locale, Model model, HttpServletRequest request, HttpServletResponse res) throws IOException {
		
		String date = request.getParameter("date");
		
		System.out.println("-----------" + date);
		
		String allPayOrder = isos.searchPaymentRateByDate(date, "");
		String successPayOrder = isos.searchPaymentRateByDate(date, "1");
		System.out.println(allPayOrder);
		System.out.println(successPayOrder);
			
		float payRate =	Float.parseFloat(successPayOrder)/Float.parseFloat(allPayOrder);
		
		System.out.println(payRate);
		
		PrintWriter out = res.getWriter();
		out.println("Pay for all:  " + allPayOrder);
		out.println("Pay for success:  " + successPayOrder);
		out.println("The success rate:  " + payRate);
		URLEncoder.encode("URL","utf-8");
	}
	
	
	
	
}
