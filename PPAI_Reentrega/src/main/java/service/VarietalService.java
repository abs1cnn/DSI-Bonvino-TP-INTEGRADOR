package service;

import Clases.Varietal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VarietalService {

    private final String url = "jdbc:sqlite:src/main/resources/baseDeDatos/bdd"; // Asegúrate de poner la ruta correcta

    // Método para obtener todas las bodegas desde la base de datos
    public List<Varietal> obtenerVarietalesEntity(int aniada, String nombre_vino) {
        List<Varietal> varietales = new ArrayList<>();
        TipoUvaService tipoUvaService = new TipoUvaService();

        try (Connection conn = DriverManager.getConnection(url);

             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM varietales join vino_varietales on varietales.nombre_tipo_uva = vino_varietales.nombre_tipo_uva and varietales.porcentaje_composicion = vino_varietales.porcentaje_composicion  WHERE vino_varietales.aniada = " + aniada + " AND vino_varietales.nombre_vino = '" + nombre_vino + "'")) {
            while (rs.next()) {
                // Obtener los IDs de NovedadEvento y RegionVitivinicola

                // Crear el objeto Bodega con todos los nuevos campos
                Varietal varietal = new Varietal(
                        rs.getString("descripcion"),
                        rs.getDouble("porcentaje_composicion"),
                        tipoUvaService.obtenerTipoUvaEntity(rs.getString("nombre_tipo_uva"))
                );

                // Agregar la bodega a la lista
                varietales.add(varietal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return varietales;
    }
    // Método para obtener todos los varietales desde la base de datos
    public ArrayList<Varietal> obtenerVarietales() {
        ArrayList<Varietal> varietales = new ArrayList<>();
        TipoUvaService tipoUvaService = new TipoUvaService();

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM varietales")) {
            while (rs.next()) {
                Varietal varietal = new Varietal(
                        rs.getString("descripcion"),
                        rs.getDouble("porcentaje_composicion"),
                        tipoUvaService.obtenerTipoUvaEntity(rs.getString("nombre_tipo_uva"))
                );

                // Agregar el varietal a la lista
                varietales.add(varietal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return varietales;
    }
    // Método para insertar un nuevo varietal en la base de datos
    public void insertarVarietal(String nombre_tipo_uva, double porcentaje_composicion, String descripcion) {
        String query = "INSERT INTO varietales (nombre_tipo_uva, porcentaje_composicion, descripcion) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre_tipo_uva);
            pstmt.setDouble(2, porcentaje_composicion);
            pstmt.setString(3, descripcion);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para verificar si ya existe un varietal en la tabla vino_varietal
    public boolean existeVarietal(String nombre_tipo_uva, Double porcentaje_composicion) {
        String query = "SELECT COUNT(*) FROM vino_varietal WHERE nombre_tipo_uva = ? AND porcentaje_composicion = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre_tipo_uva);
            pstmt.setDouble(2, porcentaje_composicion);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;  // Retorna true si ya existe un registro con esta combinación
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  // Retorna false si no hay registros o si ocurre una excepción
    }

}
