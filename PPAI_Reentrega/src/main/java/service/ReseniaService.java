package service;


import Clases.Resenia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReseniaService {
    private final String url = "jdbc:sqlite:src/main/resources/baseDeDatos/bdd"; // Asegúrate de poner la ruta correcta

    // Método para obtener todas las bodegas desde la base de datos
    public List<Resenia> obtenerReseniaEntity(int aniada, String nombre_vino) {
        List<Resenia> resenias = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);

             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM resenias WHERE aniada = " + aniada + " AND nombre_vino = '" + nombre_vino + "'")) {
            while (rs.next()) {
                // Obtener los IDs de NovedadEvento y RegionVitivinicola


                Resenia resenia = new Resenia(
                        rs.getString("comentario"),
                        rs.getBoolean("es_premium"),
                        rs.getString("fecha_resenia"),
                        rs.getInt("puntaje")
                );

                // Agregar la resenia a la lista
                resenias.add(resenia);

// Agregar la resenia a la lista
                resenias.add(resenia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resenias;
    }
    // Método para obtener todas las resenias desde la base de datos
    public List<Resenia> obtenerResenias() {
        List<Resenia> resenias = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM resenias")) {
            while (rs.next()) {
                Resenia resenia = new Resenia(
                        rs.getString("comentario"),
                        rs.getBoolean("es_premium"),
                        rs.getString("fecha_resenia"),
                        rs.getInt("puntaje")
                );

                // Agregar la resenia a la lista
                resenias.add(resenia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resenias;
    }
}


