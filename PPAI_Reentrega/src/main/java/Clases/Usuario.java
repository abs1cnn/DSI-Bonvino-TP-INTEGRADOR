package Clases;

public class Usuario {
	//ATRIBUTOS
	private String contrasenia;
	private String nombre;
	private Boolean premium;
	private CobroPremium cobroPremium;

	//CONSTRUCTOR
	public Usuario(String contrasenia, String nombre, Boolean premium, CobroPremium cobroPremium) {
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.premium = premium;
		this.cobroPremium = cobroPremium;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"contrasenia='" + contrasenia + '\'' +
				", nombre='" + nombre + '\'' +
				", premium=" + premium +
				", cobroPremium=" + cobroPremium +
				'}';
	}

	public Usuario() {}

    //METODOS
	public void esPremium() {

	}

	public void esTuUsuario() {
	}

	public void mostrarNombre() {

	}

	//GETTERS Y SETTERS
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getPremium() {
		return premium;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
	}

	public CobroPremium getCobroPremium() {
		return cobroPremium;
	}

	public void setCobroPremium(CobroPremium cobroPremium) {
		this.cobroPremium = cobroPremium;
	}
}