package com.airchina.airport.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airchina.airport.model.Airport;
import com.airchina.airport.service.IQueryAirport;
import com.alibaba.fastjson.JSON;

@Controller
public class AirportController {
	Logger   log=Logger.getLogger(this.getClass().getName()); 
	
	@Resource(name = "queryAirportImpl")
	private IQueryAirport iQueryAirport;
	
	@ResponseBody
	@RequestMapping(value = "/airport", method = RequestMethod.POST)
	public void queryAirport(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {
		
		
		List<Airport> airportList = iQueryAirport.queryAirports();
		
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("airport", airportList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("body", map0);
		
		String json = JSON.toJSONString(map);
		
		log.info(json);
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println(json);
		
	}
	
}
