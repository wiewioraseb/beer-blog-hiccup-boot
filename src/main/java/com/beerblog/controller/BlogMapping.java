package main.java.com.beerblog.controller;
 
import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8080/beer-blog-hiccup/
 
@Controller
public class BlogMapping {
	
	
	@RequestMapping("/log-in.html")
	public String about(Model model){
		
		DateFormat dFormat = DateFormat.getDateTimeInstance();
		String dateAndTime = dFormat.format(new Date()); 		
		model.addAttribute("serverTime", dateAndTime);
		
		return "log-in"; 
	}
	
	
	@RequestMapping("/contact.html")
	public String contact(){
		return "contact"; 
	}
	
	
} // END OF CLASS

