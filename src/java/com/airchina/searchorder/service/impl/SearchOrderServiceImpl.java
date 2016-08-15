package com.airchina.searchorder.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airchina.searchorder.model.SearchOrder;
import com.airchina.searchorder.service.ISearchOrderService;
import com.fes.mapper.searchorder.SearchOrderMapper;


@Service("searchOrderServiceImpl")
public class SearchOrderServiceImpl implements ISearchOrderService {
	
	@Resource(name = "searchOrderMapper")
	private SearchOrderMapper som;
	

	@Override
	@Transactional
	public int searchOrderAdd(SearchOrder tt) {
		// TODO Auto-generated method stub
		return som.searchOrderAdd(tt);
	}

	@Override
	@Transactional
	public int searchOrderEdit(SearchOrder tt) {
		// TODO Auto-generated method stub
		return som.searchOrderEdit(tt);
	}

	@Override
	@Transactional
	public int searchOrderDel(String id) {
		// TODO Auto-generated method stub
		return som.searchOrderDel(id);
	}

	@Override
	public List<SearchOrder> searchOrderListByAll() {
		// TODO Auto-generated method stub
		return som.searchOrderListByAll();
	}

	@Override
	public List<SearchOrder> searchOrderListById(String id) {
		// TODO Auto-generated method stub
		return som.searchOrderListById(id);
	}

	@Override
	public List<SearchOrder> searchOrderListByName(String name) {
		// TODO Auto-generated method stub
		return som.searchOrderListByName(name);
	}
	
	
	@Override
	public List<SearchOrder> searchOrderListByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		return som.searchOrderListByOrderNo(orderNo);
	}
	
	@Override
	public List<SearchOrder> searchOrderListByParam(String orderNo) {
		// TODO Auto-generated method stub
		return som.searchOrderListByParam(orderNo);
	}
}
