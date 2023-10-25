package liskovPrinciple;

import java.util.*;

public class shoppingCart {
	
    private List<Product> products;

    public void ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
