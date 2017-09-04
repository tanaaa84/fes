package com.airchina.flight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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

/**
 * 航班查询
 * 
 * @author tanyanbing
 *
 */
@Controller
public class QueryFlight {
	private static final Logger log = (Logger) LoggerFactory
			.getLogger(QueryFlight.class);

	/**
	 * 获取航班列表
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param res
	 * @param body
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/queryflightList", method = RequestMethod.POST)
	public void queryflightList(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {

		log.info(body);

		JSONObject jsonObj = JSON.parseObject(body);
		JSONObject data = (JSONObject) jsonObj.get("request");
		String org = data.getString("org");
		String dst = data.getString("dst");
		String adt = data.getString("adt");
		String cnn = data.getString("cnn");
		String date = data.getString("date");
		String backDate = data.getString("backDate");
		String flag = data.getString("flag");

		String url = "http://10.9.242.18:9081/airchina/ACEInfomation/getACEInfomation.do";
		String lang = "zh_CN";
		String userInfo1 = "41660";

		Map<String, String> map = new HashMap<String, String>();
		map.put("date", date);
		map.put("inf", "0");
		map.put("cnn", cnn);
		map.put("flag", flag);
		map.put("dst", dst);
		map.put("org", org);
		map.put("cabin", "Economy");
		map.put("version", "2");
		map.put("token", "11111111");
		map.put("adt", adt);
		map.put("mileageFlag", "0");
		map.put("backDate", backDate);
		map.put("acePageReq", "1");
		map.put("timestamp", System.currentTimeMillis() + "");

		String req = JSON.toJSONString(map);

		NameValuePair[] vars = { new NameValuePair("req", req),
				new NameValuePair("lang", lang),
				new NameValuePair("userInfo1", userInfo1) };

		String response = AccessToHttp.getPostResponse(url, vars);
		log.info(response);
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println(response);
	}

	/**
	 * 获取舱位
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param res
	 * @param body
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/queryflightDetail", method = RequestMethod.POST)
	public void queryflightDetail(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {

		log.info(body);
		JSONObject jsonObj = JSON.parseObject(body);
		JSONObject data = (JSONObject) jsonObj.get("request");
		String date = data.getString("date");
		String takeoffdate = data.getString("takeoffdate");
		String childNum = data.getString("childNum");
		String adultNum = data.getString("adultNum");
		String flag = data.getString("flag");
		String dst = data.getString("dst");
		String org = data.getString("org");
		String flightID = data.getString("flightID");
		String iszj = data.getString("iszj");
		String flightno = data.getString("flightno");
		String searchId = data.getString("searchId");
		String backDate = data.getString("backDate");
		String arrivedate = data.getString("arrivedate");
		String infantNum = "0";
		String acePageReq = "1";
		String airline = "CA";
		String mileageFlag = "0";
		String basePrice = data.getString("basePrice");

		String url = "http://10.9.242.18:9081/airchina/ACEInfomation/getACEFlightSpace.do";
		String lang = "zh_CN";
		String userInfo1 = "41600";

		Map<String, String> map = new HashMap<String, String>();

		map.put("date", date);
		map.put("takeoffdate", takeoffdate);
		map.put("childNum", childNum);
		map.put("adultNum", adultNum);
		map.put("flag", flag);
		map.put("org", org);
		map.put("dst", dst);
		map.put("flightID", flightID);
		map.put("iszj", iszj);
		map.put("flightno", flightno);
		map.put("searchId", searchId);
		map.put("backDate", backDate);
		map.put("arrivedate", arrivedate);
		map.put("infantNum", infantNum);
		map.put("acePageReq", acePageReq);
		map.put("airline", airline);
		map.put("mileageFlag", mileageFlag);
		map.put("basePrice", basePrice);

		String req = JSON.toJSONString(map);

		NameValuePair[] vars = { new NameValuePair("req", req),
				new NameValuePair("lang", lang),
				new NameValuePair("userInfo1", userInfo1) };

		String response = AccessToHttp.getPostResponse(url, vars);
		log.info(response);
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println(response);

	}

	public static void main(String[] args) {
		String url = "http://10.9.242.19:9093/airchina/ACEInfomation/getACEInfomation.do";
		String req = " {\"date\": \"2017-09-02\",\"inf\": \"0\",\"cnn\": \"0\",\"flag\": \"0\",\"dst\": \"SHA\",\"org\": \"PEK\",\"cabin\": \"Economy\",\"version\": \"2\",\"token\": \"11111111\",\"adt\": \"1\",\"mileageFlag\": \"0\",\"backDate\": \"\", \"acePageReq\": \"1\",\"timestamp\": \"1504229178393\"}";
		String lang = "zh_CN";
		String userInfo1 = "41760";

		NameValuePair[] vars = { new NameValuePair("req", req),
				new NameValuePair("lang", lang),
				new NameValuePair("userInfo1", userInfo1) };

		String response = AccessToHttp.getPostResponse(url, vars);

		System.out.println(response);

	}

}
