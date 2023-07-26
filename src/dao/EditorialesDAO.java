package dao;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import excepciones.BBDDException;
import excepciones.CantidadDebeSerPositivaException;
import modelo.Editorial;
import modelo.Libro;
import utilidades.ConexionBD;
	
	public class EditorialesDAO {
		/**
		 * Javi: ESTABLECE LA CONECION Y CON ESTO LA IMPLEMENTAMOS SIN INSTANCIARLA
		 */
		private ConexionBD conexion;
		
		private Statement sentencia;
		private PreparedStatement sentenciaPrep;
		private ResultSet resultado;
		private Connection con;
		
		public EditorialesDAO() {
			this.conexion = new ConexionBD();
		}
		
		
		/**
		 * Método de la clase que devuelve todos los libros de la tabla Libros
		 * @return Arraylist<Libro> con los libros o un ArrayList vacío en caso de que 
		 * no devuelva resultados. 
		 * @throws CantidadDebeSerPositivaException cuando se recogen valores negativos en cantidad
		 * @throws BBDDException se produce error en la base de datos
		 */
		public ArrayList<Editorial> getAllEditoriales() throws CantidadDebeSerPositivaException, BBDDException {
			// instanciamos la lista
			ArrayList<Editorial> lista = new ArrayList<Editorial>();
			
			
			String consulta = "select * from editoriales";
			
			try {
				// Conectamos con la base de datos
				con = this.conexion.getConexion();
				
				// Crea el objeto Statement con el que se pueden lanzar consultas
				sentencia = con.createStatement();
				
				// Se ejecuta la consulta y se recoge el ResultSet (resultado)
				resultado = sentencia.executeQuery(consulta);
				
				
				// Hacemos un bucle para recorrer el cursor con los resultados
				// next devuelve true mientras haya datos, false en caso contrario
				while (resultado.next()) {
					
					// recogemos todos los datos invocando a los método  getters correspondientes
					int codEditorial = resultado.getInt("codEditorial");
					String nombre = resultado.getString("nombre");
					int anio = resultado.getInt("anio");
					
					// Instanciamos el objeto de tipo Libro
					Editorial e = new Editorial(codEditorial, nombre, anio);
					
					
					lista.add(e);
				}
			} catch (SQLException e) {
				System.out.println("Error en la consulta "+e.getMessage());
				
				// EL ERROR SE PROPAGA CON THROW HACIA ARRIBA, ESTE ERROR ES EL QUE SE MUESTRA AL USUSARIO Y SE EXTIENDE 
				// HACIA LA INTERFAZ GRAFICA
				throw new BBDDException("Error al realizar la consulta. Consulte con el administrador");
			} finally {
				try {
					resultado.close();
					sentencia.close();
					conexion.desconectar();
				} catch (SQLException e) {
					System.out.println("error liberando recursos. " + e.getMessage());
				}
				
			}
			return lista;
		}
		
		/**
		 * Método que devuelve un Libro dado el isbn pasado como parámetro
		 * @param isbn isbn a buscar
		 * @return Libro con los datos del libro buscado si se ha encontrado, o 
		 * null si el libro no existe
		 * @throws CantidadDebeSerPositivaException 
		 * @throws BBDDException 
		 */
		public Editorial getEditorial(int codEditorial) throws CantidadDebeSerPositivaException, BBDDException {
			Editorial e = null;
			
			String consulta = "select * from editoriales where codEditorial = "+codEditorial;
			
			try {
				// Conectamos con la base de datos
				con = this.conexion.getConexion();
				// Crea el objeto Statement con el que se pueden lanzar consultas
				sentencia = con.createStatement();
				// Se ejecuta la consulta y se recoge el ResultSet (resultado)
				resultado = sentencia.executeQuery(consulta);
				
				// Hacemos un bucle para recorrer el cursor con los resultados
				// next devuelve true mientras haya datos, false en caso contrario
				if(resultado.next()) {
					
					// recogemos todos los datos invocando a los método  getters correspondientes
					String nombre = resultado.getString("nombre");
					int anio = resultado.getInt("anio");
				
					
					// Instanciamos el objeto de tipo Editorial
					e = new Editorial(codEditorial, nombre, anio);
					
				}
			} catch (SQLException e1) {
				System.out.println("Error en la consulta "+e1.getMessage());
				throw new BBDDException("Error al realizar la consulta. Consulte con el administrador");
			} finally {
				try {
					resultado.close();
					sentencia.close();
					conexion.desconectar();
				} catch (SQLException e1) {
					System.out.println("error liberando recursos. " + e1.getMessage());
				}
				
			}
			return e;
		}
		

		/**
		 * Método que inserta un libro en la base de datos
		 * @param l Libro a insertar
		 * 
		 */
		public void insertarEditorial(Editorial e) throws BBDDException {
			try {
				con=this.conexion.getConexion();
				String consulta= "insert into editoriales (nombre, anio) values (?, ?)";
				
				sentenciaPrep=con.prepareStatement(consulta);
				
				// incializamos la sentencia preparada indicando porque valor debe sustituir 
				// las interrogaciones
//				sentenciaPrep.setInt(1, e.getCodEditorial());
				sentenciaPrep.setString(1, e.getNombre());
				sentenciaPrep.setInt(2, e.getAnio());
				
				sentenciaPrep.executeUpdate();
				
				
			} catch (SQLException e1) {
				System.out.println("Error al insertar "+e1.getMessage()+e1.getErrorCode());
				// controlamos si se ha el duplicado la calve primaria
				if (e1.getErrorCode()==1062) {
					throw new BBDDException("Error insertando. Clave duplicado");
				} else if (e1.getErrorCode()==1216) {
					throw new BBDDException("Código Editorial no existe");
				}
				throw new BBDDException("Error al insertar");
			} finally {
				try {
					sentenciaPrep.close();
					conexion.desconectar();
				} catch (SQLException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				}
			}
		}
		
		/**
		 * Método de la clase que edita un libro en la base de datos
		 * @param l Libro a insertar
		 * @throws ErrorBBDDException en caso de que no se haya podido editar
		 */
		public void editarEditorial (Editorial e) throws BBDDException {
			try {
				con=this.conexion.getConexion();
				String consulta= "update Editoriales set codEditorial=?, nombre=?, anio=?";
				
				sentenciaPrep=con.prepareStatement(consulta);
				
				// incializamos la sentencia preparada indicando porque valor debe sustituir 
				// las interrogaciones
				
				sentenciaPrep.setInt(1, e.getCodEditorial());
				sentenciaPrep.setString(2, e.getNombre());
				sentenciaPrep.setInt(3, e.getAnio());
				
				
				sentenciaPrep.executeUpdate();
				
				
			} catch (SQLException e1) {
				System.out.println("Error al insertar "+e1.getMessage()+e1.getErrorCode());

				throw new BBDDException("Error editando el empleado.");
			} finally {
				try {
					sentenciaPrep.close();
					conexion.desconectar();
				} catch (SQLException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				}
			}
		}
		
		/**
		 * Método que elimina un libro de la tabla de la base de datos
		 * @param isbn String con el isbn del libro a borrar
		 * @return true en caso de borrado satisfactorio y false en caso contrario
		 * @throws BBDDException 
		 */
		public boolean eliminarEditoral(int codEditorial) throws BBDDException {
			boolean res=false;
			try {
				con=this.conexion.getConexion();
				String consulta= "delete from editoriales where codEditorial=?";
				
				sentenciaPrep=con.prepareStatement(consulta);
				
				// incializamos la sentencia preparada indicando porque valor debe sustituir 
				// las interrogaciones
				sentenciaPrep.setInt(1, codEditorial);

				sentenciaPrep.executeUpdate();
				res=true;
		
			} catch (SQLException e1) {
				System.out.println("Error al eliminar "+e1.getMessage());
				throw new BBDDException("Error al eliminar el libro");
			} finally {
				try {
					sentenciaPrep.close();
				} catch (SQLException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
				conexion.desconectar();
			}
			return res;
		}
		
		
}
