package com.travix.busyflights.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import com.travix.busyflights.client.domin.ToughJetSearchEntry;
import com.travix.busyflights.client.domin.ToughJetSearchResult;
import com.travix.busyflights.domin.SearchEntry;
import com.travix.busyflights.domin.SearchResult;
/**
 * 
 * @author Ahmed Eid
 * <br>
 * ToughJet web service Request and Response mapper
 */
public class ToughJetMapper  implements FlightsProviderMapper<ToughJetSearchEntry, ToughJetSearchResult>{


	@Override
	public ToughJetSearchEntry mapRequest(SearchEntry searchEntry) {
		ToughJetSearchEntry entry = new ToughJetSearchEntry();
		entry.setTo(new String(searchEntry.getDestination()));
		entry.setFrom(new String(searchEntry.getOrigin()));
		entry.setDepartureDay(extractField(searchEntry.getDepartureDate(), "dd"));
		entry.setDepartureMonth(extractField(searchEntry.getDepartureDate(), "MM"));
		entry.setDepartureYear(extractField(searchEntry.getDepartureDate(), "YYYY"));
		entry.setReturnDay(extractField(searchEntry.getReturnDate(), "dd"));
		entry.setReturnMonth(extractField(searchEntry.getReturnDate(), "MM"));
		entry.setReturnYear(extractField(searchEntry.getReturnDate(), "YYYY"));
		entry.setNumberOfAdults(Integer.valueOf(searchEntry.getNumberOfPassengers()));
		return entry;
	}
	/**
	 * extract day, month, and year fields from java.util.Date
	 * @param date
	 * @param field
	 * @return extracted field
	 */
	private Integer extractField(Date date, String field){
		return Integer.parseInt(new SimpleDateFormat(field).format(date));
	}


	@Override
	public SearchResult[] mapResponse(ToughJetSearchResult[] response) {
		SearchResult[] mappedResponse = new SearchResult[response.length];
		for(int i=0;i<response.length;i++)
		{
			mappedResponse[i] = mapEntry(response[i]);
		}
		return mappedResponse;
	}
	
	private SearchResult mapEntry(ToughJetSearchResult entry)
	{
		SearchResult result = new SearchResult();
		result.setAirline(new String(entry.getCarrier()));
		result.setArrivalDate(new GregorianCalendar(entry.getReturnYear(), entry.getReturnMonth(), entry.getReturnDay()).getTime());
		result.setDepartureAirportCode(new String(entry.getDepartureAirportName()));
		result.setDepartureDate(new GregorianCalendar(entry.getDepartureYear(), entry.getDepartureMonth(), entry.getDepartureDay()).getTime());
		result.setDestinationAirportCode(new String(entry.getArrivalAirportName()));
		
		Double priceWithTax = entry.getBasePrice() + entry.getTax();		
		Double priceAfterDiscount = priceWithTax - (entry.getDiscount() / 100 ) * priceWithTax;		
		Double fare =  Math.round(priceAfterDiscount * 100.0) / 100.0;
		
		result.setFare(fare);
		result.setSupplier("ToughJet");
		
		return result;
	}
	
	

	@Override
	public Class getResponseType() {
		return ToughJetSearchResult[].class;
	}

}
