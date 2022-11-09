package com.deyagenao.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deyagenao.business.GuestService;
import com.deyagenao.business.ReservationService;
import com.deyagenao.business.RoomReservation;
import com.deyagenao.data.Guest;
import com.deyagenao.data.Room;
import com.deyagenao.util.DateUtils;

@RestController
@RequestMapping("/api")
public class WebserviceController {
	private final DateUtils dateUtils;
	private final GuestService guestService;
	private final ReservationService reservationService;
	
	public WebserviceController(DateUtils dateUtils, ReservationService reservationService,
			GuestService guestService) {
		this.dateUtils = dateUtils;
		this.guestService = guestService;
		this.reservationService = reservationService;
	} 
	
	@RequestMapping(path = "/reservations", method = RequestMethod.GET)
	public List<RoomReservation> getReservations(@RequestParam(value="date", required = false)
			String dateString){
		Date date = this.dateUtils.createDateFromDateString(dateString);
		
		return this.reservationService.getRoomReservationsForDate(date);
	}
	
	@GetMapping("/guests")
	public List<Guest> getHotelGuests(){
		return this.guestService.getAllGuests();
	}
	
	@PostMapping("/guests")
	@ResponseStatus(HttpStatus.CREATED)
	public void addNewGuest(@RequestBody Guest guest) {
		this.guestService.saveNewGuest(guest);
	}
	
	@GetMapping("/rooms")
	public List<Room> getHotelRooms(){
		return this.reservationService.getHotelRooms();
	}
	
}
