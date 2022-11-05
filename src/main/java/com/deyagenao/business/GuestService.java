package com.deyagenao.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.deyagenao.data.Guest;
import com.deyagenao.data.GuestRepository;

@Service
public class GuestService {
	
	private final GuestRepository guestRepository;

	public GuestService(GuestRepository guestRepository) {
		this.guestRepository = guestRepository;
	}
	
	public List<Guest> getAllGuests(){
		Iterable<Guest> guests = this.guestRepository.findAll();
		
		List<Guest> guestList = new ArrayList<>();
		guests.forEach(guest -> guestList.add(guest));
		
		return guestList;
	}
}
