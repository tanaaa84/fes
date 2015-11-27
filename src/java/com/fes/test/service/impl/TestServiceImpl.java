package com.fes.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fes.mapper.test.TestMapper;
import com.fes.test.model.Test;
import com.fes.test.service.TestService;

@Service("testServiceImpl")
public class TestServiceImpl implements TestService {

	@Resource(name = "testMapper")
	private TestMapper tm;

	@Transactional
	public int testAdd(Test tt) {
		return tm.testAdd(tt);
	}

	@Transactional
	public int testEdit(Test tt) {
		return tm.testEdit(tt);
	}

	@Transactional
	public int testDel(String id) {
		return tm.testDel(id);
	}

	public List<Test> testListByAll() {
		return tm.testListByAll();
	}

	public List<Test> testListById(String id) {
		return tm.testListById(id);
	}

	public List<Test> testListByName(String name) {
		return tm.testListByName(name);
	}

}
