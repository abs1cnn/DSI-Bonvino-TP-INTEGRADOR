package service;

import Clases.Maridaje;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaridajeService {
    private final String url = "jdbc:sqlite:src/main/resources/baseDeDatos/bdd"; // Asegúrate de poner la ruta correcta

    // Método para obtener todas las bodegas desde la base de datos
    public List<Maridaje> obtenerVarietalesEntity(int aniada, String nombre_vino) {
        List<Maridaje> maridajes = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);

             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM maridajes join vino_maridaje on maridajes.nombre_maridaje = vino_maridaje.nombre_maridaje  WHERE vino_maridaje.aniada = " + aniada + " AND vino_maridaje.nombre_vino = '" + nombre_vino + "'")) {
            while (rs.next()) {
                // Obtener los IDs de NovedadEvento y RegionVitivinicola

                // Crear el objeto Bodega con todos los nuevos campos
                Maridaje maridaje = new Maridaje(
                        rs.getString("nombre_maridaje"),
                        rs.getString("descripcion")
                );

                // Agregar la bodega a la lista
                maridajes.add(maridaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maridajes;
    }
    // Método para obtener todos los maridajes desde la base de datos
    public ArrayList<Maridaje> obtenerMaridajes() {
        ArrayList<Maridaje> maridajes = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM maridajes")) {
            while (rs.next()) {
                Maridaje maridaje = new Maridaje(
                        rs.getString("nombre_maridaje"),
                        rs.getString("descripcion")
                );

                // Agregar el maridaje a la lista
                maridajes.add(maridaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maridajes;
    }

    // Método para insertar un nuevo maridaje en la base de datos
    public void insertarMaridaje(String nombre_maridaje, String descripcion) {
        String query = "INSERT INTO maridajes (nombre_maridaje, descripcion) VALUES (?, ?)";
        //A PRIMARY KEY constraint failed (UNIQUE constraint failed: maridajes.nombre_maridaje)
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre_maridaje);
            pstmt.setString(2, descripcion);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
