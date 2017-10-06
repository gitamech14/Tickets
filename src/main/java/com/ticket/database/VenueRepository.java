package com.ticket.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ticket.model.Venue;

@Repository
public interface VenueRepository{
	int findSeatsAtEachVenues(String Venue);
	
	List<Venue> findAllInAllVenues();
}
