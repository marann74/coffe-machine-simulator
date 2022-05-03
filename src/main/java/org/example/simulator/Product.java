package org.example.simulator;
import java.util.ArrayList;
import java.util.List;

public class Product implements IProduct {
	private List<Element> compositions= new ArrayList<>();
	private final String name;
	
	class Element {
		Ingredient ingredient;
		double quantity;
		
		public Element(Ingredient ingredient, int quantity) {
			this.ingredient = ingredient;
			this.quantity = quantity;
		}
	}
	
	public Product(String name) {
		this.name = name;
	}
	
	public void addIngredient(int quantity, Ingredient ingredient) {
		this.compositions.add(new Element(ingredient, quantity));
	}

	public String getDescription() {
		StringBuilder builder = new StringBuilder();
		boolean isNOtFirst = false;
		for(Element element: compositions) {
			if( isNOtFirst ) {
				builder.append(", ");
			} else {
				isNOtFirst = false;
			}
			builder.append(String.format("%d unit of %s",  element.ingredient.getName()));
		}
		return builder.toString();
	}
	
	public Double getPrice() {
		double price = 0;
		for(Element element: compositions) {
			price+= element.quantity * element.ingredient.getPrice();
		}
		return price;
	}

	public String getName() {
		return name;
	}

	
}
