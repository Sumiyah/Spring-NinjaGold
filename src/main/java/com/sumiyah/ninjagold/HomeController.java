package com.sumiyah.ninjagold;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index(HttpSession session) {
		Integer gold = (Integer) session.getAttribute("gold");
		
        if (gold == null) {
        	session.setAttribute("gold", 0);
        	session.setAttribute("activity", new ArrayList<String>());
        	
        }
		return "index.jsp";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", 0);
    	session.setAttribute("activity", new ArrayList<String>());
    	return "index.jsp";
	}
	
	@RequestMapping(value = "/process_money", method = RequestMethod.POST)
	public String process(@RequestParam(value = "find") String find, 
			HttpSession session, 
			RedirectAttributes rAttributes) {
		
		Integer gold = (Integer) session.getAttribute("gold");
		@SuppressWarnings("unchecked")
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activity");
       
		if(find.equals("farm")) {
			int rand = (int)(Math.random() * (20 - 10 + 1)) + 10;
			gold += rand;
			session.setAttribute("gold", gold);
			System.out.println("clicked and processed form from FARM & got gold value of: "+ rand);
			
			LocalDateTime date = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String timeStamp = date.format(formatter);
			
			activities.add("Earned "+ rand + " gold from the Farm! - " + timeStamp);
			session.setAttribute("activity", activities);
			return "redirect:/";
		
		} else if(find.equals("cave")) {
			int rand = (int)(Math.random() * (10 - 5 + 1)) + 5;
			gold += rand;
			session.setAttribute("gold", gold);
			System.out.println("clicked and processed form from CAVE & got gold value of: "+ rand);
			
			LocalDateTime date = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String timeStamp = date.format(formatter);
			
			activities.add("Earned "+ rand + " gold from the Cave! - " + timeStamp);
			session.setAttribute("activity", activities);
			
			return "redirect:/";
		
		} else if(find.equals("house")) {
			int rand = (int)(Math.random() * (5 - 2 + 1)) + 2;
			gold += rand;
			session.setAttribute("gold", gold);
			System.out.println("clicked and processed form from HOUSE & got gold value of: "+ rand);
			
			LocalDateTime date = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String timeStamp = date.format(formatter);
			
			activities.add("Earned "+ rand + " gold from the House! - " + timeStamp);
			session.setAttribute("activity", activities);
			
			return "redirect:/";
		
		} else if(find.equals("casino")) {
			int rand = (int)(Math.random() * (50 - (-50) + 1)) + (-50);
			gold += rand;
			session.setAttribute("gold", gold);
			System.out.println("clicked and processed form from CASINO & got gold value of: "+ rand);
			
			LocalDateTime date = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String timeStamp = date.format(formatter);
			
	        if ( rand > 0) {
	        	activities.add("Earned "+ rand + " gold from the Casino! - " + timeStamp);
	        	session.setAttribute("activity", activities);
	        	return "redirect:/";
	        } else if ( rand < 0) {
	        	activities.add("Lost "+ rand + " gold from the Casino!!! OH NOOOO - " + timeStamp);
	        	session.setAttribute("activity", activities);
	        	return "redirect:/";
	        }
		}
		
		return "redirect:/";
	}
}
