package com.travix.busyflights;

import com.travix.busyflights.mapper.FlightsProviderMapper;

/**
 * 
 * @author Ahmed Eid
 * <br>
 * This class represents the supplier's web service
 * @param <T> The supplier's web service request type
 * @param <S> The supplier's web service response type
 */
public class FlightsProvider<T, S> {
	
	//The supplier's web service URL
	String wsURL;
	
	//The request and response mapper
	FlightsProviderMapper<T, S> mapper;
	
	public String getWsURL() {
		return wsURL;
	}
	public void setWsURL(String wsURL) {
		this.wsURL = wsURL;
	}
	public FlightsProviderMapper<T, S> getMapper() {
		return mapper;
	}
	public void setMapper(FlightsProviderMapper<T, S> mapper) {
		this.mapper = mapper;
	}	

}
