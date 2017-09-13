package com.fes.mapper.mileage;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.airchina.mileage.model.Mileage;

@Service("mileageMapper")
public interface MileageMapper {
	
	public List<Mileage> mileageInquiry(@Param(value = "userID") String userID);
	
	public List<Mileage> mileageAccumulation(@Param(value = "mileage") String mileage, @Param(value = "userID") String userID);

	public List<Mileage> mileageDeduction(@Param(value = "mileage") String mileage, @Param(value = "userID") String userID);

	public List<Mileage> addMileage(@Param(value = "userID") String userID,@Param(value = "mileageBalance") String mileageBalance,@Param(value = "updateTime") String updateTime);
	
	
}


