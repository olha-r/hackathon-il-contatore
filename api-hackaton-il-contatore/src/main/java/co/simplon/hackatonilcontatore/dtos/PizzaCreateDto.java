package co.simplon.hackatonilcontatore.dtos;

import java.util.List;

import co.simplon.hackatonilcontatore.entities.Ingredient;

public class PizzaCreateDto {
    private String size;
    private String shape;
    private String base;
    private List<Ingredient> ingredients;
    private Long oil;

    public PizzaCreateDto() {
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

}
