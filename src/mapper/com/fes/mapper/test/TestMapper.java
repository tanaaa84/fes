package com.fes.mapper.test;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.fes.test.model.Test;

@Service("testMapper")
public interface TestMapper {
	public int testAdd(Test tt);

	public int testEdit(Test tt);

	public int testDel(String id);

	public List<Test> testListByAll();
	
	public List<Test> testListById(@Param(value = "id") String id);
	
	public List<Test> testListByName(@Param(value = "name") String name);
}
