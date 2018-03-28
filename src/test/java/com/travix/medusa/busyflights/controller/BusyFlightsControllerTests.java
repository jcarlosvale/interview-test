package com.travix.medusa.busyflights.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BusyFlightsControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void correctParamsTest() throws Exception {
		
		BusyFlightsRequest request = new BusyFlightsRequest();
		request.setOrigin("RIO");
		request.setDestination("NYC");
		request.setDepartureDate("2018-05-01");
		request.setReturnDate("2018-05-01");
		request.setNumberOfPassengers(1);
		
		Gson gson = new Gson();
	    String json = gson.toJson(request);
	    
	    System.out.println(json);

		
		this.mockMvc.perform(post("/flights").contentType(MediaType.APPLICATION_JSON)
						.content(json)).andExpect(status().is2xxSuccessful());
	}

}
