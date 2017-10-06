package com.ticket.service;

public interface TicketService {

	String reserveSeats(int seatHoldId, String customerEmail);

	int numSeatsAvailable(String venueLevel);
}
