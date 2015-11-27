package com.fes.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 项目名称：泰丰贷款系统 <br>
 * 类名称：FileUtils <br>
 * 类描述：文件操作类 <br>
 * 创建人：10yue <br>
 * 创建时间：2013-05-23 <br>
 * 
 * @version 1.0
 */
public class FileUtils {
	public FileUtils() {

	}

	public String ReadFile(String filepath) {
		String temp = "";

		try {
			FileInputStream fr = new FileInputStream(filepath);
			int lenght = fr.available();
			byte bytes[] = new byte[lenght];
			fr.read(bytes);
			fr.close();
			temp = new String(bytes, "utf-8");
		}
		catch (IOException e) {
			temp = "文件读取失败！";
			System.out.println(filepath + "文件读取失败！");
		}

		return temp;
	}

	//创建新的文件夹
	public void newFolder(String folderPath) {
		try {
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists())
				myFilePath.mkdir();
		}
		catch (Exception e) {
			System.out.println("新建目录操作出错");
			e.printStackTrace();
		}
	}

	//生成文件
	public void WriterFile(String filepath, String code) {
		try {
			FileWriter fw = new FileWriter(filepath);
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath), "UTF-8")));
			out.print(code);
			out.close();
			fw.close();
		}
		catch (IOException e) {
			System.out.println("false");
		}
	}

	//
	public void WriterFile(String filepath, String code, String charset) {
		try {
			FileWriter fw = new FileWriter(filepath);
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath), charset)));
			out.print(code);
			out.close();
			fw.close();
		}
		catch (IOException e) {
			System.out.println("false");
		}
	}

	//删除文件
	public void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myDelFile = new File(filePath);
			myDelFile.delete();
		}
		catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();
		}
	}

	//删除文件夹
	public void delFolder(String folderPath) {
		try {
			delAllFile(folderPath);
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete();
		}
		catch (Exception e) {
			System.out.println("删除文件夹操作出错");
			e.printStackTrace();
		}
	}

	//删除所有文件
	public void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists())
			return;
		if (!file.isDirectory())
			return;
		String tempList[] = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator))
				temp = new File((new StringBuilder(String.valueOf(path))).append(tempList[i]).toString());
			else
				temp = new File((new StringBuilder(String.valueOf(path))).append(File.separator).append(tempList[i]).toString());
			if (temp.isFile())
				temp.delete();
			if (temp.isDirectory()) {
				delAllFile((new StringBuilder(String.valueOf(path))).append("/").append(tempList[i]).toString());
				delFolder((new StringBuilder(String.valueOf(path))).append("/").append(tempList[i]).toString());
			}
		}

	}
}
