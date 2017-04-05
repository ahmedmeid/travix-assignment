package com.travix.busyflights.domin;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @author Ahmed Eid
 * <br>
 * BusyFlights search result domain object
 */
public class SearchResult{
	
	String airline;
	String supplier;
	Double fare;
	String departureAirportCode;
	String destinationAirportCode;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ")
	Date departureDate;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ")
	Date arrivalDate;
	
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
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
	

}
