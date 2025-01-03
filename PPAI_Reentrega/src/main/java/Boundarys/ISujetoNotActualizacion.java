package Boundarys;

import java.util.ArrayList;
import java.util.List;

public interface ISujetoNotActualizacion {

    void suscribir(ArrayList<IObservadorActVino> observador);
    void quitar(ArrayList<IObservadorActVino> observador);
    void notificar(List<String> nombresBodegas,
                   List<Integer> aniadas,
                   List<String> nombresVinos,
                   List<String> notasDeCata,
                   List<Double> preciosARS,
                   List<List<String>> enofilos);

}
