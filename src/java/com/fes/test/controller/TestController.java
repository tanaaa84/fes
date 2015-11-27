package com.fes.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fes.common.mvc.model.JsonMes;
import com.fes.test.model.Test;
import com.fes.test.service.TestService;

@Controller
public class TestController {

	@Resource(name = "testServiceImpl")
	private TestService ts;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView system(HttpServletRequest request, HttpSession session, Test tt) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("index");
		return mav;
	}

	@RequestMapping(value = "testAddAction", method = RequestMethod.POST)
	public void testAddAction(HttpServletRequest req, HttpServletResponse res, HttpSession session, Test tt) throws IOException {
		res.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();

		JsonMes jm = new JsonMes();

		int flag = ts.testAdd(tt);
		System.out.println("testAddAction1");

		if (flag > 0) {
			jm.setStatus("ok");
		}

		String jsonStr = JSON.toJSONString(jm);
		out.print(jsonStr);
	}

	@RequestMapping(value = "testAddAction2", method = RequestMethod.POST)
	public void testAddAction2(HttpServletRequest req, HttpServletResponse res, HttpSession session, Test tt) throws IOException {
		res.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();

		JsonMes jm = new JsonMes();

		int flag = ts.testAdd(tt);
		System.out.println("testAddAction2");

		if (flag > 0) {
			jm.setStatus("ok");
		}

		String jsonStr = JSON.toJSONString(jm);
		out.print(jsonStr);
	}
}
