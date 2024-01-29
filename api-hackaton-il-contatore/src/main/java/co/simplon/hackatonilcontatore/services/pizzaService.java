package co.simplon.hackatonilcontatore.services;

import org.springframework.http.ResponseEntity;

import co.simplon.hackatonilcontatore.dtos.PizzaDto;

public interface pizzaService {
	public ResponseEntity<Object> createPizza(PizzaDto pizzaDto);
	public ResponseEntity<Object> findPizza();//
	public ResponseEntity<Object> listPizza();
	
	

}
