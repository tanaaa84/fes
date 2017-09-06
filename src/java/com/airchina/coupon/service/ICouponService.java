package com.airchina.coupon.service;

import java.util.List;

import com.airchina.coupon.model.Coupon;

public interface ICouponService {

	
	
	public List<Coupon> queryCoupon(String userID,String status);

	public List<Coupon> useCoupon(String userID, String actionCode, String couponCode);
	
	public List<Coupon> addCoupon(String userID, String productCode);
}
