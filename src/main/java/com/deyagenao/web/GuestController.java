package com.deyagenao.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.deyagenao.business.GuestService;
import com.deyagenao.data.Guest;

@Controller
@RequestMapping("/guests")
public class GuestController {

	private final GuestService guestService; 
	
	public GuestController(GuestService guestService) {
		this.guestService = guestService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAllGuests(Model model) {
		List<Guest> guests = this.guestService.getAllGuests();
		model.addAttribute("guests", guests);
		return "guests";
	}
}
