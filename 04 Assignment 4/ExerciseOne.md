## ENSF 607 Lab #4 - ExerciseOne PlantUML/Class Diagrams

The theme for this Assignment is an E-commerce Product Management Software in Java. All of the SOLID Principles will be applied to designing this 
along with the provided diagrams and code.

#Plant UML Code:

Single Responsibility Principle:

	@startuml
	
	class Product {
	- name: String
	- price: double
	+ Product(String name, double price)
	+ getName(): String
	+ setName(name: String)
	+ getPrice(): double
	+ setPrice(price: double)
	}
	
	class ProductCatalog {
	- products: List<products>
	+ addProduct: (product: Product)
	+ removeProduct: (product; Product)
	}
	
	@enduml
	
Open/Closed Principle:

	@startuml
	
	abstract class Product {
	- name: String
	- price: double
	+ Product(String name, double price)
	+ getName(): String
	+ setName(name: String)
	+ getPrice(): double
	+ setPrice(price: double)
	+ {abstract} calculateDiscount(): double
	}
	
	class StandardProduct {
	+ calculateDiscount(): double
	}
	
	class SaleProduct {
	- discountPercentage(): double
	+ calculateDiscount(): double
	}
	
	Product -> SaleProduct : extends
	Product -> StandardProduct : extends
	
	@enduml
	
Liskov Principle:

	@startuml
	
	class Product {
	  -name: String
	  -price: double
	  +Product(name: String, price: double)
	  +getName(): String
	  +setName(name: String)
	  +getPrice(): double
	  +setPrice(price: double)
	  +calculateDiscount(): double
	}
	
	class StandardProduct {
	  +StandardProduct(name: String, price: double)
	  +calculateDiscount(): double
	}
	
	class SaleProduct {
	  -discountPercentage: double
	  +SaleProduct(name: String, price: double, discountPercentage: double)
	  +calculateDiscount(): double
	}
	
	class Cart {
	  -products: List<Product>
	  +Cart()
	  +addProduct(product: Product)
	}
	
	Product <|-- StandardProduct
	Product <|-- SaleProduct
	Cart "1" *-- "0" Product
	
	@enduml
	
Interface Segregation Principle: 

	@startuml
	
	interface Displayable {
	  +display(): String
	}
	
	class Product {
	  -name: String
	  -price: double
	  +Product(name: String, price: double)
	  +getName(): String
	  +setName(name: String)
	  +getPrice(): double
	  +setPrice(price: double)
	}
	
	class SaleProduct {
	  -discountPercentage: double
	  +SaleProduct(name: String, price: double, discountPercentage: double)
	  +calculateDiscount(): double
	}
	
	class Cart {
	  -products: List<Displayable>
	  +Cart()
	  +addProduct(product: Displayable)
	}
	
	Product --|> Displayable
	SaleProduct --|> Displayable
	Cart "1" *-- "0..*" Displayable
	
	@enduml

Dependency Inversion Principle:

	@startuml
	
	interface Product {
	  +isAvailable(): boolean
	  +purchase()
	  +notifyOutOfStock()
	}
	
	class WarehouseProduct {
	  -available: boolean
	  +WarehouseProduct(name: String, price: double)
	  +isAvailable(): boolean
	  +purchase()
	  +notifyOutOfStock()
	}
	
	class ProductController {
	  -product: Product
	  +ProductController(product: Product)
	  +control()
	}
	
	Product <|.. WarehouseProduct
	ProductController --> Product
	
	@enduml
