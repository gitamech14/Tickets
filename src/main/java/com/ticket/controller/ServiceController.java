package com.ticket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.ticket.model.RemainingSeats;
import com.ticket.model.ReservationResult;
import com.ticket.service.TicketService;
@RestController
@RequestMapping(value = "/tickets")
public class ServiceController {

	@Autowired
	private TicketService ticketService;

	@RequestMapping(value="/seats/venue", method=RequestMethod.GET)
	public RemainingSeats getSeats(@RequestParam(value="level", required=false) String level) {
		int numOfAvailSeats = ticketService.numSeatsAvailable(level);
		return new RemainingSeats(level, numOfAvailSeats);
	}
	
	@RequestMapping(value="/hold/{id}/email/{email}/reserve", method=RequestMethod.POST)
	public ReservationResult reserveSeats(@PathVariable Integer id, @PathVariable String email) {
		return new ReservationResult(id, email, ticketService.reserveSeats(id, email));
	}
}
