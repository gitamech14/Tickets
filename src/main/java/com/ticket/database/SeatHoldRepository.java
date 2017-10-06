package com.ticket.database;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.model.Customer;
import com.ticket.model.SeatHold;

import java.util.Date;
import java.util.List;


@Repository
public interface SeatHoldRepository extends JpaRepository<SeatHold, Long>{
	List<com.ticket.model.SeatHold> findByConfirmationCodeIsNullAndHoldTimeBefore(Date date);
	List<SeatHold> findByCustomer(Customer customer);
}
