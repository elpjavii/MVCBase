/**
 * 
 */
package modelo;

import java.util.Objects;

import excepciones.CantidadDebeSerPositivaException;

/**
 * @author David
 *
 */
public class Libro {

	private String isbn;
	private String titulo;
	private int codEditorial;
	private int anio;
	private int numPags;
	private double precio;
	private int cantidad;
	private double precioCD;
	
	
	public Libro(String isbn, String titulo, int codEditorial, int anio, 
			int numPags, double precio, int cantidad,
			double precioCD) throws CantidadDebeSerPositivaException {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		// llamamos al setter para ejercrcer el control de valores negativos
		this.setCodEditorial(codEditorial);
		this.anio = anio;
		this.numPags = numPags;
		this.precio = precio;
		// llamamos al setter para ejercrcer el control de valores negativos
		this.setCantidad(cantidad);
		this.precioCD = precioCD;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getCodEditorial() {
		return codEditorial;
	}


	/**
	 * Método que establece el códgio de la editoroal al que pertenence el libro
	 * @param codEditorial int unsigned con el codigo de la editorial
	 */
	public void setCodEditorial(int codEditorial) {
		if (codEditorial>=0) {
			this.codEditorial = codEditorial;
		}
	}


	public int getAnio() {
		return anio;
	}


	public void setAnio(int anio) {
		this.anio = anio;
	}


	public int getNumPags() {
		return numPags;
	}


	public void setNumPags(int numPags) {
		this.numPags = numPags;
	}


	public double getPrecio() {
		return precio;
	}


	/** 
	 * Establece el precio del libro
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	/**
	 * Establece la cantidad de libros en la libreria
	 * @param cantidad int unsigned con el numero de libros
	 * @throws CantidadDebeSerPositivaException
	 */
	public void setCantidad(int cantidad) throws CantidadDebeSerPositivaException {
		if (cantidad<0) {
			throw new CantidadDebeSerPositivaException();
		}
		this.cantidad = cantidad;
	}


	public double getPrecioCD() {
		return precioCD;
	}


	public void setPrecioCD(double precioCD) {
		this.precioCD = precioCD;
	}


	@Override
	public String toString() {
		return "isbn: " + isbn + "\ntitulo: " + titulo + "\ncodEditorial: " + codEditorial + "\nanio: " + anio
				+ "\nnumPags: " + numPags + "\nprecio: " + precio + "\ncantidad: " + cantidad + "\nprecioCD: "
				+ precioCD;
	}


	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}
	
	
	
	
	
}
