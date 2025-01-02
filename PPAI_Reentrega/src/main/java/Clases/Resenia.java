package Clases;

import java.util.Date;



public class Resenia {
	//ATRIBUTOS
	private String comentario;
	private Boolean esPremium;
	private String fechaResenia;
	private Integer puntaje;

	//CONSTRUCTOR

	public Resenia(String comentario, Boolean esPremium, String fechaResenia, Integer puntaje) {
		this.comentario = comentario;
		this.esPremium = esPremium;
		this.fechaResenia = fechaResenia;
		this.puntaje = puntaje;
	}

	public Resenia(){

	}

	//METODOS
	public void esPremium() {

	}

	public void sosDeEnofilo() {

	}

	public void sosDeSomelier() {

	}

	//GETTERS Y SETTERS
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Boolean getEsPremium() {
		return esPremium;
	}

	public void setEsPremium(Boolean esPremium) {
		this.esPremium = esPremium;
	}

	public String getFechaResenia() {
		return fechaResenia;
	}

	public void setFechaResenia(String fechaResenia) {
		this.fechaResenia = fechaResenia;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

}