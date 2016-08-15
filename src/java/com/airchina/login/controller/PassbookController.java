package com.airchina.login.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fes.test.model.Test;

@Controller
public class PassbookController {
	@RequestMapping(value = "/pass", method = RequestMethod.GET)
	public void system(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Test tt) {

		try {
			String filePath = "/Users/tanyanbing/passbook/checkIn/PEK/PEK999-712712888.pkpass";

			File file = new File(filePath);
			response.setContentType("application/vnd.apple.pkpass");
			// 写明要下载的文件的大小
			response.setContentLength((int) file.length());
			// 解决中文乱码
			response.setHeader("Content-Disposition", "attachment;filename="
					+ "pass" + ".pkpass");

			// 读出文件到i/o流
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream buff = new BufferedInputStream(fis);

			byte[] b = new byte[1024];//
			long k = 0;// 该值用于计算当前实际下载了多少字节
			// 从response对象中得到输出流,准备下载
			OutputStream myout = response.getOutputStream();
			// 开始循环下载
			while (k < file.length()) {
				int j = buff.read(b, 0, 1024);
				k += j;
				// 将b中的数据写到客户端的内存
				myout.write(b, 0, j);

			}
			// 将写入到客户端的内存的数据,刷新到磁盘
			myout.flush();
			myout.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	
	
	@RequestMapping(value = "/update")
	public ModelAndView system(HttpServletRequest request, HttpSession session,
			Test tt) {
		System.out.println("update0------" + request.getMethod());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		System.out.println("");
		return mav;
	}

	
	
	
	@RequestMapping(value = "/update/{cc}")
	public void system(HttpServletRequest request, HttpSession session, @PathVariable("cc") String cc) {
		System.out.println("update1------" + request.getMethod());

		System.out.println("");
	}

	
	
	
	@RequestMapping(value = "/update/{aa}/{bb}/{cc}")
	public void system(HttpServletRequest request, HttpSession session, @PathVariable("aa") String aa, @PathVariable("bb") String bb, @PathVariable("cc") String cc) {
		System.out.println("update3------" + request.getMethod());
		System.out.println("");
	
	}
	
	@RequestMapping(value = "/update/{aa}/{bb}/{cc}/{dd}")
	public void system(HttpServletRequest request,HttpServletResponse response, HttpSession session, @PathVariable("aa") String aa, @PathVariable("bb") String bb, @PathVariable("cc") String cc, @PathVariable("dd") String dd) throws IOException {
		System.out.println("update4-------" + request.getMethod());
		
		
		System.out.println(aa);
		System.out.println(bb);
		System.out.println(cc);
		System.out.println(dd);
		

		
		request.setCharacterEncoding("UTF-8");
		int size = request.getContentLength();
		System.out.println(size);
		InputStream is = request.getInputStream();
		byte[] reqBodyBytes = readBytes(is, size);
		String res = new String(reqBodyBytes);
		System.out.println(res);
		

		try {
			String filePath = "/Users/tanyanbing/passbook/checkIn/PEK/PEK999-712712888.pkpass";

			File file = new File(filePath);
			response.setContentType("application/vnd.apple.pkpass");
			// 写明要下载的文件的大小
			response.setContentLength((int) file.length());
			// 解决中文乱码
			response.setHeader("Content-Disposition", "attachment;filename="
					+ "pass" + ".pkpass");
			
			
			
			response.setHeader("last-modified", System.currentTimeMillis() / 1000 +"");
			
			response.setStatus(HttpServletResponse.SC_OK);
			
			

			// 读出文件到i/o流
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream buff = new BufferedInputStream(fis);

			byte[] b = new byte[1024];//
			long k = 0;// 该值用于计算当前实际下载了多少字节
			// 从response对象中得到输出流,准备下载
			OutputStream myout = response.getOutputStream();
			// 开始循环下载
			while (k < file.length()) {
				int j = buff.read(b, 0, 1024);
				k += j;
				// 将b中的数据写到客户端的内存
				myout.write(b, 0, j);

			}
			// 将写入到客户端的内存的数据,刷新到磁盘
			myout.flush();
			myout.close();
			System.out.println("");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}
	
	
	
	
	
	@RequestMapping("/update/{aa}/{bb}/{cc}/{dd}/{ee}")
	public void getUserInfo(HttpServletRequest request,HttpServletResponse response,@PathVariable("aa") String aa,
			@PathVariable("bb") String bb, @PathVariable("cc") String cc, @PathVariable("dd") String dd, @PathVariable("ee") String ee) throws IOException {
		
		System.out.println("update5------" + request.getMethod());

		System.out.println(aa);
		System.out.println(bb);
		System.out.println(cc);
		System.out.println(dd);
		System.out.println(ee);

//		HashMap<String, Object> tmp = new HashMap<String, Object>();
//		tmp.put("lastUpdated", System.currentTimeMillis() / 1000 + "");
//		tmp.put("serialNumbers","[\"2j31298h9d23d98hf0hd30h9d2390hd0923hd3029dh\"]");
//
//		String jsonObject = JSONObject.toJSONString(tmp);
//
//		System.out.println(jsonObject);
//		
		
		System.out.println(System.currentTimeMillis());
		String lastUpdated = System.currentTimeMillis() / 1000 + "";
		String jsonObject = "{\"lastUpdated\":\""+ lastUpdated +"\",\"serialNumbers\":[\"2j31298h9d23d98hf0hd30h9d2390hd0923hd3029dh\"]}";
		response.getWriter().print(jsonObject);
		response.setStatus(HttpServletResponse.SC_OK);
		
//		response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
		
		
		
		
		 System.out.println("");
		
		

//		return tmp;

	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/update/{aa}/{bb}")
	public void getUserInfo1(HttpServletRequest request,HttpServletResponse response,@PathVariable("aa") String aa,
			@PathVariable("bb") String bb) throws IOException {
		
		System.out.println("update2------" + request.getMethod());
		
		System.out.println(aa);
		System.out.println(bb);
//		System.out.println(cc);
//		System.out.println(dd);
//		System.out.println(ee);

//		Enumeration<?> paramNames = request.getParameterNames();
//		String params = "";
//		while (paramNames.hasMoreElements()) {
//			String paramName = paramNames.nextElement().toString();
//			String paramValue = request.getParameter(paramName);
//
//			System.out.print(paramName);
//			System.out.println(":  " + paramValue);
//		}
//
//		request.setCharacterEncoding("UTF-8");
//		Enumeration<String> enu = request.getHeaderNames();
//		while (enu.hasMoreElements()) {
//			String headerName = enu.nextElement();
//			System.out.println(headerName + ":  "
//					+ request.getHeader(headerName));
//		}
		String value = request.getHeader("serial_number");
		System.out.println(value);
		
		
		request.setCharacterEncoding("UTF-8");
		int size = request.getContentLength();
		System.out.println(size);
		InputStream is = request.getInputStream();
		byte[] reqBodyBytes = readBytes(is, size);
		String res = new String(reqBodyBytes);
		System.out.println(res);
		

//		try {
//			String filePath = "/Users/tanyanbing/passbook/checkIn/PEK/PEK999-712712770.pkpass";
//
//			File file = new File(filePath);
//			response.setContentType("application/vnd.apple.pkpass");
//			// 写明要下载的文件的大小
//			response.setContentLength((int) file.length());
//			// 解决中文乱码
//			response.setHeader("Content-Disposition", "attachment;filename="
//					+ "pass" + ".pkpass");
//			
//			
			response.setStatus(HttpServletResponse.SC_OK);
//			
//			
//
//			// 读出文件到i/o流
//			FileInputStream fis = new FileInputStream(file);
//			BufferedInputStream buff = new BufferedInputStream(fis);
//
//			byte[] b = new byte[1024];//
//			long k = 0;// 该值用于计算当前实际下载了多少字节
//			// 从response对象中得到输出流,准备下载
//			OutputStream myout = response.getOutputStream();
//			// 开始循环下载
//			while (k < file.length()) {
//				int j = buff.read(b, 0, 1024);
//				k += j;
//				// 将b中的数据写到客户端的内存
//				myout.write(b, 0, j);
//
//			}
//			// 将写入到客户端的内存的数据,刷新到磁盘
//			myout.flush();
//			myout.close();
//			System.out.println("");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

	}
	
	
	
	  /**
     * 注册pass
     * @return resp
     * @throws Exception
     */
	@RequestMapping(value = "/update/{aa}/{bb}/{cc}/{dd}/{ee}/{ff}", method = RequestMethod.POST)
    public @ResponseBody void  reg(HttpServletRequest request,HttpServletResponse response,@PathVariable("aa") String aa,
			@PathVariable("bb") String bb, @PathVariable("cc") String cc, @PathVariable("dd") String dd, @PathVariable("ee") String ee, @PathVariable("ff") String ff) throws Exception {
       System.out.println("res2-6------" + request.getMethod());
		
       
       System.out.println(aa);
       System.out.println(bb);
       System.out.println(cc);
       System.out.println(dd);
       System.out.println(ee);
       System.out.println(ff);
       
       
       
       
       
		Enumeration<?> paramNames = request.getParameterNames();
		String params = "";
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement().toString();
			String paramValue = request.getParameter(paramName);

			System.out.print(paramName);
			System.out.println(":  " + paramValue);
		}

		request.setCharacterEncoding("UTF-8");
		Enumeration<String> enu = request.getHeaderNames();
		while (enu.hasMoreElements()) {
			String headerName = enu.nextElement();
			System.out.println(headerName + ":  "
					+ request.getHeader(headerName));
		}
       
		
		
		BufferedReader br = request.getReader();

		String str, wholeStr = "";
		while((str = br.readLine()) != null){
		wholeStr += str;
		}
		System.out.println(wholeStr);
		
       
       
       
       
       response.setStatus(HttpServletResponse.SC_CREATED);
       System.out.println("");
    }

	
	
	
	
	  /**
     * 删除pass
     * @return resp
     * @throws Exception
     */
	@RequestMapping(value = "/update/{aa}/{bb}/{cc}/{dd}/{ee}/{ff}", method = RequestMethod.DELETE)
    public @ResponseBody void  regdelete(HttpServletRequest request,HttpServletResponse response,@PathVariable("aa") String aa,
			@PathVariable("bb") String bb, @PathVariable("cc") String cc, @PathVariable("dd") String dd, @PathVariable("ee") String ee, @PathVariable("ff") String ff) throws Exception {
       System.out.println("delete-6------" + request.getMethod());
		
       
       System.out.println(aa);
       System.out.println(bb);
       System.out.println(cc);
       System.out.println(dd);
       System.out.println(ee);
       System.out.println(ff);
       
       response.setStatus(HttpServletResponse.SC_OK);
       System.out.println("");
    }
	
	
	

	

	public static final byte[] readBytes(InputStream is, int contentLen) {
		if (contentLen > 0) {
			int readLen = 0;
			int readLengthThisTime = 0;
			byte[] message = new byte[contentLen];
			try {
				while (readLen != contentLen) {
					readLengthThisTime = is.read(message, readLen, contentLen
							- readLen);
					if (readLengthThisTime == -1) {// Should not happen.
						break;
					}
					readLen += readLengthThisTime;
				}
				return message;
			} catch (IOException e) {
				// Ignore
				// e.printStackTrace();
			}
		}
		return new byte[] {};
	}

	
	
	
	
	@RequestMapping(value = "/test1")
	public String test1(HttpServletRequest request) {
		System.out.println("ue------" + request.getMethod());
		return "forward:/test2"; 
	
	}
	
	
	
	@RequestMapping(value = "/test2")
	public String test2(HttpServletRequest request) {
		System.out.println("update3------" + request.getMethod());
		 return ""; 
	
	}
	
	
}









