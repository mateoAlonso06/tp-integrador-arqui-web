# Integrative Business Management System

## Project Overview
This academic project demonstrates a business management system developed in Java using JDBC. The application manages clients, products, and invoices, simulating a real-world billing scenario. It showcases database creation, data import from CSV files, and business analytics through SQL queries.

## Main Features
- **Database Schema Creation:** Automatically sets up relational tables for clients, products, and invoices with appropriate relationships.
- **CSV Data Import:** Loads initial data from provided CSV files (e.g., `productos.csv`) into the database.
- **Business Queries:**
  - Identifies the product with the highest revenue (sales quantity × unit price).
  - Lists clients ordered by total invoiced amount, from highest to lowest.
- **Console Interface:** Operates as a command-line application for ease of demonstration and testing.

## Technologies Used
- **Java 17+**
- **Maven** (project management and dependency resolution)
- **JDBC** (database connectivity)
- **MySQL** (relational database)
- **CSV Parsing** (for data import)

## Setup Instructions
1. **Clone the Repository:**
   ```
   git clone <repository-url>
   ```
2. **Configure MySQL:**
   - Create a database named `integrador`.
   - Ensure the MySQL server is running and accessible.
   - Update connection credentials in `MySQLDAOFactory.java` if necessary.
3. **Import CSV Files:**
   - Place provided CSV files (e.g., `productos.csv`) in the designated directory.
4. **Build the Project:**
   ```
   mvn clean install
   ```
5. **Run the Application:**
   ```
   mvn exec:java -Dexec.mainClass="com.integrador.Main"
   ```

## Usage Guide
- On startup, the application will:
  - Drop and recreate necessary tables.
  - Import data from CSV files.
  - Execute business queries and display results in the console.
- Follow on-screen prompts for any additional actions.

## Testing Instructions (Currently does not include tests)
- **Unit Tests:** Run with Maven:
  ```
  mvn test
  ```
- **Manual Testing:** Verify database state and console outputs after running the main application.

## Author Information
- **Author:** Mateo Alonso, Nahuel Lamorte, Martin Dentaro, 
- **Institution:** Universidad Nacional del Centro de la Provincia de Buenos Aires (UNICEN)
- **Course:** Integrative Project (Trabajo Integrador)

---

This documentation summarizes the project structure, features, and setup based on the provided code and faculty requirements.

