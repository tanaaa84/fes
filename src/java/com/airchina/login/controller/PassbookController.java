package com.airchina.login.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fes.test.model.Test;

@Controller
public class PassbookController {
	@RequestMapping(value = "/pass", method = RequestMethod.GET)
	public void system(HttpServletRequest request, HttpServletResponse response, HttpSession session, Test tt) {

		try {
			String filePath = "/Users/tanyanbing/passbook/checkIn/PEK/pass.pkpass";

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
	
}
