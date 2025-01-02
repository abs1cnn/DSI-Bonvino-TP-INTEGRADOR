package Clases;

//----------------------------------
import Clases.Siguiendo;
import Clases.Usuario;
//----------------------------------

import java.util.List;
import java.util.Set;

public class Enofilo {
	//ATRIBUTOS
	private String apellido;
	private String imagenPerfil;
	private String nombre;
	private List<Siguiendo> siguiendo; ;
	private Usuario usuario;

	//CONSTRUCTOR
	public Enofilo(String apellido, String imagenPerfil, String nombre, List<Siguiendo> siguiendo, Usuario usuario) {
		this.apellido = apellido;
		this.imagenPerfil = imagenPerfil;
		this.nombre = nombre;
		this.siguiendo = siguiendo;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Enofilo{" +
				"apellido='" + apellido + '\'' +
				", imagenPerfil='" + imagenPerfil + '\'' +
				", nombre='" + nombre + '\'' +
				", siguiendo=" + siguiendo +
				", usuario=" + usuario +
				'}';
	}

	public Enofilo() { }

    //METODOS
	public void mostrarAmigosSeguidos() {
	}

	public void mostarColeccionFavoritos() {

	}

	public Boolean seguisBodega(String bodegaSeleccionada) {
		for (Siguiendo siguiendo : siguiendo) {
			// POR SI LA BODEGA ESTA VACIA Y SIGUE OTRA COSA
			if (siguiendo.getBodega() != null){
				System.out.println(siguiendo.getBodega().getNombreBodega());
				if (siguiendo.sosDeBodega(bodegaSeleccionada)) {
					return true;
				}

			}
		}
		return false;
	}

	public String getNombreUsuario() {
		System.out.println();
		return this.usuario.getNombre();
	}


	//GETTERS Y SETTERS
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getImagenPerfil() {
		return imagenPerfil;
	}

	public void setImagenPerfil(String imagenPerfil) {
		this.imagenPerfil = imagenPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Siguiendo> getSiguiendo() {
		return siguiendo;
	}

	public void setSiguiendo(List<Siguiendo> siguiendo) {
		this.siguiendo = siguiendo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}



