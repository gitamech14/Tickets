package com.ticket.database;
 
import org.springframework.stereotype.Repository;

import com.ticket.model.SeatHold;
import com.ticket.model.SeatOrder;
import com.ticket.model.Venue;

import java.util.List;


@Repository
public interface SeatOrderRepository{
	List<SeatOrder> findBySeatHold(SeatHold seathold);
	List<SeatOrder> findByVenue(Venue venue);
}
