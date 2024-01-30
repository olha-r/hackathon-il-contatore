package co.simplon.hackatonilcontatore.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "new_order")
public class NewOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "order_status")
    private String status;

    @Column(name = "pizza_size")
    private String size;

    @Column(name = "shape")
    private String shape;

    @Column(name = "base")
    private String base;

    @Column(name = "ingredients")
    private List<String> ingredients;

    @Column(name = "oil")
    private Boolean oil;

    @Column(name = "price")
    private double price;

    public NewOrder() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public String getSize() {
	return size;
    }

    public void setSize(String size) {
	this.size = size;
    }

    public String getShape() {
	return shape;
    }

    public void setShape(String shape) {
	this.shape = shape;
    }

    public String getBase() {
	return base;
    }

    public void setBase(String base) {
	this.base = base;
    }

    public List<String> getIngredients() {
	return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
	this.ingredients = ingredients;
    }

    public Boolean getOil() {
	return oil;
    }

    public void setOil(Boolean oil) {
	this.oil = oil;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    @Override
    public String toString() {
	return String.format(
		"{id=%s, orderNumber=%s, status=%s, size=%s, shape=%s, base=%s, ingredients=%s, oil=%s, price=%s}",
		id, orderNumber, status, size, shape, base,
		ingredients, oil, price);
    }

}
