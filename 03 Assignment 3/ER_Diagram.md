##ER Diagram for Student Registration System

#ER Diagram
	
	Notation:
	
	<<PK>> - Primary Key
	<<FK>> - Foreign Key
	
![screenshot](ER_Diagram.png)

#Database and JDBC Install

	Screenshots of Tables in the Database StudentSys:
	
![screenshot](Student_in_Database.png)
![screenshot](Course_in_Database.png)
![screenshot](Registration_in_Database.png)

	Steps:
	
	1. Downloading the JDBC zip file from MySQL and then making a lib folder in the project. 
	2. Adding the JDBC to the classpath for the project folder.
	 
	Screenshot of JDBC Install:
	
![screenshot](JDBC_install.png)

#Output

	The output of sample code used to complete the exercise: 
	
![screenshot](Output1.png)


#Code for ER Diagram

	@startuml
	Class Student {
	- StudentID <<PK>>
	- FirstName
	- LastName
	- Location
	}
	
	Class Course {
	+ CourseId <<PK>>
	+ CourseName
	+ CourseTitle
	}
	
	Class Registration {
	- RegistrationId <<PK>>
	+ CourseId <<FK>>
	- StudentId <<FK>>
	}
	
	Registration -> Student: uses
	Registration -> Course: uses
	@enduml