package com.airchina.coupon.model;


public class Coupon {
	private String couponCode;
	private Integer status;
	private Integer couponPrice;
	private long createDate;
	private long startDate;
	private long endDate;
	private String userID;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(Integer couponPrice) {
		this.couponPrice = couponPrice;
	}
	public long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
	public long getStartDate() {
		return startDate;
	}
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}
	public long getEndDate() {
		return endDate;
	}
	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	
	
}
