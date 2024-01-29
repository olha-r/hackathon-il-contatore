package co.simplon.hackatonilcontatore.dtos;

public class PizzaDto {
	private String size;
	private String shape;
	private String base;
	private String[] ingredients;
	private Long oil;
	
	public PizzaDto() {
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

	
	
}
