package co.simplon.hackatonilcontatore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hackatonilcontatore.entities.NewOrder;
import co.simplon.hackatonilcontatore.repositories.NewOrderRepository;
import co.simplon.hackatonilcontatore.repositories.OrderRepository;

@RestController
@RequestMapping("/new-order")
public class NewOrderController {

    private final OrderRepository orderRepository;
    private final NewOrderRepository newOrderRepository;

    public NewOrderController(
	    OrderRepository orderRepository,
	    NewOrderRepository newOrderRepository) {
	this.orderRepository = orderRepository;
	this.newOrderRepository = newOrderRepository;

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping
    public void createOrder(@RequestBody NewOrder inputs) {
	NewOrder order = new NewOrder();
	order.setOrderNumber(getNextRomanLetter());
	order.setStatus("en cours");
	order.setSize(inputs.getSize());
	order.setShape(inputs.getShape());
	order.setBase(inputs.getBase());
	order.setIngredients(inputs.getIngredients());
	order.setOil(inputs.getOil());
	order.setPrice(inputs.getPrice());
	newOrderRepository.save(order);
    }

    private static final List<String> ROMAN_LETTERS = createRomanAlphabetList();
    private static int currentIndex = 0;

    public static List<String> createRomanAlphabetList() {
	List<String> alphabet = new ArrayList<>();

	// Ajouter les lettres de l'alphabet latin en majuscules romaines
	for (char letter = 'A'; letter <= 'Z'; letter++) {
	    alphabet.add(String.valueOf(letter));
	}
	return alphabet;
    }

    public static String getNextRomanLetter() {
	String nextLetter = ROMAN_LETTERS.get(currentIndex);
	currentIndex = (currentIndex + 1) % 26; // Reset to 0 if end is reached
	return nextLetter;
    }

    @GetMapping("/order/{id}")
    public NewOrder findOrder(@PathVariable("id") Long id) {
	return newOrderRepository.findProjectedById(id);
    }

    @GetMapping("/find-all")
    public List<NewOrder> listOrder() {
	List<NewOrder> orders = newOrderRepository
		.findAll();
	return orders;

    }
}
