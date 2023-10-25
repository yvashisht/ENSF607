package dependencyInversionPrinciple;

class WarehouseProduct extends Product {
    private boolean available;

    public WarehouseProduct(String name, double price) {
        super(name, price);
        this.available = true; 
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void purchase() {
        if (available) {
            System.out.println(getName() + " has been purchased.");
            available = false; 
        } else {
            System.out.println(getName() + " is out of stock and cannot be purchased.");
        }
    }

    public void notifyOutOfStock() {
        if (!available) {
            System.out.println("Notification: " + getName() + " is out of stock.");
        }
    }
}

