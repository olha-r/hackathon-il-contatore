package co.simplon.hackatonilcontatore.dtos;

import java.util.List;

import co.simplon.hackatonilcontatore.entities.Pizza;

public class OrderDto {
    private String orderNumber;
    private String status;
    private List<Pizza> pizza;

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

    public List<Pizza> getPizza() {
	return pizza;
    }

    public void setPizza(List<Pizza> pizza) {
	this.pizza = pizza;
    }

}
