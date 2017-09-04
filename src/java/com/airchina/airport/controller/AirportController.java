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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(AirportController.class);

	
	@Resource(name = "queryAirportImpl")
	private IQueryAirport iQueryAirport;
	
	@ResponseBody
	@RequestMapping(value = "/airport", method = RequestMethod.POST)
	public void queryAirport(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {
		
		
		List<Airport> airportList = iQueryAirport.queryAirports();
		
		System.out.println(airportList.size());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("body", airportList);
		
		String json = JSON.toJSONString(map);
		
		log.info(json);
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println(json);
		
	}
	
}