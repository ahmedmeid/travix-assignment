package com.travix.busyflights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.travix.busyflights.domin.SearchEntry;
import com.travix.busyflights.domin.SearchResult;

/**
 * 
 * @author Ahmed Eid
 * <br>
 * Spring RESTful Controller
 */
@RestController
public class BusyFlightsController {
	
	@Autowired
    List<FlightsProvider> providers;
	
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * 
	 * @param searchEntry
	 * @return search results list
	 * this method handles the HTTP POST request 
	 */
	@RequestMapping(method = RequestMethod.POST, value="/busyflights")
	public List<SearchResult> search(@RequestBody SearchEntry searchEntry){
		List<SearchResult> resultsList = new ArrayList<>();
		for(FlightsProvider provider : providers){
			ResponseEntity responseEntity = restTemplate.postForEntity(provider.getWsURL(), provider.getMapper().mapRequest(searchEntry), provider.getMapper().getResponseType());
			SearchResult[] results = provider.getMapper().mapResponse((Object[])responseEntity.getBody());
			resultsList.addAll(Arrays.asList(results));
		}
		//order the output by fare
        Collections.sort(resultsList, (SearchResult sr1, SearchResult sr2) -> sr1.getFare().compareTo(sr2.getFare()));
		
		return resultsList;
		
	}

}
