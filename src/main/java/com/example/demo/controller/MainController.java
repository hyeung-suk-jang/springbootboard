package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value ={  "/", "/main", "/home", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("name", "SpringBlog from Millky");
		System.out.println("main controller!!!");
		return "index";
	}
	
	@RequestMapping("/tiles")
	public String main(Model model) {
		return "site.googleMap.main";
	}
	
}
