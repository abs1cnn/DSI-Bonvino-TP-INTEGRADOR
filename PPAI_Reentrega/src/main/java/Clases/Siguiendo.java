package Clases;

public class Siguiendo {

	//ATRIBUTOS
	private Bodega bodega;
	private String fechaFin;
	private String fechaInicio;
	private Sommelier sommelier;
	private int amigo;

	//CONSTRUCTOR
	public Siguiendo(Bodega bodega, String fechaFin, String fechaInicio, Sommelier sommelier, int amigo) {
		this.bodega = bodega;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.sommelier = sommelier;
		this.amigo = amigo;
	}

	public Siguiendo() {
	}

	//METODOS
	public void sosDeAmigo() {
	}

	@Override
	public String toString() {
		return "Siguiendo{" +
				"bodega=" + bodega +
				", fechaFin='" + fechaFin + '\'' +
				", fechaInicio='" + fechaInicio + '\'' +
				", sommelier=" + sommelier +
				", amigo=" + amigo +
				'}';
	}

	public Boolean sosDeBodega(String bodegaSeleccionada) {
		if (this.bodega.getNombreBodega().equals(bodegaSeleccionada)) {
			return true;
		} else {
			return false;
		}
	}

	public void sosDeSomelier() {

	}

	public void _sosDeBodega() {

	}

	//GETTERS Y SETTERS
	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Sommelier getSommelier() {
		return sommelier;
	}

	public void setSommelier(Sommelier sommelier) {
		this.sommelier = sommelier;
	}

	public int getAmigo() {
		return amigo;
	}

	public void setAmigo(int amigo) {
		this.amigo = amigo;
	}
}