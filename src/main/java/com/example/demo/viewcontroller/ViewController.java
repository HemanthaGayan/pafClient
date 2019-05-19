package com.example.demo.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Order;
import com.example.demo.model.User;

@Controller
@RequestMapping("/View")
public class ViewController {
	
	@RequestMapping("/")
	public String fristPage() {
		return "first";
	}
	
	@RequestMapping("/products")
	public String products() {
		return "products";
	}
	
	@RequestMapping("/order")
	public String order(@ModelAttribute Order order) {
		return "allorder";
	}
	
	
	
	
	
	
}
