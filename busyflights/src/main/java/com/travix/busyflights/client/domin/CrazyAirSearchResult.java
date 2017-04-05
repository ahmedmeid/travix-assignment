package com.travix.busyflights.client.domin;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @author Ahmed Eid
 * <br>
 * CrazyAir search result domain object
 */
public class CrazyAirSearchResult{
	
	String airline;
	String departureAirportCode;
	String destinationAirportCode;
	@JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
	Date departureDate;
	@JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
	Date arrivalDate;
	Double price;
	Character cabinclass;
	
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getDepartureAirportCode() {
		return departureAirportCode;
	}
	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}
	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}
	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Character getCabinclass() {
		return cabinclass;
	}
	public void setCabinclass(Character cabinclass) {
		this.cabinclass = cabinclass;
	}
}
