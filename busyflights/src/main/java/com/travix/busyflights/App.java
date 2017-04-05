package com.travix.busyflights;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

import com.travix.busyflights.client.domin.CrazyAirSearchEntry;
import com.travix.busyflights.client.domin.CrazyAirSearchResult;
import com.travix.busyflights.client.domin.ToughJetSearchEntry;
import com.travix.busyflights.client.domin.ToughJetSearchResult;
import com.travix.busyflights.mapper.CrazyAirMapper;
import com.travix.busyflights.mapper.ToughJetMapper;


/**
 * 
 * @author Ahmed Eid
 * <br>
 * Application's Main class
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class App 
{

	public static void main(String args[]) {
		
		SpringApplication.run(App.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
    public List<FlightsProvider> providers()
    {
		List<FlightsProvider> providers = new ArrayList<>();
		
		FlightsProvider<CrazyAirSearchEntry, CrazyAirSearchResult> crazyAirProvider = new FlightsProvider<>();
		crazyAirProvider.setWsURL("http://127.0.0.1:8081/crazyAir/searchFlights");
		crazyAirProvider.setMapper(new CrazyAirMapper());
		
		providers.add(crazyAirProvider);
		
		FlightsProvider<ToughJetSearchEntry, ToughJetSearchResult> toughJetProvider = new FlightsProvider<>();
		toughJetProvider.setWsURL("http://127.0.0.1:8081/toughJet/search");
		toughJetProvider.setMapper(new ToughJetMapper());
		
		providers.add(toughJetProvider);
		
		return providers;
		
    }

}
