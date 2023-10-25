package interfaceSegregationPrinciple;

class SaleProduct implements Displayable {
	
	private String name;
	private double price;
	private double discountPercentage;

	public SaleProduct(String name, double price, double discountPercentage) {
	    this.name = name;
	    this.price = price;
	    this.discountPercentage = discountPercentage;
	    }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

	    @Override
	public String display() {
	    return name + " (Sale): $" + String.format("%.2f", price) + " (-" + discountPercentage + "%)";
	    }
	    
}

