package Boundarys;

import java.util.ArrayList;

public interface IObservadorActVino {
    void notificarActualizacion(String nombreBodega, Integer aniada, String nombreVino, String notaDeCataBodega, Double precioARS, ArrayList<String> nombreUsuariosNotificar);
}
