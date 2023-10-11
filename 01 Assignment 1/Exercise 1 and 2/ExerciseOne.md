# ENSF 607 - Exercise One 
# By: Yajur Vashisht

## UML Class Diagram

@startuml

	class Point {
	- x: int
	- y: int
	+ Point(int x, int y)
	+ distance(Point a, Point b) : double {static}
	+ toString(): String
	}
	
	class Line {
	~ start: Point
	~ end: Point
	- classId: int {static}
	+ distance(): double
	+ toString(): String
	}
	
	class Polygon {
	- polygon: LinkedHashSet <Line>
	- objID: int
	- classID: int {static}
	~ Iterator<Line>
	+ Polygon(polygon: LinkedHashSet<Line>)
	+ getLine(): Iterator <Line>
	+ classID(): int {static}
	+ toString(): String
	}
	
	class Drawing {
	~ lines: LinkedHashSet<Line>
	+ drawPolygon(lines: LinkedHashSet <Line>)
	- perimeter(Polygon p): double
	+ main(String[] args): void {static}
	}
	
	Line <-- Drawing : uses
	Line <-- Polygon : uses
	Point <-- Line : uses

@enduml
