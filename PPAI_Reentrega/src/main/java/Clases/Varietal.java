package Clases;

import service.TipoUvaService;

import java.util.ArrayList;
import java.util.Objects;

public class Varietal {

	//ATRIBUTOS
	private Integer Id;
	private String descripcion;
	private Double porcentajeComposicion;
	private TipoUva tipoUva;

	TipoUvaService tipoUvaService = new TipoUvaService();

	//CONSTRUCTOR
	public Varietal(String descripcion, Double porcentajeComposicion, TipoUva tipoUva) {
		this.descripcion = descripcion;
		this.porcentajeComposicion = porcentajeComposicion;
		this.tipoUva = tipoUva;
	}

	public Varietal() {
	}

	public Varietal(Varietal varietal, ArrayList<TipoUva> tipoUvasNocreados){
		this.descripcion = varietal.getDescripcion();
		this.porcentajeComposicion = varietal.getPorcentajeComposicion();
		boolean bandera = false;
		for (TipoUva tipoUva : tipoUvasNocreados) {
			if (varietal.getTipoUva().equals(tipoUva)) {
				bandera = true;
				//System.out.println("---XXXXX-------------------------------------");
				//System.out.println(varietal.getTipoUva().getNombre());
				TipoUva uvaNew = new TipoUva(varietal.getTipoUva().getNombre(), varietal.getTipoUva().getDescripcion());
				//System.out.println("tengo valor de nombre de uba en marietal y es:" + uvaNew.getNombre());
				this.tipoUva = uvaNew;

				//System.out.println("/////////////////////////////////////////////");
				//System.out.println("EEEENTRO DESPUES DE CREAR OBJETO UVA ");
				/////////////////////////////////////////////////////////////////
				//guargar uva en la base de datos hacelo abi

				tipoUvaService.insertarTipoUva(uvaNew.getNombre(),uvaNew.getDescripcion());
				//System.out.println("----------------------------------------");
				//System.out.println(uvaNew.getNombre());
				//System.out.println(uvaNew.getDescripcion());
				//System.out.println("----------------------------------------");
				break;
			}

		}
		if (!bandera) {
			this.tipoUva = varietal.getTipoUva();
		}
	}

	//METODOS
	public void conocerTiposUva() {
	}

	public void esDeTipoUva() {
	}

	public void mostrarPorcentaje() {

	}

	public boolean _sosVarietal(Varietal varietal) {
		if (this.tipoUva.getNombre().equals(varietal.getTipoUva().getNombre()) &&
				this.porcentajeComposicion.equals(varietal.getPorcentajeComposicion())) {
			return true;
		} else {
			return false;
		}
	}




	//GETTERS Y SETTERS
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPorcentajeComposicion() {
		return porcentajeComposicion;
	}

	public void setPorcentajeComposicion(Double porcentajeComposicion) {
		this.porcentajeComposicion = porcentajeComposicion;
	}

	public TipoUva getTipoUva() {
		return tipoUva;
	}

	public void setTipoUva(TipoUva tipoUva) {
		this.tipoUva = tipoUva;
	}
}