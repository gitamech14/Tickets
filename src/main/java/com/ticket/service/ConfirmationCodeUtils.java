package com.ticket.service;


import java.util.UUID;

public class ConfirmationCodeUtils {

	private ConfirmationCodeUtils() {}

	public static String generateCode(int seatHoldId, String customerEmail) {
		String name = String.join(":", "Tickets", customerEmail, String.valueOf(seatHoldId));
		UUID uuid = UUID.nameUUIDFromBytes(name.getBytes());
		return uuid.toString();
	}
}
