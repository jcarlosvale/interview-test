package com.travix.medusa.busyflights.controller;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponseList;
import com.travix.medusa.busyflights.domain.busyflights.enums.Supplier;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponseList;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponseList;
import com.travix.medusa.busyflights.services.BusyFlightsDataConvertService;
import com.travix.medusa.busyflights.services.BusyFlightsService;

/**
 * Mass of tests applied in our services and WS.
 * @author joao
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BusyFlightsControllerTests {

	@MockBean
	private RestTemplate restTemplate;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private BusyFlightsService service;

	private Gson gson;

	private BusyFlightsRequest busyFlightsRequest;

	private String mockJson(BusyFlightsRequest busyFlightsRequest) {
		return gson.toJson(busyFlightsRequest);
	}

	private void mockRestServices(BusyFlightsRequest busyFlightsRequest) {
		Mockito.when(restTemplate.postForObject("http://localhost:8080/crazy",
				BusyFlightsDataConvertService.convertToCrazyAirRequest(busyFlightsRequest), CrazyAirResponseList.class))
				.thenReturn(new CrazyAirResponseList());
		Mockito.when(restTemplate.postForObject("http://localhost:8080/tough",
				BusyFlightsDataConvertService.convertToToughJetRequest(busyFlightsRequest), ToughJetResponseList.class))
				.thenReturn(new ToughJetResponseList());
	}

	private void mockRestService(BusyFlightsRequest busyFlightsRequest, CrazyAirResponse crazyAirResponse) {

		CrazyAirResponseList crazyAirResponseList = new CrazyAirResponseList();
		crazyAirResponseList.addResponse(crazyAirResponse);

		Mockito.when(restTemplate.postForObject("http://localhost:8080/crazy",
				BusyFlightsDataConvertService.convertToCrazyAirRequest(busyFlightsRequest), CrazyAirResponseList.class))
				.thenReturn(crazyAirResponseList);
		Mockito.when(restTemplate.postForObject("http://localhost:8080/tough",
				BusyFlightsDataConvertService.convertToToughJetRequest(busyFlightsRequest), ToughJetResponseList.class))
				.thenReturn(new ToughJetResponseList());
	}
	
	private void mockRestService(BusyFlightsRequest busyFlightsRequest, CrazyAirResponse crazyAirResponse,
			ToughJetResponse toughJetResponse) {
		
		CrazyAirResponseList crazyAirResponseList = new CrazyAirResponseList();
		crazyAirResponseList.addResponse(crazyAirResponse);
		
		ToughJetResponseList toughJetResponseList = new ToughJetResponseList();
		toughJetResponseList.addResponse(toughJetResponse);

		Mockito.when(restTemplate.postForObject("http://localhost:8080/crazy",
				BusyFlightsDataConvertService.convertToCrazyAirRequest(busyFlightsRequest), CrazyAirResponseList.class))
				.thenReturn(crazyAirResponseList);
		Mockito.when(restTemplate.postForObject("http://localhost:8080/tough",
				BusyFlightsDataConvertService.convertToToughJetRequest(busyFlightsRequest), ToughJetResponseList.class))
				.thenReturn(toughJetResponseList);
	}
	
	private void mockRestService(BusyFlightsRequest busyFlightsRequest, CrazyAirResponseList crazyAirResponseList,
			ToughJetResponseList toughJetResponseList) {
		Mockito.when(restTemplate.postForObject("http://localhost:8080/crazy",
				BusyFlightsDataConvertService.convertToCrazyAirRequest(busyFlightsRequest), CrazyAirResponseList.class))
				.thenReturn(crazyAirResponseList);
		Mockito.when(restTemplate.postForObject("http://localhost:8080/tough",
				BusyFlightsDataConvertService.convertToToughJetRequest(busyFlightsRequest), ToughJetResponseList.class))
				.thenReturn(toughJetResponseList);
	}
	

	@Before
	public void setUp() {
		gson = new Gson();

		busyFlightsRequest = new BusyFlightsRequest();
		busyFlightsRequest.setOrigin("RIO");
		busyFlightsRequest.setDestination("NYC");
		busyFlightsRequest.setDepartureDate("2018-05-01");
		busyFlightsRequest.setReturnDate("2018-05-01");
		busyFlightsRequest.setNumberOfPassengers(4);
	}

	@Test
	public void validateNumberOfPassengersTest() throws Exception {
		mockRestServices(busyFlightsRequest);

		busyFlightsRequest.setNumberOfPassengers(0);
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is4xxClientError());

		busyFlightsRequest.setNumberOfPassengers(5);
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is4xxClientError());

		busyFlightsRequest.setNumberOfPassengers(3);
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void validateOriginTest() throws Exception {
		mockRestServices(busyFlightsRequest);

		busyFlightsRequest.setOrigin("");
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is4xxClientError());

		busyFlightsRequest.setOrigin("XX");
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is4xxClientError());

		busyFlightsRequest.setOrigin("XXXX");
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is4xxClientError());

		busyFlightsRequest.setOrigin("XXX");
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void validateDestinationTest() throws Exception {
		mockRestServices(busyFlightsRequest);

		busyFlightsRequest.setDestination("");
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is4xxClientError());

		busyFlightsRequest.setDestination("XX");
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is4xxClientError());

		busyFlightsRequest.setDestination("XXXX");
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is4xxClientError());

		busyFlightsRequest.setDestination("XXX");
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void retrieveOneResultTest() throws Exception {
		CrazyAirResponse crazyAirResponse = new CrazyAirResponse("TAM", 1.00, "E", "RIO", "NYC", "01-01-2018",
				"01-01-2018");
		mockRestService(busyFlightsRequest, crazyAirResponse);
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is2xxSuccessful());
		BusyFlightsResponseList responseList = service.findAndSortByFare(busyFlightsRequest);
		assertTrue(responseList.getResponses().size() == 1);
	}

	@Test
	public void retrieveTwoResultTest() throws Exception {
		CrazyAirResponse crazyAirResponse = new CrazyAirResponse("TAM", 1.00, "E", "RIO", "NYC", "01-01-2018",
				"01-01-2018");
		ToughJetResponse toughJetResponse = new ToughJetResponse("AZL", 8, 2, .2, "RIO", "NYC", "01-01-2018", 
				"01-01-2018");
		
		mockRestService(busyFlightsRequest, crazyAirResponse, toughJetResponse);
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is2xxSuccessful());
		BusyFlightsResponseList responseList = service.findAndSortByFare(busyFlightsRequest);
		assertTrue(responseList.getResponses().size() == 2);
		assertTrue(responseList.getResponses().get(0).getSupplier().equals(Supplier.CrazyAir));
		assertTrue(responseList.getResponses().get(1).getSupplier().equals(Supplier.ToughJet));
	}
	
	@Test
	public void responseListSortTest() throws Exception {
		CrazyAirResponseList crazyAirResponseList = new CrazyAirResponseList();
		crazyAirResponseList.addResponse(new CrazyAirResponse("003", 
															   10.44,
															   "E", "RIO", "NYC", "01-01-2018","01-01-2018"));
		crazyAirResponseList.addResponse(new CrazyAirResponse("001", 
															   10.04,
															   "E", "RIO", "NYC", "01-01-2018","01-01-2018"));
		crazyAirResponseList.addResponse(new CrazyAirResponse("002", 
															   10.19,
															   "E", "RIO", "NYC", "01-01-2018","01-01-2018"));

		ToughJetResponseList toughJetResponseList = new ToughJetResponseList();
		toughJetResponseList.addResponse(new ToughJetResponse("005", 
															  14, 0.65, 0, 
															  "RIO", "NYC", "01-01-2018","01-01-2018"));
		toughJetResponseList.addResponse(new ToughJetResponse("006", 
															  20, 2, .15, 
															  "RIO", "NYC", "01-01-2018","01-01-2018"));
		toughJetResponseList.addResponse(new ToughJetResponse("004", 
															  13, 0.58, .2, 
															  "RIO", "NYC", "01-01-2018","01-01-2018"));
		
		mockRestService(busyFlightsRequest, crazyAirResponseList, toughJetResponseList);
		
		this.mockMvc
				.perform(post("/flights").contentType(MediaType.APPLICATION_JSON).content(mockJson(busyFlightsRequest)))
				.andExpect(status().is2xxSuccessful());
		
		BusyFlightsResponseList responseList = service.findAndSortByFare(busyFlightsRequest);
		assertTrue(responseList.getResponses().size() == 6);
		assertTrue(responseList.getResponses().get(0).getAirline().equals("001"));
		assertTrue(responseList.getResponses().get(1).getAirline().equals("002"));
		assertTrue(responseList.getResponses().get(2).getAirline().equals("003"));
		assertTrue(responseList.getResponses().get(3).getAirline().equals("004"));
		assertTrue(responseList.getResponses().get(4).getAirline().equals("005"));
		assertTrue(responseList.getResponses().get(5).getAirline().equals("006"));
	}
}
