package co.simplon.hackatonilcontatore.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pizza_size")
    private String size;

    @Column(name = "shape")
    private String shape;

    @Column(name = "base")
    private String base;

    @ManyToMany
    @JoinTable(name = "pizza_ingredients", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;

    @Column(name = "oil")
    private Long oil;

    @Column(name = "price")
    private double price;

    public Pizza() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public List<Ingredient> getIngredients() {
	return ingredients;
    }

    public void setIngredients(
	    List<Ingredient> ingredients) {
	this.ingredients = ingredients;
    }

    public Long getOil() {
	return oil;
    }

    public void setOil(Long oil) {
	this.oil = oil;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

}
