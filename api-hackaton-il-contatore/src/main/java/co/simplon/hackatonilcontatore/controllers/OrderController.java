package co.simplon.hackatonilcontatore.controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hackatonilcontatore.dtos.OrderDto;
import co.simplon.hackatonilcontatore.entities.Order;
import co.simplon.hackatonilcontatore.repositories.OrderRepository;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private final OrderRepository orderRepository;
	
	public OrderController(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	
	@PostMapping("create")
	public void createOrder(OrderDto imputs) {
		Order order = new Order();
		order.setOrderNumber(null);
		order.setStatus("en cours");
		order.setDateTime(LocalDateTime.now());
		//Pizza pizza = ;
		//order.setPizza(pizza);
	}
	@GetMapping("find-all")
	public List<Order> listOrder() {
		List<Order> orders = orderRepository.findAll();
		return orders;
		
	}
	
	@GetMapping("find/{$id}")
	public void findOrder() {	
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteOrder() {
		
	}
	
}
