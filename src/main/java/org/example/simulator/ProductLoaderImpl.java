package org.example.simulator;

import java.util.ArrayList;
import java.util.List;

public class ProductLoaderImpl implements ProductLoader {

	public List<IProduct> loadProducts() {
		List<IProduct> products= new ArrayList<>();
		return products;
	}

	public Ingredient getSugar() {
		Ingredient sugar =new Ingredient();
		sugar.setName("sugar");
		sugar.setPrice(0.01);
		return sugar;
	}

}
