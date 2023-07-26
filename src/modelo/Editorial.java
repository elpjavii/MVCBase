package modelo;

import java.util.Objects;

public class Editorial {
	private int codEditorial;
	private String Nombre;
	private int anio;
	
	
	
	public Editorial(String nombre, int anio) {
		super();
		Nombre = nombre;
		this.anio = anio;
	}

	public Editorial(int codEditorial, String nombre, int anio) {
		super();
		this.codEditorial = codEditorial;
		Nombre = nombre;
		this.anio = anio;
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getCodEditorial() {
		return codEditorial;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codEditorial);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editorial other = (Editorial) obj;
		return codEditorial == other.codEditorial;
	}
	
	
}
