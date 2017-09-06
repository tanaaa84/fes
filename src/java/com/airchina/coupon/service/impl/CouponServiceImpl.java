package com.airchina.coupon.service.impl;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.airchina.coupon.model.Coupon;
import com.airchina.coupon.service.ICouponService;
import com.airchina.util.TimeHelper;
import com.fes.mapper.coupon.CouponMapper;


@Service("couponServiceImpl")
public class CouponServiceImpl implements ICouponService {

	@Resource(name = "couponMapper")
	private CouponMapper lm;
	
	
	@Override
	public List<Coupon> queryCoupon(String userID,String status) {
		// TODO Auto-generated method stub
		return lm.queryCoupon(userID,status);
	}

	@Override
	public List<Coupon> useCoupon(String userID, String actionCode, String couponCode) {
		
		String status = "";
		if(actionCode.equals("1")){
			status = "3";
		}
		
		if(actionCode.equals("2")){
			status = "1";
		}
		
		if(actionCode.equals("3")){
			status = "2";
		}
		
		return lm.useCoupon(couponCode, status, userID);
	}

	@Override
	public List<Coupon> addCoupon(String userID,String productCode) {
		String couponPrice = "0";
		if (productCode.equals("EC131")) {
			couponPrice = "30";
		}
		
		if (productCode.equals("EC151")) {
			couponPrice = "50";
		}

		String couponCode = getStringRandom(16);
		
		return lm.addCoupon(couponCode, "1", couponPrice, TimeHelper.getCurrentTime()+"", "20170906000000", "20171005235959", userID);
	}
	
	
	//生成随机数字和字母,  
    public String getStringRandom(int length) {  
          
        String val = "";  
        Random random = new Random();  
          
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
              
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }  

}
