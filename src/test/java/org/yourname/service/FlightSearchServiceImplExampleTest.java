package org.yourname.service;

import static org.powermock.api.mockito.PowerMockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.yourname.dto.FlightSearchRequest;
import org.yourname.dto.FlightSearchResponse;

@RunWith(MockitoJUnitRunner.class)
public class FlightSearchServiceImplExampleTest {

	@Test
	public void findFlightsTest() {

		FlightSearchResponse flightSearchResponse = new FlightSearchResponse("code", 100.0);
		List<FlightSearchResponse> FlightSearchResponseList = Arrays.asList(flightSearchResponse);

		//Mock
		FlightSearchRequest flightSearchRequest = mock(FlightSearchRequest.class);

		//Stubbing

		//Invoke

		FlightSearchServiceImpl flightSearchServiceImpl = new FlightSearchServiceImpl();
		List<FlightSearchResponse> result = flightSearchServiceImpl.findFlights(flightSearchRequest);

		//Assert
		//assertTrue(result.get(0).getFlightCode().equalsIgnoreCase("code"));
		//assertTrue(result.get(0).getPrice() == 100.0);

		//Verify
	}
}
