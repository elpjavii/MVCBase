package controlador;

import java.util.ArrayList;

import dao.LibrosDAO;
import excepciones.BBDDException;
import modelo.Libro;
import vistas.NuevoLibroDialog;
import vistas.VentanaPpal;

public class Controlador {
	
	// Lista de Libros
	private ArrayList<Libro> listaLibros;
	
	// Referencias a las ventanas de la aplicación
	private VentanaPpal vPrincipal;
	private NuevoLibroDialog dNuevoLibro;
	
	// Definimos los objetos de acceso a datos (DAO)
	private LibrosDAO daoLibro;
	
	public Controlador() {
		
		// Instanciamos las ventanas/cuadro de diálogo
		this.vPrincipal = new VentanaPpal();
		this.dNuevoLibro = new NuevoLibroDialog();
		
		// Pasamos una copia del controlador a las vistas.
		this.vPrincipal.setControlador(this);
		this.dNuevoLibro.setControlador(this);
		
		// Instanciamos el DAO del Libro
		this.daoLibro = new LibrosDAO();
	}
	
	public void iniciarPrograma() {
		this.vPrincipal.setVisible(true);
	}

	public void mostrarInsertarLibro() {
		this.dNuevoLibro.setModal(true);
		this.dNuevoLibro.setVisible(true);
	}

	public void insertaLibro(Libro l) throws BBDDException {
		this.daoLibro.insertarLibro(l);
		this.dNuevoLibro.setVisible(false);
	}

	
	
	
	
	
	

}
