package co.simplon.hackatonilcontatore.dtos;

public class IngredientDto {
	private String name;
	private Long quantity;
	
	public IngredientDto() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
