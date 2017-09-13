package com.airchina.flight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
public class DelayCertifyController {

	Logger   log=Logger.getLogger(this.getClass().getName()); 	
	
	@ResponseBody
	@RequestMapping(value = "/delayCertify", method = RequestMethod.POST)
	public void priceCalendar(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {
		
		JSONObject jsonObj = JSON.parseObject(body);
		JSONObject data = (JSONObject) jsonObj.get("request");
		String passengerName = data.getString("passengerName");
		String idNum = data.getString("idNum");
		String departDate = data.getString("departDate");
		String flightNo = data.getString("flightNo");
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("actualArrivalTime", "");
		
		map.put("actualArrivalTime", "");
		map.put("actualDepartTime", "");
		map.put("allow", "Y");
		map.put("departureDate", departDate);
		map.put("flightNum", flightNo);
		map.put("fromCityCN", "北京");
		map.put("fromCityEN", "BEIJING");
		map.put("language", "zh_CN");
		map.put("memo", "");
		map.put("psgID", idNum);
		map.put("psgName", passengerName);
		map.put("reason", "天气原因");
		map.put("scheduleArrivalTime", "2017-09-04 17:45");
		map.put("scheduleDepartTime", "2017-09-04 14:20");
		
		map.put("toCityCN", "深圳");
		map.put("toCityEN", "SHENZHENG");
		map.put("type", "");
		
		
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("body", map);
		
		String json = JSON.toJSONString(map0);

		
		
		log.info(json);
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println(json);
		
	}
	
	
	
	
}
