package com.setec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.setec.bot.MyTelegramBot;
import com.setec.entities.Booked;
import com.setec.repos.BookedRepo;

@Controller
public class MyController {

	@Autowired
	private MyTelegramBot bot;
	
	@GetMapping({"/", "/home"})
	public String home(Model mod) {
		Booked obj = new Booked
				();
		
		mod.addAttribute("obj",obj);
		return "index";
	}
	
	@GetMapping({"/about"})
	public String about() {
		return "about";
	}
	
	@GetMapping({"/service"})
	public String service() {
		return "service";
	}
	
	@GetMapping({"/menu"})
	public String menu() {
		return "menu";
	}
	
	@GetMapping({"/reservation"})
	public String reservation(Model mod) {
		Booked obj = new Booked(
				1,"leapheng","leapheng@gmail.com",
				"016554130",
				"12/25/2024",
				"16:33",
				5
				);
		
		mod.addAttribute("obj",obj);
		return "reservation";
	}
	
	@GetMapping({"/testimonial"})
	public String testimonial() {
		return "testimonial";
	}
	
	@GetMapping({"/contact"})
	public String contact() {
		return "contact";
	}
	
	@Autowired
	private BookedRepo bookedRepo;
	
	
	@GetMapping("/booked")
	  public String getAllBookings(Model model) {
	    List<Booked> bookedList = bookedRepo.findAll();
	    model.addAttribute("bookedList", bookedList);
	    return "booked";
	  }
	@PostMapping("/booked")
	public String booked(@ModelAttribute(name = "obj") Booked obj) {
	    bookedRepo.save(obj);
	    
	    bot.send(obj.toString());  // Now it sends the formatted message.
	    return "redirect:/booked";
	}

	
}
