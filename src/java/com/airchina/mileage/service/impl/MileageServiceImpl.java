package com.airchina.mileage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.airchina.mileage.model.Mileage;
import com.airchina.mileage.service.IMileageService;
import com.fes.mapper.mileage.MileageMapper;


@Service("mileageServiceImpl")
public class MileageServiceImpl implements IMileageService {
	@Resource(name = "mileageMapper")
	private MileageMapper som;
	
	

	@Override
	public List<Mileage> mileageInquiry(String userID) {
		// TODO Auto-generated method stub
		return som.mileageInquiry(userID);
	}

	@Override
	public List<Mileage> mileageAccumulation(String mileage, String userID) {
		// TODO Auto-generated method stub
		return som.mileageAccumulation(mileage, userID);
	}

	@Override
	public List<Mileage> mileageDeduction(String mileage, String userID) {
		// TODO Auto-generated method stub
		return som.mileageDeduction(mileage, userID);
	}

}
