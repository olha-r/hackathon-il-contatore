package co.simplon.hackatonilcontatore.dtos;

import co.simplon.hackatonilcontatore.entities.Pizza;

public class OrderDto {
	private String orderNumber;
	private String status;
	private Pizza pizza;
	
	public OrderDto() {
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	
}
