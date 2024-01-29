package co.simplon.hackatonilcontatore.controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.simplon.hackatonilcontatore.dtos.OrderDto;
import co.simplon.hackatonilcontatore.entities.Order;
import co.simplon.hackatonilcontatore.services.OrderService;

public class OrderController {
	private final OrderService orderService;
	@PostMapping("create")
	public void createOrder(OrderDto imputs) {
		Order order = new Order();
		order.setOrderNumber(null);
		order.setStatus("en cours");
		order.setDateTime(LocalDateTime.now());
		Pizza pizza = 
		order.setPizza(pizza);
	}
	@GetMapping("find-all")
	public void listOrder() {
		
	}
	
	@GetMapping("find/{#id}")
	public void listOrder() {
		
	}
	
}
