package com.fes.mapper.coupon;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.airchina.coupon.model.Coupon;

@Service("couponMapper")
public interface CouponMapper {

	public List<Coupon> queryCoupon(
			@Param(value = "userID") String userID,
			@Param(value = "status") String status);

	public List<Coupon> useCoupon(
			@Param(value = "couponCode") String couponCode,
			@Param(value = "actionCode") String actionCode,
			@Param(value = "userID") String userID);

	public List<Coupon> addCoupon(
			@Param(value = "couponCode") String couponCode,
			@Param(value = "status") String status,
			@Param(value = "couponPrice") String couponPrice,
			@Param(value = "createDate") String createDate,
			@Param(value = "startDate") String startDate,
			@Param(value = "endDate") String endDate,
			@Param(value = "userID") String userID);
}
