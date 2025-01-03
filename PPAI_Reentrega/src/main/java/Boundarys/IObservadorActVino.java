package Boundarys;

import java.util.ArrayList;
import java.util.List;

public interface IObservadorActVino {
    void notificarActualizacion(List<String> nombresBodegas,
                                List<Integer> aniadas,
                                List<String> nombresVinos,
                                List<String> notasDeCata,
                                List<Double> preciosARS,
                                List<List<String>> enofilos);
}