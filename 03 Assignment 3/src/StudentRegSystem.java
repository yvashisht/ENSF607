import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class StudentRegSystem {

	public static void main(String[] args) {
		
		// Setting up JDBC Driver to link with MySQL and Java
		
        String jdbcUrl = "jdbc:mysql://localhost:3306/StudentSys";
        String username = "root";
        String password = "Hello!";
        
        // Using try statement in case there is an error
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                Statement statement = connection.createStatement()) {
            
            // Query to get all students
            String selectStudentsQuery = "SELECT * FROM Student";
            ResultSet resultSet = statement.executeQuery(selectStudentsQuery);
            
            System.out.println("___First Query___\n");
            // Display the results
            while (resultSet.next()) {
                String studentId = resultSet.getString("StudentId");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String location = resultSet.getString("Location");
                System.out.println("Student ID: " + studentId + ", Name: " + firstName + " " + lastName + ", Location: " + location);
            }
            
            // Close the first ResultSet and Statement
            resultSet.close();
            statement.close();
            
            // Query to get all courses
            Statement secondStatement = connection.createStatement();
            String selectCoursesQuery = "SELECT * FROM Course";
            ResultSet courseResultSet = secondStatement.executeQuery(selectCoursesQuery);
            
            System.out.println("\n___Second Query___\n");
            // Display the results for the second query
            while (courseResultSet.next()) {
                String courseId = courseResultSet.getString("CourseId");
                String courseName = courseResultSet.getString("CourseName");
                String courseTitle = courseResultSet.getString("CourseTitle");
                System.out.println("Course ID: " + courseId + ", Course Name: " + courseName + ", Course Title: " + courseTitle);
            }
            
            // Close the first ResultSet and Statement
            courseResultSet.close();
            secondStatement.close();
            
            System.out.println("\n___Third Query___\n");
            Statement thirdStatement = connection.createStatement();
            // Query to update and existing student in the system.
            String newFirstName = "Dick";
            String newLastName = "Butkus";
            String StudentID = "S003";
            String newLocation = "Los Angeles";
            
            // Updating
            String updateStudentQuery = "UPDATE Student SET FirstName = '" + newFirstName + "', " +
                    "LastName = '" + newLastName + "', Location = '" + newLocation + "' " +
                    "WHERE StudentId = '" + StudentID + "'";

            // Execute the update query
            int rowsUpdated = thirdStatement.executeUpdate(updateStudentQuery);

            if (rowsUpdated > 0) {
                System.out.println("Student information updated successfully!");
            } else {
                System.out.println("No student found with the specified ID.");
            }
            
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
}
