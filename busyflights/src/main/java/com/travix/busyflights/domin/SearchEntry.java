package com.travix.busyflights.domin;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @author Ahmed Eid
 * <br>
 * BusyFlights search entry domain object
 */
public class SearchEntry {
	
	String origin;
	String destination;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ")
	Date departureDate;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ")
	Date returnDate;
	Integer numberOfPassengers;
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Integer getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(Integer numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	
}
