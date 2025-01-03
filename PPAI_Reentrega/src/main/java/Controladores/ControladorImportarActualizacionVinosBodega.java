// ------------------------------------------
// IMPORTACION DE CLASES NECESARIAS y extras
// ------------------------------------------

package Controladores;
//----------------------------------CLASES
import Clases.*;
//----------------------------------BOUNDARYS
import com.company.PantallaAB.PantallaAB;
import Boundarys.InterfazSB;
import Boundarys.InterfazNotificacion;
//----------------------------------JAVA
import java.util.*;
import javax.swing.*;
import java.time.LocalDate;

import Boundarys.IObservadorActVino;
import Boundarys.ISujetoNotActualizacion;
import service.*;

// ---------------------------------------------------
// Definicion de la clase controlador
// ---------------------------------------------------

public class ControladorImportarActualizacionVinosBodega implements ISujetoNotActualizacion {

	// Atributos
	private List<Bodega> bodegaSeleccionada;
	private Maridaje maridaje;
	private TipoUva tipoUva;
	private List<Vino> listaVinosCreados;
	private List<Enofilo> seguidoresDeBodega;
	private List<Bodega> listaBodegas;
	private List<Vino> listaVinos;
	private ArrayList<Maridaje> maridajesList;
	private ArrayList<TipoUva> tipoUvaList;
	private ArrayList<Varietal> varietalsList;
	private ArrayList<Enofilo> listaEnofilos;
	private ArrayList<Vino> vinosParaActualizar;
	private Map<Vino, ArrayList<String>> mapVinoNombreUsuarioEnofilos;
	private final List<IObservadorActVino> observadores = new ArrayList<>();

	//---------------------------------------------------------------------



	// inicializar pantalla
	InterfazSB interfazSB = new InterfazSB();

	BodegaService bodegaService = new BodegaService();
	VinoService vinoService = new VinoService();
	MaridajeService maridajeService = new MaridajeService();
	TipoUvaService tipoUvaService = new TipoUvaService();
	//VarietalService varietalService = new VarietalService();
	//UsuarioService usuarioService = new UsuarioService();
	EnofiloService enofiloService = new EnofiloService();
	SiguiendoService siguiendoService = new SiguiendoService();
	VarietalService varietalService = new VarietalService();


	public ControladorImportarActualizacionVinosBodega() {
		this.listaBodegas = bodegaService.obtenerBodegas();
		this.bodegaSeleccionada = new ArrayList<>();
		this.maridajesList = maridajeService.obtenerMaridajes();
		this.listaVinos = vinoService.obtenerVinos();
		this.tipoUvaList = tipoUvaService.obtenerTiposUva();
		//this.Listasiguiendo = siguiendoService.obtenerSeguidoresPorEnofilo();
		this.listaEnofilos = enofiloService.obtenerEnofilos();
		this.varietalsList = varietalService.obtenerVarietales();
	}

	// --------------------------------------------------------------------
	// Metodos de clase controlador
	//---------------------------------------------------------------------

	//Observer---------------------------------------------------------------------


	@Override
	public void suscribir(ArrayList<IObservadorActVino> obs) {
		for (IObservadorActVino observador : obs ){
			observadores.add(observador);
		}
	}

	@Override
	public void quitar(ArrayList<IObservadorActVino> observador) {
		for (IObservadorActVino obs : observador){
			observadores.remove(obs);
		}
	}

	@Override
	public void notificar(List<String> nombresBodegas,
						  List<Integer> aniadas,
						  List<String> nombresVinos,
						  List<String> notasDeCata,
						  List<Double> preciosARS,
						  List<List<String>> enofilos) {
		for (IObservadorActVino observador : observadores) {
			observador.notificarActualizacion(nombresBodegas, aniadas, nombresVinos, notasDeCata, preciosARS, enofilos);
		}
	}


	// ---------------------------------------------------------------------
	/*
		notificar(); // tenemos que agregar esta linea cuando se produzca la actualizacion
	}*/

	//---------------------------------------------------------------------

	// Cuando se selecciona la opcion de importar actualizacion
	public void opcionImportarActualizacionVinosBodega() {
		// buscar las bodegas que requieren actualizacion
		List<String> listaBodegasConActualizacion = buscarBodegasParaActualizar(listaBodegas);

		if (listaBodegasConActualizacion.isEmpty()){
			// si el array esta vacio, muestra un mensaje de la inexistencia de bodegas para actualizar:
			JOptionPane.showMessageDialog(null, "No hay bodegas para actualizar");
			System.exit(0);
		} else {
			// si el array no esta vacio, llama a la funcion mostrarBodegasParaActualizacion de la pantallaAB
			// a la funcion se le pasa por parametro las bodegas que requieren actualizacion, algunas se crean otras se modifican
			PantallaAB.mostrarBodegasParaActualizar(listaBodegasConActualizacion);
		}
	}

	//
	public List<String> buscarBodegasParaActualizar(List<Bodega> listaBodegas) {
		LocalDate today = LocalDate.now(); // Tomar fecha actual

		// array para la lista de nombres
		List<String> bodegasConActualizacion = new ArrayList<>();
		for (Bodega bodega : listaBodegas) {
			if (bodega.disponibleActualizar(today)) {
				// agregar al array lista nombres
				bodegasConActualizacion.add(bodega.getNombreBodega());
			}}
		// devolver el array con los nombres de la bodega
		return bodegasConActualizacion;
	}

	// Metodo para seleccionar las bodegas
	public void tomarSeleccionBodega(List<String> nombresBodegaSeleccionadas) {
		boolean notificacion = false;
		ArrayList<ArrayList<String>> vinosPantalla = new ArrayList<>();
		ArrayList<String> bodegasActualizadas = new ArrayList<>();
		mapVinoNombreUsuarioEnofilos = new HashMap<>();

		for (String nombreBodegaSeleccionada : nombresBodegaSeleccionadas) {
			for (Bodega bodegaBDD : this.listaBodegas) {
				if (bodegaBDD.getNombreBodega().equals(nombreBodegaSeleccionada)) {
					bodegaSeleccionada.add(bodegaBDD);
					bodegasActualizadas.add(bodegaBDD.getNombreBodega());
				}
			}
			//dividir tomar seleccion
			vinosParaActualizar = interfazSB.getImportarActualizacionVinos(nombreBodegaSeleccionada);


			for (Vino vinostr : vinosParaActualizar) {
				ArrayList<String> vinoStringAMostrar = new ArrayList<>();
				Boolean vinoActualizado = actualizarVinosExistentes(vinostr);
				if (vinoActualizado){

					// ESTO ES PARA QUE LO MUESTRE POR PANTALLA
					vinoStringAMostrar.add(vinostr.getNombre());
					vinoStringAMostrar.add(vinostr.getAniada().toString());
					vinoStringAMostrar.add(vinostr.getBodega().getNombreBodega());
					vinoStringAMostrar.add(vinostr.getImagenEtiqueta());
					vinoStringAMostrar.add(vinostr.getPrecioARS().toString());
					vinoStringAMostrar.add(vinostr.getNotaDeCataBodega());
					vinoStringAMostrar.add("Actualizado");
				}
				if (!vinoActualizado){


					////////////////////////////////////////////////////////////
					ArrayList<Maridaje> maridajesYaCreadas = new ArrayList<>();
					ArrayList<Maridaje> maridajesNOCreadas = new ArrayList<>();
					for (Maridaje maridajeAPI : vinostr.getMaridaje()) {
						Maridaje maridajesYaCreadasIndividual = buscarMaridaje(maridajeAPI);
						if (maridajesYaCreadasIndividual == null) {
							// CREO EL OBJETO MARIDAJE
							if (!maridajesNOCreadas.contains(maridajeAPI)){
								maridajesNOCreadas.add(maridajeAPI);
							}
						}
						else{
							maridajesYaCreadas.add(maridajesYaCreadasIndividual);
						}
					}

					ArrayList<Varietal> varietalesYaCreadas = new ArrayList<>();
					ArrayList<Varietal> varietalesNOCreadas = new ArrayList<>();

					for (Varietal varietal :vinostr.getVarietal()){
						Varietal VarietalYaCreada = buscarVarietal(varietal);
						if (VarietalYaCreada == null ){
							if (!varietalesNOCreadas.contains(varietal)){
								System.out.println("soy el varietal que no esta creado " + varietal.getTipoUva().getNombre());
								System.out.println("soy el varietal que no esta creado " + varietal.getTipoUva().getDescripcion());
								System.out.println("soy el varietal que no esta creado " + varietal.getPorcentajeComposicion());
								varietalesNOCreadas.add(varietal);
							}
						}
						else{
							varietalesYaCreadas.add(VarietalYaCreada);
						}
					}
					//buscamos los tipos de uva y creamos 2 listas, una con los tipos de uva ya creados y otra con los que no
					ArrayList<TipoUva> tipoUvaYaCreadas = new ArrayList<>();
					ArrayList<TipoUva> tipoUvaNOCreadas = new ArrayList<>();

					for (Varietal varietal : vinostr.getVarietal()) {
						System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
						System.out.println(varietal.getTipoUva().getNombre() + "++++ " + varietal.getTipoUva().getDescripcion());
						Varietal tipoUvaYaCreadasIndividual = buscarTipoUva(varietal);
						if (tipoUvaYaCreadasIndividual == null) {
							// CREACION DEL TIPO DE UVA
							if (!tipoUvaNOCreadas.contains(varietal.getTipoUva())){
								tipoUvaNOCreadas.add(varietal.getTipoUva());}
						}
						else{
							tipoUvaYaCreadas.add(tipoUvaYaCreadasIndividual.getTipoUva());
						}
					}
					System.out.println("estos son los tipos de uvas no creados " + tipoUvaNOCreadas);

					// CREACION DEL VINO
					crearVino(maridajesYaCreadas, tipoUvaYaCreadas, vinostr, bodegaSeleccionada, tipoUvaNOCreadas, maridajesNOCreadas, varietalesYaCreadas, varietalesNOCreadas);

					// ESTO ES PARA MOSTRARLO POR PANTALLA
					vinoStringAMostrar.add(vinostr.getNombre());
					vinoStringAMostrar.add(vinostr.getAniada().toString());
					vinoStringAMostrar.add(vinostr.getBodega().getNombreBodega());
					vinoStringAMostrar.add(vinostr.getImagenEtiqueta());
					vinoStringAMostrar.add(vinostr.getPrecioARS().toString());
					vinoStringAMostrar.add(vinostr.getNotaDeCataBodega());
					vinoStringAMostrar.add("Creado");
					//con los vinostr el eltimo elemento del array es si esta creado o no
					// Anotar el vino creado para mostrarlo en el resumen
				}
				vinosPantalla.add(vinoStringAMostrar);
			}

			if (!(vinosParaActualizar.isEmpty())) {
				ArrayList<String> nombresDeUsuariosSeguidores;
				// Validar que sean bodegas actualizadas
				nombresDeUsuariosSeguidores = buscarSeguidoresBodega(nombreBodegaSeleccionada); // Array Strings de Usuarios

				for (Vino vino : vinosParaActualizar) {
					ArrayList<String> enofilos = new ArrayList<>();
					for (String nombreUsuario : nombresDeUsuariosSeguidores) {
						for (Enofilo enofilo : listaEnofilos) {
							if (enofilo.getNombreUsuario().equals(nombreUsuario)) {
								enofilos.add(enofilo.getNombreUsuario());
							}
						}
					}
					System.out.println("Se notifico a los usuarios: " + enofilos);
					this.mapVinoNombreUsuarioEnofilos.put(vino, enofilos);
				}


				notificacion = true;
				for (Bodega bodega : listaBodegas){
					if (bodega.getNombreBodega().equals(nombreBodegaSeleccionada)){
						bodega.setUltimaActualizacion(LocalDate.now().toString());
						System.out.println("........................................................................................................................................................................................");
						System.out.println("Se actualizo la bodega " + bodega.getNombreBodega() + " con la fecha " + bodega.getUltimaActualizacion());
						//bodegaService.actualizarBodega(bodega);
					}

				}

			}



		}
		notificarActVino();

		if (notificacion) {

			// ACA HACER
			JOptionPane.showMessageDialog(null, "Se notifico a los usuarios ");
		}
		PantallaAB.mostrarResumenVinosImportados(vinosPantalla);
	}


	public Boolean actualizarVinosExistentes(Vino vino) {
		for (Bodega bodegaSeleccionada : bodegaSeleccionada){
			if (bodegaSeleccionada.getNombreBodega().equals(vino.getBodega().getNombreBodega())) {

				return bodegaSeleccionada.actualizarDatosVino(vino, listaVinos );
				// Anotar el vino actualizado para mostrarlo en el resumen
				// agregar a un array para mostrar el resumen
			}
		}
		return false;
	}

	public Maridaje buscarMaridaje(Maridaje maridajeAPI) {
		Maridaje result = new Maridaje();

		for (Maridaje m : maridajesList) {
			if (m._sosMaridaje(maridajeAPI)) {
				result = m;
				return result;
			}
		}
		return null;
	}

	public Varietal buscarTipoUva(Varietal varietalApi) {
		Varietal result = new Varietal();
			for (TipoUva tipoUvaBDD : tipoUvaList) {;


				if (tipoUvaBDD._sosTipoUva(varietalApi.getTipoUva())) {
					result = varietalApi;
					return result;
				}
			}

		return null;
	}

	public Varietal buscarVarietal(Varietal varietal) {
		for (Varietal v : varietalsList) {
			if (v._sosVarietal(varietal)) {
				return varietal;
			}
		}
		return null;
	}

	// metodo crear vino, pasarle todas las clases necesarias. Con ayuda de lconstructor
	public void crearVino(ArrayList<Maridaje> maridajesYaCreados, ArrayList<TipoUva> tipoUvaYaCreados, Vino vinostr, List<Bodega> bodegaSeleccionada, ArrayList<TipoUva> tipoUvaNoCreados, ArrayList<Maridaje> maridajesNoCreados, ArrayList<Varietal> varietalesYaCreados, ArrayList<Varietal> varietalesNoCreados) {
		Vino vino = new Vino(maridajesYaCreados, tipoUvaYaCreados, vinostr, bodegaSeleccionada, tipoUvaNoCreados, maridajesNoCreados, varietalesYaCreados, varietalesNoCreados);
		// LO AGREGO A LA LISTA DE VINOS QUE TRAIGO DESDE LA BASE DE DATOS
		listaVinos.add(vino);
	}


	public ArrayList<String> buscarSeguidoresBodega(String Bodega) {
        ArrayList<String> enofilosSiguiendos = new ArrayList<>();
            for (Enofilo enofilo : listaEnofilos) {
                if (enofilo.seguisBodega(Bodega)) {
					enofilosSiguiendos.add(enofilo.getNombreUsuario());
				}
            }
        return enofilosSiguiendos; // Si no se encuentra ningún seguidor
    }

	// ------------------------------------------------------------------------------------------------------------------------------------

	public void notificarActVino() {
		ArrayList<IObservadorActVino> arrayObservadores = new ArrayList<>();
		InterfazNotificacion interfazNotificacion = new InterfazNotificacion();
		arrayObservadores.add(interfazNotificacion);

		// Aca se pueden agregar mas boundarys para actualizar
		suscribir(arrayObservadores);

		// Listas para acumular los datos
		List<String> nombresBodegas = new ArrayList<>();
		List<Integer> aniadas = new ArrayList<>();
		List<String> nombresVinos = new ArrayList<>();
		List<String> notasDeCata = new ArrayList<>();
		List<Double> preciosARS = new ArrayList<>();
		List<List<String>> enofilosPorVino = new ArrayList<>(); // Lista de listas para los enófilos

		// Recolectar datos
		for (Map.Entry<Vino, ArrayList<String>> entry : this.mapVinoNombreUsuarioEnofilos.entrySet()) {
			Vino vino = entry.getKey();
			nombresBodegas.add(vino.getBodega().getNombreBodega());
			aniadas.add(vino.getAniada());
			nombresVinos.add(vino.getNombre());
			notasDeCata.add(vino.getNotaDeCataBodega());
			preciosARS.add(vino.getPrecioARS());
			enofilosPorVino.add(entry.getValue());
		}

		//Llamar al metodo notificar
		notificar(nombresBodegas, aniadas, nombresVinos, notasDeCata, preciosARS, enofilosPorVino);
	}



	// ------------------------------------------------------------------------------------------------------------------------------------
	// finCU
	public void finCU() {
	}

	// --------------------------------------------
	//GETTERS Y SETTERS
	// --------------------------------------------




	public List<Bodega> getBodegaSeleccionada() {
		return bodegaSeleccionada;
	}

	public void setBodegaSeleccionada(List<Bodega> bodegaSeleccionada) {
		this.bodegaSeleccionada = bodegaSeleccionada;
	}

	public Maridaje getMaridaje() {
		return maridaje;
	}

	public void setMaridaje(Maridaje maridaje) {
		this.maridaje = maridaje;
	}

	public TipoUva getTipoUva() {
		return tipoUva;
	}

	public void setTipoUva(TipoUva tipoUva) {
		this.tipoUva = tipoUva;
	}

	public List<Vino> getListaVinosCreados() {
		return listaVinosCreados;
	}

	public void setListaVinosCreados(List<Vino> listaVinosCreados) {
		this.listaVinosCreados = listaVinosCreados;
	}

	public List<Enofilo> getSeguidoresBodega() {
		return seguidoresDeBodega;
	}

	public void setSeguidoresBodega(List<Enofilo> seguidoresDeBodega) {
		this.seguidoresDeBodega = seguidoresDeBodega;
	}


	public void setListaBodegas(List<Bodega> listaBodegas) {
		this.listaBodegas = listaBodegas;
	}
}