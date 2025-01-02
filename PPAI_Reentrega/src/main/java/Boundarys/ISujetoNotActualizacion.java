package Boundarys;

import java.util.ArrayList;

public interface ISujetoNotActualizacion {

    void suscribir(ArrayList<IObservadorActVino> observador);
    void quitar(IObservadorActVino observador);
    void notificarObservadores();

}
