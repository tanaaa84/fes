package com.airchina.flight.controller;

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

import com.airchina.login.model.User;
import com.airchina.login.service.ILoginService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
public class JourneyController {

	@Resource(name = "loginServiceImpl")
	private ILoginService iLoginService;

//	private static final Logger log = (Logger) LoggerFactory
//			.getLogger(QueryFlight.class);

	/**
	 * 获取行程列表
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param res
	 * @param body
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/queryJourney", method = RequestMethod.POST)
	public void queryflightList(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse res,
			@RequestBody String body) throws IOException {

//		log.info(body);
		
		Logger   logger=Logger.getLogger(this.getClass().getName()); 
		
		
		
		logger.info(body);

		JSONObject jsonObj = JSON.parseObject(body);
		JSONObject data = (JSONObject) jsonObj.get("request");
		String userID = data.getString("userID");

		if (userID != null && !userID.isEmpty()) {

			List<User> users = iLoginService.login(userID);
			if (users.size() > 0) {

				String xmlString = ""
						+ "{                                                                        "
						+ "    \"body\": {                                                          "
						+ "                \"userID\": \""+ userID + "\",                           "
						+ "        \"journey\": [                                                   "
						+ "            {                                                            "
						+ "                \"ID\": \"fc91e70cf8a042a7897286209266685b\",            "
						+ "                \"CERTID\": \"130826198112031219\",                      "
						+ "                \"CERTTYPE\": \"C\",                                     "
						+ "                \"TICKETNUMBER\": \"9998758597949\",                     "
						+ "                \"SURNAME\": \"张三\",                                     "
						+ "                \"DEPARTURECODE\": \"PEK\",                              "
						+ "                \"DEPARTUREDATE\": \"2017-09-09\",                       "
						+ "                \"AIRPORTCODE\": \"HGH\",                                "
						+ "                \"AIRLINECODE\": \"CA\",                                 "
						+ "                \"FLIGHTNUMBER\": \"1509\",                              "
						+ "                \"COUPONSTATUS\": \"C\",                                 "
						+ "                \"AIRPORTDATE\": \"2017-09-09\",                         "
						+ "                \"DEPARTURETIME\": \"07:30\",                            "
						+ "                \"AIRPORTTIME\": \"09:40\",                              "
						+ "                \"DEPARTURETERMINAL\": \"T3\",                           "
						+ "                \"ARRIVALTERMINAL\": \"--\",                             "
						+ "                \"COUPONNUMBER\": \"1\",                                 "
						+ "                \"CHANGE_DATE\": \"2017-09-08 11:40:55\",                "
						+ "                \"SEATNO\": \"11L\",                                     "
						+ "                \"GATE\": \"--\"                                         "
						+ "            },                                                           "
						+ "            {                                                            "
						+ "                \"ID\": \"d72f82aedd084b6c9eaf80e05a75619d\",            "
						+ "                \"CERTID\": \"130826198112031219\",                      "
						+ "                \"CERTTYPE\": \"C\",                                     "
						+ "                \"TICKETNUMBER\": \"9998758598302\",                     "
						+ "                \"SURNAME\": \"张三\",                                     "
						+ "                \"DEPARTURECODE\": \"HGH\",                              "
						+ "                \"DEPARTUREDATE\": \"2017-09-10\",                       "
						+ "                \"AIRPORTCODE\": \"PEK\",                                "
						+ "                \"AIRLINECODE\": \"CA\",                                 "
						+ "                \"FLIGHTNUMBER\": \"1713\",                              "
						+ "                \"COUPONSTATUS\": \"O\",                                 "
						+ "                \"AIRPORTDATE\": \"2017-09-10\",                         "
						+ "                \"DEPARTURETIME\": \"21:15\",                            "
						+ "                \"AIRPORTTIME\": \"23:35\",                              "
						+ "                \"DEPARTURETERMINAL\": \"--\",                           "
						+ "                \"ARRIVALTERMINAL\": \"T3\",                             "
						+ "                \"COUPONNUMBER\": \"1\",                                 "
						+ "                \"CHANGE_DATE\": \"2017-09-08 11:40:53\",                "
						+ "                \"SEATNO\": \"--\",                                      "
						+ "                \"GATE\": \"--\"                                         "
						+ "            },                                                           "
						+ "            {                                                            "
						+ "                \"ID\": \"a79d8f39fafb4cf2882524f0802770c3\",            "
						+ "                \"CERTID\": \"E61445461\",                               "
						+ "                \"CERTTYPE\": \"P\",                                     "
						+ "                \"TICKETNUMBER\": \"9994498755698\",                     "
						+ "                \"DEPARTURECODE\": \"PEK\",                              "
						+ "                \"DEPARTUREDATE\": \"2017-09-15\",                       "
						+ "                \"AIRPORTCODE\": \"SIN\",                                "
						+ "                \"AIRLINECODE\": \"CA\",                                 "
						+ "                \"FLIGHTNUMBER\": \"975\",                               "
						+ "                \"COUPONSTATUS\": \"O\",                                 "
						+ "                \"AIRPORTDATE\": \"2017-09-15\",                         "
						+ "                \"DEPARTURETIME\": \"00:05\",                            "
						+ "                \"AIRPORTTIME\": \"06:25\",                              "
						+ "                \"DEPARTURETERMINAL\": \"T3\",                           "
						+ "                \"ARRIVALTERMINAL\": \"T1\",                             "
						+ "                \"COUPONNUMBER\": \"1\",                                 "
						+ "                \"CHANGE_DATE\": \"2017-09-08 11:40:52\",                "
						+ "                \"SEATNO\": \"--\",                                      "
						+ "                \"GATE\": \"--\"                                         "
						+ "            },                                                           "
						+ "            {                                                            "
						+ "                \"ID\": \"5cbcc3191b254dc1b6dad444c1a2c15f\",            "
						+ "                \"CERTID\": \"E61445461\",                               "
						+ "                \"CERTTYPE\": \"P\",                                     "
						+ "                \"TICKETNUMBER\": \"9994498755698\",                     "
						+ "                \"DEPARTURECODE\": \"SIN\",                              "
						+ "                \"DEPARTUREDATE\": \"2017-09-20\",                       "
						+ "                \"AIRPORTCODE\": \"PEK\",                                "
						+ "                \"AIRLINECODE\": \"CA\",                                 "
						+ "                \"FLIGHTNUMBER\": \"970\",                               "
						+ "                \"COUPONSTATUS\": \"O\",                                 "
						+ "                \"AIRPORTDATE\": \"2017-09-20\",                         "
						+ "                \"DEPARTURETIME\": \"00:15\",                            "
						+ "                \"AIRPORTTIME\": \"05:50\",                              "
						+ "                \"DEPARTURETERMINAL\": \"T1\",                           "
						+ "                \"ARRIVALTERMINAL\": \"T3\",                             "
						+ "                \"COUPONNUMBER\": \"2\",                                 "
						+ "                \"CHANGE_DATE\": \"2017-09-08 11:40:52\"                 "
						+ "            },                                                           "
						+ "            {                                                            "
						+ "                \"ID\": \"35eb9e2c41ef4dc1813a4dc6bc06394e\",            "
						+ "                \"CERTID\": \"E61445461\",                               "
						+ "                \"CERTTYPE\": \"P\",                                     "
						+ "                \"TICKETNUMBER\": \"9994498755329\",                     "
						+ "                \"DEPARTURECODE\": \"PEK\",                              "
						+ "                \"DEPARTUREDATE\": \"2017-12-29\",                       "
						+ "                \"AIRPORTCODE\": \"BKK\",                                "
						+ "                \"AIRLINECODE\": \"CA\",                                 "
						+ "                \"FLIGHTNUMBER\": \"959\",                               "
						+ "                \"COUPONSTATUS\": \"O\",                                 "
						+ "                \"AIRPORTDATE\": \"2017-12-29\",                         "
						+ "                \"DEPARTURETIME\": \"13:40\",                            "
						+ "                \"AIRPORTTIME\": \"18:05\",                              "
						+ "                \"DEPARTURETERMINAL\": \"T3\",                           "
						+ "                \"ARRIVALTERMINAL\": \"--\",                             "
						+ "                \"COUPONNUMBER\": \"1\",                                 "
						+ "                \"CHANGE_DATE\": \"2017-09-08 11:40:53\",                "
						+ "                \"SEATNO\": \"--\",                                      "
						+ "                \"GATE\": \"--\"                                         "
						+ "            },                                                           "
						+ "            {                                                            "
						+ "                \"ID\": \"a0092c93093a4787b3b449d377337562\",            "
						+ "                \"CERTID\": \"E61445461\",                               "
						+ "                \"CERTTYPE\": \"P\",                                     "
						+ "                \"TICKETNUMBER\": \"9994498755329\",                     "
						+ "                \"DEPARTURECODE\": \"BKK\",                              "
						+ "                \"DEPARTUREDATE\": \"2017-01-02\",                       "
						+ "                \"AIRPORTCODE\": \"PEK\",                                "
						+ "                \"AIRLINECODE\": \"CA\",                                 "
						+ "                \"FLIGHTNUMBER\": \"980\",                               "
						+ "                \"COUPONSTATUS\": \"O\",                                 "
						+ "                \"AIRPORTDATE\": \"2017-01-02\",                         "
						+ "                \"DEPARTURETIME\": \"01:05\",                            "
						+ "                \"AIRPORTTIME\": \"06:30\",                              "
						+ "                \"DEPARTURETERMINAL\": \"--\",                           "
						+ "                \"ARRIVALTERMINAL\": \"T3\",                             "
						+ "                \"COUPONNUMBER\": \"2\",                                 "
						+ "                \"CHANGE_DATE\": \"2017-09-08 11:40:53\"                 "
						+ "            }                                                            "
						+ "        ]                                                                "
						+ "     }                                                                   "
						+ " }                                                                       ";

				logger.debug(xmlString);
				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/json;charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println(xmlString);
			}else{
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("status", "10002");
				map.put("msg", "用户不存在");
				
				String jsonString = JSON.toJSONString(map);
				logger.info(jsonString);

				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/json;charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println(jsonString);
			}
		}
	}

}
