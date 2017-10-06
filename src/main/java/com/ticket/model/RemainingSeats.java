package com.ticket.model;

public class RemainingSeats {
	private String venueLevel;
	private Integer numberOfAvailableSeats;

	public RemainingSeats() {}

	public RemainingSeats(String venueLevel, Integer numberOfAvailableSeats) {
		this.venueLevel = venueLevel;
		this.numberOfAvailableSeats = numberOfAvailableSeats;
	}

	public String getVenueLevel() {
		return venueLevel;
	}
	public void setVenueLevel(String venueLevel) {
		this.venueLevel = venueLevel;
	}
	public Integer getNumberOfAvailableSeats() {
		return numberOfAvailableSeats;
	}
	public void setNumberOfAvailableSeats(Integer numberOfAvailableSeats) {
		this.numberOfAvailableSeats = numberOfAvailableSeats;
	}
}
