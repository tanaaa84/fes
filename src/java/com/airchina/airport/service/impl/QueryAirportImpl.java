package com.airchina.airport.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.airchina.airport.model.Airport;
import com.airchina.airport.service.IQueryAirport;
import com.fes.mapper.airport.AirportMapper;

@Service("queryAirportImpl")
public class QueryAirportImpl implements IQueryAirport {

	@Resource(name = "airportMapper")
	private AirportMapper lm;
	

	
	@Override
	public List<Airport> queryAirports() {
		// TODO Auto-generated method stub
		return lm.queryAirports();
	}

}
