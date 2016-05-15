package main.java.com.beerblog.controller;

import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.beerblog.entity.BlogEntry;
import main.java.com.beerblog.service.EntryService;

@Controller
public class EntryController {

	@Autowired
	private EntryService entryService;
	
	
	@ModelAttribute("entry") // <form:form commandName="entry">
	public BlogEntry construct(){
		return new BlogEntry();
	}
	
	
	@RequestMapping("/welcome")
	public ModelAndView welcomePage(Model model) {

		String message = "<div align='center'>"
				+ "<h3>********** Beer Blog **********</h3>";
		
		model.addAttribute("entries_desc", entryService.findAllReversed());
		model.addAttribute("entries_asc", entryService.findAll());
		
		return new ModelAndView("welcome", "message", message);
	}
	
	
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public String doSubmitEntry(@ModelAttribute("entry") BlogEntry entry){
		entry.setPublishedDate(new Date());
		entryService.save(entry);
		//Collections.reverse((List<?>) entry);
		return "redirect:/welcome.html?entry_successful=true";
	}
	
	
	@RequestMapping("/delete_entry/{id}")
	public String deletingEntry(@ModelAttribute("entry") BlogEntry entry, @PathVariable int id){
		entryService.delete(id);
		return "redirect:/welcome.html";
	}

	
}
