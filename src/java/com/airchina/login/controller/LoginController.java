package com.airchina.login.controller;

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

import sun.tools.tree.ThisExpression;

import com.airchina.login.model.User;
import com.airchina.login.service.ILoginService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
public class LoginController {

	@Resource(name = "loginServiceImpl")
	private ILoginService iLoginService;

	private static final Logger log = (Logger) LoggerFactory.getLogger(LoginController.class);

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public ModelAndView system(HttpServletRequest request, HttpSession
	// session, Test tt) {
	// ModelAndView mav = new ModelAndView();
	// mav.setViewName("login");
	// return mav;
	// }
	//
	//
	// @RequestMapping(value = "/weixin", method = RequestMethod.GET)
	// public ModelAndView weixin(HttpServletRequest request, HttpSession
	// session, Test tt) {
	// ModelAndView mav = new ModelAndView();
	// mav.setViewName("weixin_share");
	// return mav;
	// }

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(Locale locale, Model model, HttpServletRequest request,
			HttpServletResponse res, @RequestBody String body)
			throws IOException {

		log.info(body);

		JSONObject jsonObj = JSON.parseObject(body);
		JSONObject data = (JSONObject) jsonObj.get("request");
		String username = data.getString("username");
		String password = data.getString("password");

		if (username != null && !password.isEmpty() && password != null
				&& !password.isEmpty()) {

			List<User> user = iLoginService.login(username, password);
			if (user.size() > 0) {
				Map<String, String> status = new HashMap<String, String>();
				status.put("code", "0");
				status.put("msg", "");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("status", status);
				map.put("body", user.get(0));
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
