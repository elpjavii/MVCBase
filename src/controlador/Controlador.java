package controlador;

import java.util.ArrayList;

import dao.EditorialesDAO;
import dao.LibrosDAO;
import excepciones.BBDDException;
import modelo.Editorial;
import modelo.Libro;
import vistas.NuevoEditorDialog;
import vistas.NuevoLibroDialog;
import vistas.VentanaPpal;

public class Controlador {
	
	// Lista de Libros
	private ArrayList<Libro> listaLibros;
	private ArrayList<Editorial> listaEditoriales;
	
	// Referencias a las ventanas de la aplicación
	private VentanaPpal vPrincipal;
	private NuevoLibroDialog dNuevoLibro;
	private NuevoEditorDialog dNuevaEdit;
	
	// Definimos los objetos de acceso a datos (DAO)
	private LibrosDAO daoLibro;
	private EditorialesDAO daoEdit;
	
	public Controlador() {
		
		// Instanciamos las ventanas/cuadro de diálogo
		this.vPrincipal = new VentanaPpal();
		this.dNuevoLibro = new NuevoLibroDialog();
		this.dNuevaEdit = new NuevoEditorDialog();
		
		// Pasamos una copia del controlador a las vistas.
		this.vPrincipal.setControlador(this);
		this.dNuevoLibro.setControlador(this);
		this.dNuevaEdit.setControlador(this);
		
		// Instanciamos el DAO del Libro
		this.daoLibro = new LibrosDAO();
		this.daoEdit = new EditorialesDAO();
	}
	
	public void iniciarPrograma() {
		this.vPrincipal.setVisible(true);
	}

	public void mostrarInsertarLibro() {
		this.dNuevoLibro.setModal(true);
		this.dNuevoLibro.setVisible(true);
	}
	
	public void mostrarInsertarEditorial() {
		this.dNuevaEdit.setModal(true);
		this.dNuevaEdit.setVisible(true);
	}

	public void insertaLibro(Libro l) throws BBDDException {
		this.daoLibro.insertarLibro(l);
		this.dNuevoLibro.setVisible(false);
	}
	
	

	public void insertaEditorial(Editorial e1) throws BBDDException {
		this.daoEdit.insertarEditorial(e1);
		this.daoEdit.insertarEditorial(e1);
		
	}

	
	
	
	
	
	

}
