package org.yourname.dto;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FlightSearchResponse {

	private String flightCode;

	private double price;

	private final static NumberFormat PRICE_FORMAT = new DecimalFormat("#0.00");

	public FlightSearchResponse(String flightCode, Double price) {
		this.flightCode = flightCode;
		this.price = price;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public double getPrice() {

		return Double.valueOf(PRICE_FORMAT.format(price));
	}

	public void setPrice(double price) {
		this.price = price;
	}
}