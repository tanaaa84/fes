package com.fes.test.service;

import java.util.List;

import com.fes.test.model.Test;

public interface TestService {
	public int testAdd(Test tt);

	public int testEdit(Test tt);

	public int testDel(String id);

	public List<Test> testListByAll();
	
	public List<Test> testListById(String id);
	
	public List<Test> testListByName(String name);
}
