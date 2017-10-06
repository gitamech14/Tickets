package com.ticket.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

public class SeatHold implements Serializable {

	private static final long serialVersionUID = -655586672728569618L;

	private Integer id;
	private Date holdTime;
	private Customer customer;
	private String confirmationCode;
	private Date reservationTime;
	private Set<SeatOrder> seatOrders = new HashSet<>();
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getHoldTime() {
		return holdTime;
	}
	public void setHoldTime(Date holdTime) {
		this.holdTime = holdTime;
	}


	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name="RESERVATION_CONFIRMATION_CODE")
	public String getConfirmationCode() {
		return confirmationCode;
	}
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	public Date getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}

	public Set<SeatOrder> getSeatOrders() {
		return seatOrders;
	}
	public void setSeatOrders(Set<SeatOrder> seatOrders) {
		this.seatOrders = seatOrders;
	}

}
