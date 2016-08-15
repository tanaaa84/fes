package com.fes.mapper.searchorder;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.airchina.searchorder.model.SearchOrder;

@Service("searchOrderMapper")
public interface SearchOrderMapper {
	public int searchOrderAdd(SearchOrder tt);

	public int searchOrderEdit(SearchOrder tt);

	public int searchOrderDel(String id);

	public List<SearchOrder> searchOrderListByAll();

	public List<SearchOrder> searchOrderListById(@Param(value = "id") String id);

	public List<SearchOrder> searchOrderListByName(@Param(value = "name") String name);
	
	public List<SearchOrder> searchOrderListByOrderNo(@Param(value = "orderNo") String orderNo);
	
	public List<SearchOrder> searchOrderListByParam(@Param(value = "orderNo") String orderNo);
}
