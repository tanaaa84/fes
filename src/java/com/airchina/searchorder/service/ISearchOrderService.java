package com.airchina.searchorder.service;

import java.util.List;

import com.airchina.searchorder.model.SearchOrder;

public interface ISearchOrderService {
	public int searchOrderAdd(SearchOrder tt);

	public int searchOrderEdit(SearchOrder tt);

	public int searchOrderDel(String id);

	public List<SearchOrder> searchOrderListByAll();

	public List<SearchOrder> searchOrderListById(String id);

	public List<SearchOrder> searchOrderListByName(String name);
}
