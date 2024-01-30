package co.simplon.hackatonilcontatore.controllers;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hackatonilcontatore.entities.Order;
import co.simplon.hackatonilcontatore.repositories.IngredientRepository;
import co.simplon.hackatonilcontatore.repositories.OrderRepository;
import co.simplon.hackatonilcontatore.repositories.PizzaRepository;

@Service
@RestController
@RequestMapping("/orders")
public class OrderController {
	private final OrderRepository orderRepository;
	
	public OrderController(OrderRepository orderRepository) {
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
	
	@DeleteMapping("delete/{$id}")
	public void deleteOrder() {
		
	}
	
}
