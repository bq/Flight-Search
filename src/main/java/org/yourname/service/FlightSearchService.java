package org.yourname.service;

import java.util.List;

import org.yourname.dto.FlightSearchRequest;
import org.yourname.dto.FlightSearchResponse;

public interface FlightSearchService {

	List<FlightSearchResponse> findFlights(FlightSearchRequest flightRequest);

}
