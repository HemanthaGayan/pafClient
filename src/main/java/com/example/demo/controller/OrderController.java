package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.*;
import com.example.demo.service.OrderClientService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderClientService orderClientService;
	
	@RequestMapping("/addorder")
	public String getAddOrder(@ModelAttribute Order order,ModelMap model,@RequestParam("ProductName") String productname,
			@RequestParam ("Price") String price,@RequestParam ("Quantity") String quantity) {
		double price1 = Double.parseDouble(price);
		double quty = Double.parseDouble(quantity);
		double total = price1 * quty;
		model.put("productname",productname);
		model.put("price",price);
		model.put("quantity",quantity);
		model.put("totalPrice", total);
		return "addorder";
	}
	
	@GetMapping("/allproducts")
	public String getAllProduct(Model model,@ModelAttribute Order order) {
			List<Product>  product = orderClientService.getAllProducts();
			model.addAttribute("products", product);
			return "products";
	}
	
	@GetMapping("/allorder")
	public String getAllOrders(@ModelAttribute Order order,Model model) {
		List<Order> order1 = orderClientService.getAllOrders();
		model.addAttribute("orders", order1);
		return "allorder";
	}
	
	@PostMapping("/create")
	public String createUser(@ModelAttribute Order order) {
		
		orderClientService.createOrder(order);
		
		return "redirect:allorder";
	}
	@RequestMapping("/id")
	public String getOrderById(@ModelAttribute Order order,ModelMap model) {
		Order order1=orderClientService.findOrderById(order);
		model.addAttribute("order",order1);
		model.put("value","UpdateOrder");
		model.put("key","price");
		return "order";
	}
	@RequestMapping("/UpdateOrder")
	public String updateOrder(@ModelAttribute Order order,ModelMap model) {
		double price1 = Double.parseDouble(order.getPrice());
		double quty = Double.parseDouble(order.getQuantity());
		double total = price1 * quty;
		order.setTotalPrice1(total);
		model.put("key","price1");
		model.put("value","ConfirmOrder");
		model.addAttribute("order",order);
		return "updateorder";
	}
	@PostMapping("/confirm")
	public String confirmOrder(@ModelAttribute Order order) {
		orderClientService.updateOrder(order);
		return "first";
	}
	
	@PostMapping("/deleteorder")
	public String deleteShipDetail(@ModelAttribute Order order,Model model) {
		
		orderClientService.deleteOrder(order);
		model.addAttribute("orders",order);
		return "redirect:allorder";
		
		
	}

	
	

}
