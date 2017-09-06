package com.airchina.mileage.service;

import java.util.List;

import com.airchina.mileage.model.Mileage;

public interface IMileageService {
	
	public List<Mileage> mileageInquiry(String userID);
	
	public List<Mileage> mileageAccumulation(String mileage, String userID);

	public List<Mileage> mileageDeduction(String mileage, String userID);


}
