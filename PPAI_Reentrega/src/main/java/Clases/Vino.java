package Clases;

import service.MaridajeService;
import service.TipoUvaService;
import service.VarietalService;
import service.VinoService;

import java.util.ArrayList;
import java.util.List;

public class Vino {

	//Atributos
	private Integer aniada;
	private String imagenEtiqueta;	//Modificada
	private String nombreVino;
	private String notaDeCataBodega;	//Modificable
	private Double precioARS;	//Modificable
	private Bodega bodega;
	private List<Resenia> resenia;
	private List<Varietal> varietal;
	private List<Maridaje> maridaje;	//Modificable

	//Contructor
	public Vino(Integer aniada, String imagenEtiqueta, String nombre, String notaDeCataBodega, Double precioARS, Bodega bodega, List<Resenia> resenia, List<Varietal> varietal, List<Maridaje> maridaje) {
		this.aniada = aniada;
		this.imagenEtiqueta = imagenEtiqueta;
		this.nombreVino = nombre;
		this.notaDeCataBodega = notaDeCataBodega;
		this.precioARS = precioARS;
		this.bodega = bodega;
		this.resenia = resenia;
		this.varietal = varietal;
		this.maridaje = maridaje;
	}

	public Vino(Integer aniada, String imagenEtiqueta, String nombre_vino, String notaDeCataBodega, Double precioARS) {
		this.aniada = aniada;
		this.imagenEtiqueta = imagenEtiqueta;
		this.nombreVino = nombre_vino;
		this.notaDeCataBodega = notaDeCataBodega;
		this.precioARS = precioARS;
	}

	VinoService vinoService = new VinoService();
	public Vino(ArrayList<Maridaje> maridajesYaCreados, ArrayList<TipoUva> tipoUvaYaCreadas, Vino vino, List<Bodega> bodegaSeleccionada, ArrayList<TipoUva> tipoUvaNoCreados, ArrayList<Maridaje> maridajesNoCreados, ArrayList<Varietal> varietalesYaCreados, ArrayList<Varietal> varietalesNoCreados ) {

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.println("creacion del vino: "+ vino.getNombre());
		this.setAniada((Integer) vino.getAniada());
		System.out.println("Esta es la aniada del vino: "+ this.getAniada());
		this.setImagenEtiqueta(vino.getImagenEtiqueta());
		System.out.println("Esta es la imagen del vino: "+ this.getImagenEtiqueta());
		this.setNombre(vino.getNombre());
		System.out.println("Esta es el nombre del vino: "+ this.getNombre());
		this.setNotaDeCataBodega(vino.getNotaDeCataBodega());
		System.out.println("Esta es la nota de cata del vino: "+ this.getNotaDeCataBodega());
		this.setPrecioARS((Double) vino.getPrecioARS());
		System.out.println("Este es el precio del vino: "+ this.getPrecioARS().toString());

		//Setea la Bodega
		Bodega bodegaVino = vino.getBodega();
		for (Bodega bodega : bodegaSeleccionada) {
			if (bodega.getNombreBodega().equals(bodegaVino.getNombreBodega())){
				this.setBodega(bodega);
				break;
			}
		}
		System.out.println("Este es el objeto de bodega del vino: "+this.getBodega());
		System.out.println("Este es el nombre de la bodega del vino: "+ this.getBodega().getNombreBodega());




		/////////////////////////////////////////////////////////////////////
		//Crea varietal y tipo de uva
		ArrayList<Varietal> varietalesTodos;
		varietalesTodos = crearVarietal(varietalesNoCreados, tipoUvaNoCreados );
		varietalesTodos.addAll(varietalesYaCreados);
		this.setVarietal(varietalesTodos);
		System.out.println("Estos son todos los objetos varietales del vino: "+ this.getVarietal());

		/////////////////////////////////////////////////////////////////////
		//Crea Maridaje
		ArrayList<Maridaje> maridajesTodos = maridajesYaCreados;
		maridajesTodos.addAll(this.crearMaridaje(maridajesNoCreados)); //aca creo los maridajes en base de datos
		this.setMaridaje(maridajesTodos);
		System.out.println("Estos son todos los objetos Maridajes del vino: "+ this.getMaridaje());

		///////////////////////////////////////////////////////////////////
		//creacion vino en BDD() hacelo abi
		vinoService.insertarVino(this.aniada,this.imagenEtiqueta, this.nombreVino, this.notaDeCataBodega, this.precioARS, this.getBodega().getNombreBodega());


		////////////////////////////////////////////////////////////////////
		// CREACION DE LAS TABLAS VINO_MARIDAJE


		for (Maridaje maridaje : maridajesTodos){
			vinoService.insertarVinoXMaridaje(this.nombreVino, this.aniada, maridaje.getNombre());
		}

		////////////////////////////////////////////////////////////////////
		// CREACION DE LA TABLA VINO_VARIETAL

		for (Varietal varietal1 : varietalesTodos){
			vinoService.insertarVinoXVarietal(this.nombreVino, this.aniada, varietal1.getTipoUva().getNombre(), varietal1.getPorcentajeComposicion());
		}


	}


	public Vino(String nombre, Bodega bodega ){
		this.nombreVino = nombre;
		this.bodega = bodega;
	}

	public Vino(Integer aniada, String imagenEtiqueta, String nombre, Bodega bodega, Double precioARS, String notaDeCataBodega) {
		this.aniada = aniada;
		this.imagenEtiqueta = imagenEtiqueta;
		this.nombreVino = nombre;
		this.bodega = bodega;
		this.precioARS = precioARS;
		this.notaDeCataBodega = notaDeCataBodega;
	}

	//Metodos
	public void calcularRanking() {

	}

	public void compararEtiquetas() {

	}

	public void esDeBodega() {

	}

	public void esDeRegionVitivinicola() {

	}

	public Vino() {
	}

	public Boolean sosVinoParaActualizar(Vino vinoAPI) {
		if (this.getNombre().equals(vinoAPI.getNombre())){
			return true;
		}
		return false;
	}


	VarietalService varietalService = new VarietalService();
	public ArrayList<Varietal> crearVarietal( ArrayList<Varietal> varietalesNoCreados, ArrayList<TipoUva> tipoUvaNoCreados){
		// ESTE ARRAY ES PARA RETORNAR LOS VARITALES
		ArrayList<Varietal> varietalesCreados = new ArrayList<>();
		for (Varietal varietalesNoCreadoIndividual : varietalesNoCreados){
			System.out.println(varietalesNoCreadoIndividual.getTipoUva().getNombre() );
			Varietal varietalesCreado = new Varietal(varietalesNoCreadoIndividual, tipoUvaNoCreados);
			varietalesCreados.add(varietalesCreado);
			//crear varidaje en base de datos hacelo abi
			varietalService.insertarVarietal(varietalesCreado.getTipoUva().getNombre(), varietalesCreado.getPorcentajeComposicion(), varietalesCreado.getDescripcion());
			System.out.println("soy un nuevo varietal :" + varietalesCreado );
			System.out.println("soy el tipo de uva :"+ varietalesCreado.getTipoUva()+" con el nombre de "+ varietalesCreado.getTipoUva().getNombre());
		}
		return varietalesCreados;
	}

	/*
	TipoUvaService tipoUvaService = new TipoUvaService();
	public void crearTipoUva(TipoUva tipoUva) {
		TipoUva uvaACrear = new TipoUva();
		uvaACrear.setNombre(tipoUva.getNombre());
		uvaACrear.setDescripcion(tipoUva.getDescripcion());

		tipoUvaService.insertarTipoUva(uvaACrear.getNombre(), uvaACrear.getDescripcion());
		System.out.println("CREADAAAAA:" + uvaACrear.getNombre());
	}

	 */

	MaridajeService maridajeService = new MaridajeService();
	public ArrayList<Maridaje> crearMaridaje( ArrayList<Maridaje> maridajesACrear){
		ArrayList<Maridaje> maridajeCreados = new ArrayList<>();
		for (Maridaje maridajeIndividualAPI : maridajesACrear){
			Maridaje maridajeCreado = new Maridaje(maridajeIndividualAPI.getNombre(), maridajeIndividualAPI.getDescripcion());
			maridajeCreados.add(maridajeCreado);
			///////////////////////////////////////////////////////////////
			//crear Maridaje en base de datos hacelo abi
			System.out.println("llego a la creacion del maridaje");
			maridajeService.insertarMaridaje(maridajeCreado.getNombre(), maridajeCreado.getDescripcion());

			System.out.println("Soy un nuevo Maridaje " + maridajeCreado);
			System.out.println("Este maridaje tiene de nombre: " + maridajeCreado.getNombre() );
		}
		return maridajeCreados;
	}

	// -----------------------------------------------
	//GETTERS Y SETTERS
	// -----------------------------------------------
	public Integer getAniada() {
		return aniada;
	}

	public void setAniada(Integer aniada) {
		this.aniada = aniada;
	}

	public String getImagenEtiqueta() {
		return imagenEtiqueta;
	}

	public void setImagenEtiqueta(String imagenEtiqueta) {
		this.imagenEtiqueta = imagenEtiqueta;
	}

	public String getNombre() {
		return nombreVino;
	}

	public void setNombre(String nombre) {
		this.nombreVino = nombre;
	}

	public String getNotaDeCataBodega() {
		return notaDeCataBodega;
	}

	public void setNotaDeCataBodega(String notaDeCataBodega) {
		this.notaDeCataBodega = notaDeCataBodega;
	}

	public Double getPrecioARS() {
		return precioARS;
	}

	public void setPrecioARS(Double precioARS) {
		this.precioARS = precioARS;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public List<Resenia> getResenia() {
		return resenia;
	}

	public void setResenia(List<Resenia> resenia) {
		this.resenia = resenia;
	}

	public List<Varietal> getVarietal() {
		return varietal;
	}

	public void setVarietal(List<Varietal> varietal) {
		this.varietal = varietal;
	}

	public List<Maridaje> getMaridaje() {
		return maridaje;
	}

	public void setMaridaje(List<Maridaje> maridaje) {
		this.maridaje = maridaje;
	}
}