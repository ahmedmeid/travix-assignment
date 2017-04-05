package com.travix.busyflights.test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.travix.busyflights.domin.SearchEntry;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BusyFlightsTest{
	
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    private HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8081);
	
	@Autowired
	private MockMvc mockMvc;
	
    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }
	
    @Test
	public void testSearch() throws Exception{
		SearchEntry searchEntry = new SearchEntry();
		searchEntry.setOrigin("LHR");
		searchEntry.setDestination("AMS");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		searchEntry.setDepartureDate(sdf.parse("2017-04-01"));
		searchEntry.setReturnDate(sdf.parse("2017-04-15"));
		searchEntry.setNumberOfPassengers(3);
		this.mockMvc.perform(post("/busyflights").content(json(searchEntry)).contentType(contentType))
		            .andExpect(status().isOk())                    //verify the HTTP status is 200 OK
		            .andExpect(content().contentType(contentType)) //verify that data is valid json
		            .andExpect(jsonPath("$", hasSize(8)))          //verify that data is aggregated
		            .andExpect(jsonPath("$[0].fare", is(137.25)))  //verify rounding
		            .andExpect(jsonPath("$[1].fare", is(150.2)))   //verify order
		            .andExpect(jsonPath("$[3].fare", is(197.95))); //verify that the fare is calculated correctly for ToughJet
	}
    
    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }


}
