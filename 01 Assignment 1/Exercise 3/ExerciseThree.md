## Exercise Three

## By: Yajur Vashisht

@startuml

	class Tool {

	+ toolID: int
	+ description: string
	+ quantity: int
	+ price: int
	+ supplierID: int

	}

	class Supplier {
	
	- supplierID: int
	- companyName: String
	- address: String
	- salesContact: 
	

	}

	class Order {
	
	- orderId: string
	- date: date
	- orderedItems: List<OrderedItem>

	}
	
	class OrderedItem {
	
	- description: string
	- amountOrdered: int
	+ supplier: Supplier

	}
	
	Interface InventoryManager {
	
	+ tool: List<Tool>
	+ suppliers: List<Supplier>
	+ addTool(tool: Tool)
	+ deleteTool(tool: Tool)
	+ searchToolbyName:
	+ searchToolbyID: 
	+ checkStockQuantity()
	+ generateOrderLine()
	+ generateOrderFile(order: Order)
	
	}
	
	InventoryManager <-- Order : uses
	InventoryManager <-- Supplier : uses
	InventoryManager <-- Tool : uses 
	InventoryManager <-- OrderedItem : uses

@enduml
