package OpenClosedPrinciple;

public class standardProduct extends Product {
	
	public standardProduct(String name, double price) {
		super (name, price);
	}
	
	
	@Override
	public double calculateDiscount() {
		return 0;
	}

}
