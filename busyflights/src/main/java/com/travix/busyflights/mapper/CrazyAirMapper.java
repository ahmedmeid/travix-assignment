package com.travix.busyflights.mapper;

import com.travix.busyflights.client.domin.CrazyAirSearchEntry;
import com.travix.busyflights.client.domin.CrazyAirSearchResult;
import com.travix.busyflights.client.domin.ToughJetSearchEntry;
import com.travix.busyflights.client.domin.ToughJetSearchResult;
import com.travix.busyflights.domin.SearchEntry;
import com.travix.busyflights.domin.SearchResult;
/**
 * 
 * @author Ahmed Eid
 * <br>
 * CrazyAir web service Request and Response mapper
 */
public class CrazyAirMapper implements FlightsProviderMapper<CrazyAirSearchEntry, CrazyAirSearchResult>{


	@Override
	public CrazyAirSearchEntry mapRequest(SearchEntry searchEntry) {
		CrazyAirSearchEntry entry = new CrazyAirSearchEntry();
		entry.setOrigin(searchEntry.getOrigin());
		entry.setDestination(searchEntry.getDestination());
		entry.setDepartureDate(searchEntry.getDepartureDate());
		entry.setReturnDate(searchEntry.getReturnDate());
		entry.setNumberOfPassengers(searchEntry.getNumberOfPassengers());
		return entry;
	}

	@Override
	public SearchResult[] mapResponse(CrazyAirSearchResult[] response) {
		SearchResult[] mappedResponse = new SearchResult[response.length];
		for(int i=0;i<response.length;i++)
		{
			mappedResponse[i] = mapEntry(response[i]);
		}
		return mappedResponse;
	}
	
	private SearchResult mapEntry(CrazyAirSearchResult entry){
        SearchResult result = new SearchResult();
		
        result.setAirline(entry.getAirline());
		
        result.setSupplier("CrazyAir");
		
		Double fare = Math.round(entry.getPrice() * 100.0) / 100.0;
		result.setFare(fare);
		
		result.setDepartureAirportCode(entry.getDepartureAirportCode());
		result.setDestinationAirportCode(entry.getDestinationAirportCode());
		
		result.setDepartureDate(entry.getDepartureDate());
		result.setArrivalDate(entry.getArrivalDate());
        
		return result;
	}
	
	public Class getResponseType()
	{
		return CrazyAirSearchResult[].class;
	}

}
