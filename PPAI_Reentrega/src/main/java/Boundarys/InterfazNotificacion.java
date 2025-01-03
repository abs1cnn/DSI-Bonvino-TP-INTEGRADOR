package Boundarys;

import java.util.List;

public class InterfazNotificacion implements IObservadorActVino {

	@Override
	public void notificarActualizacion(List<String> nombresBodegas,
									   List<Integer> aniadas,
									   List<String> nombresVinos,
									   List<String> notasDeCata,
									   List<Double> preciosARS,
									   List<List<String>> enofilosPorVino) {

		for (int i = 0; i < nombresVinos.size(); i++) {
			String cuerpoMensaje = "Se ha actualizado el vino " + nombresVinos.get(i) + " de la bodega " + nombresBodegas.get(i) + " del año " + aniadas.get(i) + " con la siguiente nota de cata: "
					+ notasDeCata.get(i) + " y un precio de " + preciosARS.get(i) + "ARS";

			for (String usuario : enofilosPorVino.get(i)) {
				notificarNovedadVino(usuario, cuerpoMensaje);
			}
		}

	}


	private Object novedadesVinoParaBodega;


	public Object getNovedadesVinoParaBodega() {
		return novedadesVinoParaBodega;
	}


	public void setNovedadesVinoParaBodega(Object novedadesVinoParaBodega) {
		this.novedadesVinoParaBodega = novedadesVinoParaBodega;
	}


	public void notificarNovedadVino(String nombresDeUsuariosSeguidores, String cuerpo) {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Se ha notificado a " + nombresDeUsuariosSeguidores + " la siguiente novedad: " + cuerpo);
	}
}