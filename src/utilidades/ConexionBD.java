package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import excepciones.BBDDException;

public class ConexionBD {

	// datos de la conexión
	private static String database="bilioteca";
	private static String user="bibliotecario";
	private static String pass="1234";
	private static String url="jdbc:mysql://localhost:3306/"+database;
	
	// Objeto Connection
	private Connection conexion = null; 
	

	public Connection getConexion() throws BBDDException {
		if (conexion!=null) {
			return this.conexion;
		}
		
		try {
			// REgistramos el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Pedir un objeto Connection
			this.conexion=DriverManager.getConnection(url, user, pass);
			System.out.println("Conexión realizada correctamente");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("No ha se ha podido registrar el driver. "
					+ "Consulte con el adminsitrador");
			e.printStackTrace();
			throw new BBDDException("Error Registrando el driver");
		} catch (SQLException e) {
			System.out.println("No se ha podido conectar. "+e.getMessage());
			e.printStackTrace();
			throw new BBDDException("No se ha podido Conectar");
		}
		return this.conexion;
	}
	
	
	public void desconectar() {
		try {
			this.conexion.close();
			this.conexion=null;
		} catch (SQLException e) {
			System.out.println("Error liberando la conexión.");
			e.printStackTrace();
		}
	}
	
	
}
