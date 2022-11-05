package com.deyagenao.util;

import java.util.List;
import java.util.Date;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.deyagenao.business.ReservationService;
import com.deyagenao.business.RoomReservation;
//import com.deyagenao.data.Guest;
//import com.deyagenao.data.GuestRepository;
//import com.deyagenao.data.Reservation;
//import com.deyagenao.data.ReservationRepository;
//import com.deyagenao.data.Room;
//import com.deyagenao.data.RoomRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{

	private final ReservationService reservationService;
	private final DateUtils dateUtils;
	
	public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
		this.reservationService = reservationService;
		this.dateUtils = dateUtils;
	}
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Date date = this.dateUtils.createDateFromDateString("2022-01-01");
		List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
		reservations.forEach(System.out::println);
	}

}
