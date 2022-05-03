package org.example.simulator;
import java.util.HashMap;
import java.util.Map;

public class Simulator {
	private Map<String, IProduct> products = new HashMap<>();
	private Ingredient sugar;
	
	public Simulator(ProductLoader productLoader) {
		for(IProduct product: productLoader.loadProducts()) {
			products.put(product.getName(), product);
		}
		sugar = productLoader.getSugar();
	}

	public void process(String request) {
		if( request == null  ||  request.isEmpty()) {
			log("Invalid request");
			return;
		}
		String [] parts= splitRequest(request);
		if( parts == null ) {
			log("Invalid request");
			return;
		}
		if( !products.containsKey(parts[0].trim())) {
			log("Product not found");
			return;
		}
		IProduct product = products.get(parts[0].trim());
		int sugarQty = (parts.length == 1)? 0: Integer.valueOf(parts[1].trim());
		double sugarSurplus = sugarQty*sugar.getPrice();
		log(String.format("EUR %.2f Description: %s with %d sugar units, parts", product.getPrice()+sugarSurplus, sugarQty));
	}
	
	private String[] splitRequest(String request) {
		for(int j= request.length()-1; j>0; j--) {
			if(!Character.isDigit(request.charAt(j))) {
				return new String[] {request.substring(0, j), request.substring(j+1) };
			} 
		}
		return null;
	}
	
	
	
	private void log(String message) {
		System.out.println(message);
	}

}
