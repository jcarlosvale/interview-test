package com.travix.medusa.busyflights.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BusyFlightsControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void paramWithTwoResultsMessage() throws Exception {

		this.mockMvc
				.perform(get("/flights").param("origin", "RIO").param("destination", "NYC")
						.param("departureDate","01-04-2018")
						.param("returnDate", "01-05-2018")
						.param("numberOfPassengers", "4"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.airline").value("TAM"));
	}

}
