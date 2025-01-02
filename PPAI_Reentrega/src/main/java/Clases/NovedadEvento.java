/**
 * 
 */
package Clases;


public class NovedadEvento {



	private Object codigoDescuentoPremium;

	public NovedadEvento(int idNovedadEvento, int esSoloPremium, String fechaHoraEvento, String codDescPremium, String descripcion, String nombreEvento) {
	}


	public Object getCodigoDescuentoPremium() {
		return codigoDescuentoPremium;
	}

	public void setCodigoDescuentoPremium(Object codigoDescuentoPremium) {
		this.codigoDescuentoPremium = codigoDescuentoPremium;
	}

	private Object descripcion;


	public Object getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(Object descripcion) {
		this.descripcion = descripcion;
	}

	private Object esSoloPremium;

	public Object getEsSoloPremium() {
		return esSoloPremium;
	}

	public void setEsSoloPremium(Object esSoloPremium) {
		this.esSoloPremium = esSoloPremium;
	}

	private Object fechaHoraEvento;

	public Object getFechaHoraEvento() {
		return fechaHoraEvento;
	}

	public void setFechaHoraEvento(Object fechaHoraEvento) {
		this.fechaHoraEvento = fechaHoraEvento;
	}

	private Object nombreEvento;


	public Object getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(Object nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public void esPremium() {

	}

	public void estaEnPeriodo() {
	}

	public void mostrarDescripcion() {
	}
}