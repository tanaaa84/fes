package com.airchina.coupon.controller;

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

import com.airchina.coupon.model.Coupon;
import com.airchina.coupon.service.ICouponService;
import com.airchina.login.model.User;
import com.airchina.login.service.ILoginService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
public class CouponController {

	Logger   log=Logger.getLogger(this.getClass().getName()); 

	@Resource(name = "couponServiceImpl")
	private ICouponService iCouponService;
	
	@Resource(name = "loginServiceImpl")
	private ILoginService iLoginService;

	
	@ResponseBody
	@RequestMapping(value = "/queryCoupon", method = RequestMethod.POST)
	public void queryCoupon(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {
		
		log.info(body);

		JSONObject jsonObj = JSON.parseObject(body);
		JSONObject data = (JSONObject) jsonObj.get("request");
		String userID = data.getString("userID");
		String status = data.getString("status");
		
		if (userID != null && !userID.isEmpty() ) {
			List<Coupon> couponList = iCouponService.queryCoupon(userID, status);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("body", couponList);
			Map<String, String> status1 = new HashMap<String, String>();
			status1.put("code", "0");
			status1.put("msg", "");
			map.put("status", status1);
			String json = JSON.toJSONString(map);
			
			log.info(json);
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/json;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println(json);
			
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/useCoupon", method = RequestMethod.POST)
	public void useCoupon(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {
		log.info(body);

		JSONObject jsonObj = JSON.parseObject(body);
		JSONObject data = (JSONObject) jsonObj.get("request");
		String userID = data.getString("userID");
		String couponCode = data.getString("couponCode");
		String actionCode = data.getString("actionCode");
		
		if (userID != null && !userID.isEmpty() &&couponCode != null && !couponCode.isEmpty() &&actionCode != null && !actionCode.isEmpty() ) {
			List<Coupon> couponList = iCouponService.queryCoupon(userID, null);
			for (int i = 0; i < couponList.size(); i++) {
				Coupon cpn = couponList.get(i);
				if (cpn.getCouponCode().equals(couponCode)) {
					if(cpn.getStatus() == 1 && actionCode.equals("1")){//未使用时   先冻结
						iCouponService.useCoupon(userID, actionCode, couponCode);
						break;
					}
					
					if(cpn.getStatus() == 3 && actionCode.equals("2")){//未使用时   先冻结
						iCouponService.useCoupon(userID, actionCode, couponCode);
						break;
					}
					
					if(cpn.getStatus() == 3 && actionCode.equals("3") ){//不可用时   可以改为使用
						iCouponService.useCoupon(userID, actionCode, couponCode);
						break;
					}
				}
			}
			
			List<Coupon> couponList1 = iCouponService.queryCoupon(userID, null);
			Coupon cpn = null;
			for (int i = 0; i < couponList1.size(); i++) {
				String cpnCode = couponList1.get(i).getCouponCode();
				if (cpnCode.equals(couponCode)) {
					cpn = couponList1.get(i);
					break;
				}
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("body", cpn);
			Map<String, String> status = new HashMap<String, String>();
			status.put("code", "0");
			status.put("msg", "");
			map.put("status", status);
			String json = JSON.toJSONString(map);
			
			log.info(json);
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/json;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println(json);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/couponGrant", method = RequestMethod.POST)
	public void couponGrant(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {
	
		log.info(body);

		JSONObject jsonObj = JSON.parseObject(body);
		JSONObject data = (JSONObject) jsonObj.get("request");
		String userID = data.getString("userID");
		String productCode = data.getString("productCode");

		List<User> userList =  iLoginService.login(userID);

		if (userList.size() > 0) {
			
			iCouponService.addCoupon(userID, productCode);
			List<Coupon> couponList = iCouponService.queryCoupon(userID, "1");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("body", couponList);
	
			Map<String, String> status = new HashMap<String, String>();
			status.put("code", "0");
			status.put("msg", "");
			map.put("status", status);
			
			String json = JSON.toJSONString(map);
			
			log.info(json);
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/json;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println(json);
		}
	}
}
