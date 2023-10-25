package SingleResponsibilityPrinciple;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
	

	private List<Product> products;
	
	public ProductCatalog() {
		products = new ArrayList<>();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void removeProduct (Product product) {
		products.remove(product);
	}

}
