package com.deyagenao.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deyagenao.business.ReservationService;
import com.deyagenao.business.RoomReservation;
import com.deyagenao.util.DateUtils;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {
	
	private final DateUtils dateUtils;
	private final ReservationService reservationService;
	
	public RoomReservationController(DateUtils dateUtils, ReservationService reservationService) {
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
	} 
	
	@RequestMapping(method = RequestMethod.GET)
	public String getReservations(@RequestParam(value="date", required= false) String dateString, 
			Model model) {
		Date date = this.dateUtils.createDateFromDateString(dateString);
		List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", roomReservations);
		return "roomres";
	}
}