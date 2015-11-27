package com.fes.common.utils;

import java.io.File;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	public File rename(File file) {
		file = new File(file.getParent(), getNewFileName(file.getName()));
		return file;
	}

	public String getNewFileName(String fileName) {
		String newName = null;
		String fType = "";
		if (fileName == null || fileName.equals("")) {
			return newName;
		}
		else {
			fType = fileName.substring(fileName.lastIndexOf("."));
			String time = Long.toString(new java.util.Date().getTime());
			newName = time + fType;
			return newName;
		}
	}

}
