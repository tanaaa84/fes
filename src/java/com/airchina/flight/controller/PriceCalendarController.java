package com.airchina.flight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airchina.util.AccessToHttp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
public class PriceCalendarController {

	private static final Logger log = (Logger) LoggerFactory
			.getLogger(PriceCalendarController.class);
	
	
	@ResponseBody
	@RequestMapping(value = "/priceCalendar", method = RequestMethod.POST)
	public void priceCalendar(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {
		String url = "http://10.9.242.18:9081/airchina/ACEInfomation/getACECalendar.do";

		log.info(body);

		JSONObject jsonObj = JSON.parseObject(body);
		String req = jsonObj.getString("request");
		
		
		NameValuePair[] vars = { new NameValuePair("req", req) };

		String response = AccessToHttp.getPostResponse(url, vars);
		
		log.info(response);
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println(response);
		
		
	}
	
	
	
}
