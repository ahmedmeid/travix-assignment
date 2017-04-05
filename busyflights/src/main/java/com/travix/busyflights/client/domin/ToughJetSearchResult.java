package com.travix.busyflights.client.domin;
/**
 * 
 * @author Ahmed Eid
 * <br>
 * ToughJet search result domain object
 */
public class ToughJetSearchResult {
	
	String carrier;
	Double basePrice;
	Double tax;
	Double discount;
	String departureAirportName;
	String arrivalAirportName;
	Integer departureDay;
	Integer departureMonth;
	Integer departureYear;
	Integer returnDay;
	Integer returnMonth;
	Integer returnYear;
	
	
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
	public Double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getDepartureAirportName() {
		return departureAirportName;
	}
	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}
	public String getArrivalAirportName() {
		return arrivalAirportName;
	}
	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}
	public Integer getDepartureDay() {
		return departureDay;
	}
	public void setDepartureDay(Integer departureDay) {
		this.departureDay = departureDay;
	}
	public Integer getDepartureMonth() {
		return departureMonth;
	}
	public void setDepartureMonth(Integer departureMonth) {
		this.departureMonth = departureMonth;
	}
	public Integer getDepartureYear() {
		return departureYear;
	}
	public void setDepartureYear(Integer departureYear) {
		this.departureYear = departureYear;
	}
	public Integer getReturnDay() {
		return returnDay;
	}
	public void setReturnDay(Integer returnDay) {
		this.returnDay = returnDay;
	}
	public Integer getReturnMonth() {
		return returnMonth;
	}
	public void setReturnMonth(Integer returnMonth) {
		this.returnMonth = returnMonth;
	}
	public Integer getReturnYear() {
		return returnYear;
	}
	public void setReturnYear(Integer returnYear) {
		this.returnYear = returnYear;
	}

}
