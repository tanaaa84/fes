package com.airchina.mileage.model;

public class Mileage {

	private String userID;
	private Integer mileage_balance;
	private Long update_time;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Integer getMileage_balance() {
		return mileage_balance;
	}
	public void setMileage_balance(Integer mileage_balance) {
		this.mileage_balance = mileage_balance;
	}
	public Long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}
	
}
