package com.airchina.flight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
public class QueryOftenAirline {

	private static final Logger log = LoggerFactory.getLogger(QueryOftenAirline.class);

	@ResponseBody
	@RequestMapping(value = "/oftenAirline", method = RequestMethod.POST)
	public void queryOftenAirline(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {
		
		log.info("11111");
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("orgCode", "PEK");
		map1.put("dstCode", "SHA");		
		
		
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("orgCode", "CAN");
		map2.put("dstCode", "PEK");		
		
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("orgCode", "PEK");
		map3.put("dstCode", "LAX");		
		
		
		ArrayList<Map<String, String>> alArrayList = new ArrayList<Map<String,String>>();
		
		alArrayList.add(map1);
		alArrayList.add(map2);
		alArrayList.add(map3);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("airline", alArrayList);
		
		String json = JSON.toJSONString(map);
		
		log.info(json);
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println(json);
		
	}
}
