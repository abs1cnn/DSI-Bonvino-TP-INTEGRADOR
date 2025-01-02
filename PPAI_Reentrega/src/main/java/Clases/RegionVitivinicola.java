package Clases;

public class RegionVitivinicola {
	//ATRIBUTOS
	private Integer id_regionVitivinicola;
	private String descripcion;
	private String nombre;

	//CONSTRUCTOR
	public RegionVitivinicola(Integer id_regionVitivinicola ,String descripcion, String nombre) {
		this.id_regionVitivinicola = id_regionVitivinicola;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	//METODOS
	public void conocerBodega() {

	}

	public void contarBodegas() {

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