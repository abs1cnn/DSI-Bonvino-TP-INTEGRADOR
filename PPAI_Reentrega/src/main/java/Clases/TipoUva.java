package Clases;

import java.util.List;
import java.util.Objects;

public class TipoUva {

	//ATRIBUTOS
	private String descripcion;
	private String nombre;

	//CONSTRUCTOR
	public TipoUva(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;

	}

	//METODOS
	public boolean _sosTipoUva(TipoUva tipoUvaAPI) {
		System.out.println(tipoUvaAPI.getNombre());
		if (this.getNombre().equals(tipoUvaAPI.getNombre())) {
			System.out.println("ESTA EN LA LISTA DE LAS UVAS " + this.nombre);
			return true;
		}else {
			System.out.println("NO ESTA EN LISTA DE UVAS " + this.nombre);
			return false;
		}
	}


	public TipoUva() {
	}

	//GETTERS Y SETTERS
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}