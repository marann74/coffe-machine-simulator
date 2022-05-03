package org.example.simulator;

import java.util.List;

public interface ProductLoader {
	List<IProduct> loadProducts();
	Ingredient getSugar();
}
