package co.simplon.hackatonilcontatore.repositories;

import co.simplon.hackatonilcontatore.entities.Pizza;

public interface PizzaRepository {
	public Pizza create (Pizza pizza);
	public Pizza findAll ();
	public Pizza findOrderByName();
	public Pizza updateOrder();
	public Pizza deleteOrder();
}
