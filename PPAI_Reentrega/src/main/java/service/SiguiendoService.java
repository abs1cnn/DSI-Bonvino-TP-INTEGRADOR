package service;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import Clases.Enofilo;
import Clases.Bodega;
import Clases.Siguiendo;
import Clases.Sommelier;


public class SiguiendoService {
    private final String url = "jdbc:sqlite:src/main/resources/baseDeDatos/bdd";
    private final BodegaService bodegaService = new BodegaService();
    private final SommelierService sommelierService = new SommelierService();

    public List<Siguiendo> obtenerSeguidoresPorEnofilo(Integer idEnofilo) {
        String sql = """
        SELECT DISTINCT id_siguiendo, nombre_bodega, id_sommelier, id_enofilo_amigo, fecha_inicio, fecha_fin
        FROM siguiendo
        WHERE id_enofilo = ?
          AND (fecha_fin IS NULL OR fecha_fin > CURRENT_TIMESTAMP)
        """;
        List<Siguiendo> siguiendoList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idEnofilo);
            ResultSet rs = statement.executeQuery();

            Set<String> bodegasSeguidas = new HashSet<>();
            Set<Integer> sommeliersSeguidos = new HashSet<>();
            Set<Integer> amigosEnofilosSeguidos = new HashSet<>();

            while (rs.next()) {
                String nombreBodega = rs.getString("nombre_bodega");
                int idSommelier = rs.getInt("id_sommelier");
                int idEnofiloAmigo = rs.getInt("id_enofilo_amigo");
                String fechaInicio = rs.getString("fecha_inicio");
                String fechaFin = rs.getString("fecha_fin");

                // SETTEO ALGUNOS DATOS
                Siguiendo siguiendo = new Siguiendo();
                siguiendo.setFechaInicio(fechaInicio);
                siguiendo.setFechaFin(fechaFin);

                //-------------------------------------------------
                // Obtener y agregar bodegas sin duplicados Y SETTEARLO EN OBJETO SIGUIENDO
                if (nombreBodega != null) {
                    Bodega bodega = bodegaService.obtenerBodegaEntity(nombreBodega); // Usa el servicio para obtener Bodega
                    if (bodega != null) {
                        siguiendo.setBodega(bodega);
                    }
                }

                //-------------------------------------------------
                // Verificar y agregar sommeliers sin duplicados
                if (idSommelier != 0) {
                    Sommelier sommelier = sommelierService.obtenerSommelierEntity(idSommelier);
                    if (sommelier != null) {
                        siguiendo.setSommelier(sommelier);
                    }
                }

                // Obtener y agregar amigos enófilos sin duplicados
                if (idEnofiloAmigo != 0) {
                    siguiendo.setAmigo(idEnofiloAmigo);
                }

                // Agregar el objeto Siguiendo a la lista
                siguiendoList.add(siguiendo);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones adecuado
        }
        return siguiendoList;
    }

}
