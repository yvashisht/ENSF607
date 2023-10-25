package dependencyInversionPrinciple;

class ProductController {
	
    private WarehouseProduct product;

    public ProductController(WarehouseProduct product) {
        this.product = product;
    }

    public void control() {
        if (product.isAvailable()) {
            product.purchase();
        } else {
            product.notifyOutOfStock();
        }
    }
}

