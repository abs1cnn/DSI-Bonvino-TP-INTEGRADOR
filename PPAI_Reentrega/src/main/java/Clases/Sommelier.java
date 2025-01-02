package Clases;


import com.sun.jdi.InconsistentDebugInfoException;

public class Sommelier {

	private Integer id_sommelier;
	private Usuario usuario;
	private String fecha_validacion;
	private String nombre;
	private String nota_pesentacion;

	public Sommelier(Integer id_sommelier, Usuario usuario, String fecha_validacion, String nombre, String nota_pesentacion) {
		this.id_sommelier = id_sommelier;
		this.usuario = usuario;
		this.fecha_validacion = fecha_validacion;
		this.nombre = nombre;
		this.nota_pesentacion = nota_pesentacion;
	}

	public Sommelier() {
	}

	public Sommelier(String idSommelier, String idUsuario, String fechaValidacion, String nombre, int notaPresentacion, String ultimaActualizacion) {
	}

	public Integer getId_sommelier() {
		return id_sommelier;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getFecha_validacion() {
		return fecha_validacion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNota_pesentacion() {
		return nota_pesentacion;
	}

	public void setId_sommelier(Integer id_sommelier) {
		this.id_sommelier = id_sommelier;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setFecha_validacion(String fecha_validacion) {
		this.fecha_validacion = fecha_validacion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNota_pesentacion(String nota_pesentacion) {
		this.nota_pesentacion = nota_pesentacion;
	}
}
