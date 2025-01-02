package Boundarys;

import java.util.ArrayList;

public class InterfazNotificacion implements IObservadorActVino {

	@Override
	public void notificarActualizacion(String nombreBodega, Integer aniada, String nombreVino, String notaDeCataBodega, Double precioARS, ArrayList<String> nombreUsuariosNotificar) {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Se actualizo el vino: " + nombreVino + " de la bodega: " + nombreBodega);
		System.out.println("Añada: " + aniada);
		System.out.println("Nota de cata: " + notaDeCataBodega);
		System.out.println("Precio: " + precioARS);
	}


	private Object novedadesVinoParaBodega;


	public Object getNovedadesVinoParaBodega() {
		return novedadesVinoParaBodega;
	}


	public void setNovedadesVinoParaBodega(Object novedadesVinoParaBodega) {
		this.novedadesVinoParaBodega = novedadesVinoParaBodega;
	}


	public void notificarNovedadVino(ArrayList<String> nombresDeUsuariosSeguidores, String bodega) {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Envio de notificaciones de la bodega:" + bodega);
		for (String usuario : nombresDeUsuariosSeguidores) {
			System.out.println("Se le envio la notificacion al usuario: " + usuario);
		}
	}
}