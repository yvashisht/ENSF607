package OpenClosedPrinciple;

class saleProduct extends Product {
	
	private double discountPercentage;
	
	public saleProduct(String name, double price) {
		super(name, price);
	}
	

	public double calculateDiscount() {
		double productPrice = getPrice();
		return (productPrice * discountPercentage) / 100;
	}
	
}
