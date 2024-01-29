package co.simplon.hackatonilcontatore.entities;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {
	@Column(name = "id")
	private Long id;
	@Column(name = "pizza_size")
	private String size;
	@Column(name = "shape")
	private String shape;
	@Column(name = "base")
	private String base;
	@Column(name = "ingredient")
	private String[] ingredients;
	@Column(name = "oil")
	private Long oil;
	
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

	public String[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}

	public Long getOil() {
		return oil;
	}

	public void setOil(Long oil) {
		this.oil = oil;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", size=" + size + ", shape=" + shape + ", base=" + base + ", ingredients="
				+ Arrays.toString(ingredients) + ", oil=" + oil + "]";
	}

	
	
	
}
