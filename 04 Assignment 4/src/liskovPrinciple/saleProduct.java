package liskovPrinciple;

class SaleProduct extends Product {
	
    private double discountPercentage;

    public SaleProduct(String name, double price, double discountPercentage) {
        super(name, price);
        this.discountPercentage = discountPercentage;
    }

    public double calculateDiscount() {
		double productPrice = getPrice();
		return (productPrice * discountPercentage) / 100;
    }
    
}
