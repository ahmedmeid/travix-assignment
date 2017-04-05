package com.travix.busyflights.mapper;

import com.travix.busyflights.domin.SearchEntry;
import com.travix.busyflights.domin.SearchResult;
/**
 * 
 * @author Ahmed Eid
 *
 */
public interface FlightsProviderMapper<T, S> {

	public T mapRequest(SearchEntry searchEntry);
	
	public SearchResult[] mapResponse(S[] response);
	
	public Class<S[]> getResponseType();
}
