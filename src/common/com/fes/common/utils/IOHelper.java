package com.fes.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class IOHelper {

	//获取路径
	public static String getPath(HttpServletRequest req) {
		//String path = req.getSession().getServletContext().getRealPath("WebContent/");
		//String p = path.substring(0,path.indexOf("."));
		//path = p+path.substring(path.indexOf("grid_cms"));
		//String path = req.getRealPath("/");
		String path = req.getSession().getServletContext().getRealPath("/");
		return path;
	}

	public static String upload(HttpServletRequest req) {
		String oldpath = getPath(req) + "file\\";
		String imgName = "";
		int maxPostSize = 3 * 5 * 1024 * 1024;
		try {
			FileRenamePolicy policy = new MyFileRenamePolicy();
			MultipartRequest multi = null;
			multi = new MultipartRequest(req, oldpath, maxPostSize, policy);
			Enumeration files = multi.getFileNames();
			if (files.hasMoreElements()) {
				while (files.hasMoreElements()) {
					String name = (String) files.nextElement();
					File f = multi.getFile(name);
					if (f != null) {
						imgName = multi.getFilesystemName(name);
						//System.out.println(imgName);
						return imgName;
					}
				}
			}
			else {
				imgName = "没有上传的文件!";
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			imgName = "上传失败!";
		}

		return imgName;
	}

	//复制文件
	public static boolean copyFile(HttpServletRequest req, String fileName) {
		try {
			String oldpath = getPath(req) + "file\\";
			String NewPath = getPath(req) + "imgFile\\";
			FileInputStream fis = new FileInputStream(oldpath + fileName);
			FileOutputStream fos = new FileOutputStream(NewPath + fileName);
			byte[] buf = new byte[1024];
			int c;
			while ((c = fis.read(buf)) != -1) {
				fos.write(buf, 0, c);
			}
			fis.close();
			fos.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//删除文件(修改图片时，先删除原图片)
	public static boolean delFile(HttpServletRequest req, String fileName) {
		//String oldpath = getPath(req)+"/file";
		String NewPath = getPath(req) + "imgFile\\";
		File newFile = new File(NewPath + fileName);
		if (newFile.exists() && newFile.isFile()) {
			newFile.delete();
			return true;
		}
		else {
			return false;
		}
	}

}
