package com.airchina.mileage.controller;

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

import com.airchina.airport.controller.AirportController;
import com.airchina.mileage.model.Mileage;
import com.airchina.mileage.service.IMileageService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
public class MileageController {

	private static final Logger log = LoggerFactory
			.getLogger(AirportController.class);

	@Resource(name = "mileageServiceImpl")
	private IMileageService iMileageService;

	/**
	 * 里程查询
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param res
	 * @param body
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/mileageInquiry", method = RequestMethod.POST)
	public void mileageInquiry(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {

		log.info(body);

		JSONObject jsonObj = JSON.parseObject(body);
		JSONObject data = (JSONObject) jsonObj.get("request");
		String userID = data.getString("userID");

		if (userID != null && !userID.isEmpty()) {
			List<Mileage> mileageList = iMileageService.mileageInquiry(userID);

			if (mileageList.size() > 0) {
				Map<String, String> status = new HashMap<String, String>();
				status.put("code", "0");
				status.put("msg", "");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("status", status);
				map.put("body", mileageList.get(0));
				String jsonString = JSON.toJSONString(map);
				log.info(jsonString);

				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/json;charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println(jsonString);
			}
		}
	}

	/**
	 * 里程累计
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param res
	 * @param body
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/mileageAccumulation", method = RequestMethod.POST)
	public void mileageAccumulation(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {
		
		log.info(body);

		JSONObject jsonObj = JSON.parseObject(body);
		JSONObject data = (JSONObject) jsonObj.get("request");
		String userID = data.getString("userID");
		String mileage = data.getString("mileage");

		if (userID != null && !userID.isEmpty()) {
					
			iMileageService.mileageAccumulation(mileage, userID);
			
			//TODO 操作记录
			List<Mileage> mileageList = iMileageService.mileageInquiry(userID);

			if (mileageList.size() > 0) {
				Map<String, String> status = new HashMap<String, String>();
				status.put("code", "0");
				status.put("msg", "");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("status", status);
				map.put("body", mileageList.get(0));
				String jsonString = JSON.toJSONString(map);
				log.info(jsonString);

				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/json;charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println(jsonString);
			}
		}
	}

	/**
	 * 里程扣减
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param res
	 * @param body
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/mileageDeduction", method = RequestMethod.POST)
	public void mileageDeduction(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {

		log.info(body);

		JSONObject jsonObj = JSON.parseObject(body);
		JSONObject data = (JSONObject) jsonObj.get("request");
		String userID = data.getString("userID");
		String mileage = data.getString("mileage");

		if (userID != null && !userID.isEmpty()) {
			iMileageService.mileageDeduction(mileage, userID);
			//TODO 操作记录
			List<Mileage> mileageList = iMileageService.mileageInquiry(userID);
			if (mileageList.size() > 0) {
				Map<String, String> status = new HashMap<String, String>();
				status.put("code", "0");
				status.put("msg", "");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("status", status);
				map.put("body", mileageList.get(0));
				String jsonString = JSON.toJSONString(map);
				log.info(jsonString);

				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/json;charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println(jsonString);
			}
		}
	}
}