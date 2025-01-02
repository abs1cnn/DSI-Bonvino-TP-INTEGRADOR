package Clases;

import service.BodegaService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;


public class Bodega {

	private String coordenadasUbicacion;
	private String descripcion;
	private String historia;
	private String nombreBodega;
	private Integer periodoActualizacion;
	private NovedadEvento novedadEvento;
	private RegionVitivinicola regionVitivinicola;
	private String ultimaActualizacion; //AGREGAR

	public Bodega() {
	}

	//Constructor
	public Bodega(String coordenadasUbicacion, String descripcion, String historia, String nombre,
				  Integer periodoActualizacion, String ultimaActualizacion) {
		this.coordenadasUbicacion = coordenadasUbicacion;
		this.descripcion = descripcion;
		this.historia = historia;
		this.nombreBodega = nombre;
		this.periodoActualizacion = periodoActualizacion;
		this.ultimaActualizacion = ultimaActualizacion;
	}


	public Bodega(String nombre) {
		this.nombreBodega = nombre;
	}

	public Bodega(String coordenadasUbicacion,
				  String descripcion,
				  String historia,
				  String nombreBodega,
				  int periodoActualizacion,
				  NovedadEvento novedad,
				  RegionVitivinicola region,
				  String ultimaActualizacion) {
		this.coordenadasUbicacion = coordenadasUbicacion;
		this.descripcion = descripcion;
		this.historia = historia;
		this.nombreBodega = nombreBodega;
		this.periodoActualizacion = periodoActualizacion;
		this.novedadEvento = novedad;
		this.regionVitivinicola = region;
		this.ultimaActualizacion = ultimaActualizacion;
	}

	@Override
	public String toString() {
		return "Bodega{" +
				"coordenadasUbicacion='" + coordenadasUbicacion + '\'' +
				", descripcion='" + descripcion + '\'' +
				", historia='" + historia + '\'' +
				", nombre_bodega='" + nombreBodega + '\'' +
				", periodoActualizacion=" + periodoActualizacion +
				", novedadEvento=" + novedadEvento +
				", regionVitivinicola=" + regionVitivinicola +
				", ultimaActualizacion='" + ultimaActualizacion + '\'' +
				'}';
	}

	//Metodos
	public void contarResenia() {

	}

	public void mostrarTodosVinos() {
	}

	public boolean disponibleActualizar(LocalDate today) {
		LocalDate fechaUltimaActualizacion = LocalDate.parse(ultimaActualizacion);
		long monthsBetween = ChronoUnit.MONTHS.between(fechaUltimaActualizacion, today);
		return monthsBetween >= periodoActualizacion;
	}

	public Boolean actualizarDatosVino(Vino vinoAPI, List<Vino> listaVinosBDD ) {
		for (Vino vinoBDD : listaVinosBDD){
			if (vinoBDD.sosVinoParaActualizar(vinoAPI)){
				System.out.println("");
				System.out.println("");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("Datos actualizados correctamente del vino" + (vinoAPI.getNombre()));
				System.out.println("Precio antes"+ vinoBDD.getPrecioARS() );
				// setear precio
				vinoBDD.setPrecioARS(vinoAPI.getPrecioARS());
				System.out.println("Precio Despues: " + (vinoBDD.getPrecioARS().toString()) );
				System.out.println("Etiqueta Antes: " + vinoBDD.getImagenEtiqueta());
				// setear imagen
				vinoBDD.setImagenEtiqueta(vinoAPI.getImagenEtiqueta());
				System.out.println("Etiquete Despues: " + vinoBDD.getImagenEtiqueta());
				System.out.println("Nota de cata antes: "+ vinoBDD.getNotaDeCataBodega());
				// setear cata
				vinoBDD.setNotaDeCataBodega(vinoAPI.getNotaDeCataBodega());
				System.out.println("Nota de cata Despues: "+ vinoBDD.getNotaDeCataBodega());

				////////////////////////////////////////////////////////////////////////
				// vinoBDD.save();
				// PERSISTIR VINO
				BodegaService bodegaService = new BodegaService();
				bodegaService.actualizarVino(vinoBDD);
				////////////////////////////////////////////////////////////////////////

				return true;
			}
		}
		return false;
	}


	//Getters y Setters
	public String getCoordenadasUbicacion() {
		return coordenadasUbicacion;
	}

	public void setCoordenadasUbicacion(String coordenadasUbicacion) {
		this.coordenadasUbicacion = coordenadasUbicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getNombreBodega() {
		return nombreBodega;
	}

	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}

	public Integer getPeriodoActualizacion() {
		return periodoActualizacion;
	}

	public void setPeriodoActualizacion(Integer periodoActualizacion) {
		this.periodoActualizacion = periodoActualizacion;
	}

	public NovedadEvento getNovedadEvento() {
		// begin-user-code
		return novedadEvento;
		// end-user-code
	}

	public void setNovedadEvento(NovedadEvento novedadEvento) {
		this.novedadEvento = novedadEvento;
	}

	public RegionVitivinicola getRegionVitivinicola() {
		return regionVitivinicola;
	}

	public void setRegionVitivinicola(RegionVitivinicola regionVitivinicola) {
		this.regionVitivinicola = regionVitivinicola;
	}

	public String getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(String ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}
}