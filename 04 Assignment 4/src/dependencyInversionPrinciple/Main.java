package dependencyInversionPrinciple;

public class Main {
	
    public static void main(String[] args) {
    	
        WarehouseProduct product = new WarehouseProduct("Product A", 50.0);
        ProductController controller = new ProductController(product);
        controller.control();
        
    }
}

