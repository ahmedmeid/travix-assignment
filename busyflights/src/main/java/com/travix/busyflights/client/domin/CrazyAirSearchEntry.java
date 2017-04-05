package com.travix.busyflights.client.domin;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CrazyAirSearchEntry {
	String origin;
	String destination;
	@JsonFormat(pattern="MM-dd-yyyy")
	Date departureDate;
	@JsonFormat(pattern="MM-dd-yyyy")
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
