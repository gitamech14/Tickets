package com.ticket.service;

import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.database.SeatHoldRepository;
import com.ticket.database.SeatOrderRepository;
import com.ticket.database.VenueRepository;
import com.ticket.model.Customer;
import com.ticket.model.SeatHold;
import com.ticket.model.SeatOrder;
import com.ticket.model.Venue;


@Service("ticketService")

public class TicketServiceImpl implements TicketService {

	private static Logger log = Logger.getLogger(TicketServiceImpl.class);

	@Autowired
	private VenueRepository venueRepository;

	@Autowired
	private SeatOrderRepository seatOrderRepository;
	
	@Autowired
	private SeatHoldRepository seatHoldRepository;

	@Override
	public int numSeatsAvailable(String venueLevel) {
		if(!venueLevel.equals(null)) {		
				return venueRepository.findSeatsAtEachVenues(venueLevel);
			}else {
			// If no venueLevel is given, search total available seat through whole levels
			List<Venue> venues = venueRepository.findAllInAllVenues();
			return venues.stream().mapToInt(venue -> getAvailableSeatsInVenueLevel(venue)).sum();
		}
	}

	private int getAvailableSeatsInVenueLevel(Venue venue) {
		List<SeatOrder> seatOrders = seatOrderRepository.findByVenue(venue);
		int numberOfSeatTaken = seatOrders.stream().mapToInt(SeatOrder::getNumberOfSeats).sum();
		int totalNumberOfSeat = venue.getNumberOfRow() * venue.getSeatsInRow();
		return totalNumberOfSeat - numberOfSeatTaken;
	}
	
	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {
		Customer customer = null;
		if(null == customer || !StringUtils.equalsIgnoreCase(customer.getEmail(), customerEmail)) {
			StringBuilder errorMessage = new StringBuilder("Customer Eamil Validation on SeatHold fail, seatHoldId: ")
					.append(seatHoldId)
					.append(", customerEmail: ")
					.append(customerEmail);
			log.error(errorMessage.toString());
		}

		// generate confirmation code and check in the hold as reservation
		String code = ConfirmationCodeUtils.generateCode(seatHoldId, customerEmail);
		SeatHold seatHold = new SeatHold();
		seatHold.setConfirmationCode(code);
		seatHold.setReservationTime(new Date());
		seatHoldRepository.save(seatHold);
		String message = new StringBuilder("Reserved Seat for email: ")
				.append(customerEmail)
				.append(", seatHoldId: ")
				.append(seatHoldId)
				.append(", confirmationCode: ")
				.append(code)
				.toString();
		log.info(message);
		return code;
	}

}
