package com.fes.mapper.airport;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airchina.airport.model.Airport;

@Service("airportMapper")
public interface AirportMapper {

	public List<Airport> queryAirports();

}
