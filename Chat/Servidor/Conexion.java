package proyectoServidor;

import java.sql.*;


public class Conexion {
	Connection connection = null;


	 public void connectDatabase() {
	       
		 try {
	            // We register the PostgreSQL driver
	            // Registramos el driver de PostgresSQL
	            try { 
	                Class.forName("org.postgresql.Driver");
	            } catch (ClassNotFoundException ex) {
	                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
	            }
	           
	            // Database connect
	            // Conectamos con la base de datos
	            connection = DriverManager.getConnection(
	                    "jdbc:postgresql://localhost/postgres",
	                    "postgres", "uno");
	 
	            boolean valid = connection.isValid(50000);
	            System.out.println(valid ? "TEST OK" : "TEST FAIL");
	        } catch (java.sql.SQLException sqle) {
	            System.out.println("Error: " + sqle);
	        }
	        
	    } 
	 
	 

}
