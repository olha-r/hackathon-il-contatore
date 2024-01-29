package co.simplon.hackatonilcontatore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hackatonilcontatore.entities.Order;
import co.simplon.hackatonilcontatore.repositories.IngredientRepository;
import co.simplon.hackatonilcontatore.repositories.OrderRepository;
import co.simplon.hackatonilcontatore.repositories.PizzaRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    private final PizzaRepository pizzaRepository;

    private final IngredientRepository ingredientRepository;

    public OrderController(OrderRepository orderRepository,
	    PizzaRepository pizzaRepository,
	    IngredientRepository ingredientRepository) {
	this.orderRepository = orderRepository;
	this.pizzaRepository = pizzaRepository;
	this.ingredientRepository = ingredientRepository;
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
