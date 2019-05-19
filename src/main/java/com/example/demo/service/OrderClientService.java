package com.example.demo.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.*;


@Service
public class OrderClientService {
	
	public List<Order> getAllOrders(){
		RestTemplate restTemplate = new RestTemplate();
		List<Order> order = restTemplate.getForObject("http://localhost:8085/api/orders",List.class);
		return order;
	}
	
	public List<Product> getAllProducts(){
		RestTemplate restTemplate = new RestTemplate();
		List<Product> product = restTemplate.getForObject("http://localhost:11088/api/list",List.class);
		return product;
	}
	
	public void createOrder(Order order) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForLocation("http://localhost:8085/api/addorders",order,Order.class);
	}
	
	public Order findOrderById(Order order){
		RestTemplate restTemplate = new RestTemplate();
		String id = order.getOrder1();
        return restTemplate.getForObject("http://localhost:8085/api/orders/" +id, Order.class);
    }
	
	public void updateOrder(Order order) {
		RestTemplate restTemplate = new RestTemplate();
		Long id = order.getOrderId();
	    restTemplate.put("http://localhost:8085/api/orders/"+id,order);
	}
	
	public void deleteOrder(Order order) {
	
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8085/api/delete/"+order.getOrderId(),order);
	}

	
    }


