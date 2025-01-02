package service;

import Clases.Sommelier;

import java.sql.*;

public class SommelierService {

    private final String url = "jdbc:sqlite:src/main/resources/baseDeDatos/bdd"; // Asegúrate de poner la ruta correcta


    public Sommelier obtenerSommelierEntity(Integer id_sommelier) {
        Sommelier sommelier = null;
        String query = "SELECT * FROM bodegas WHERE nombre_bodega = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id_sommelier);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                sommelier = new Sommelier(
                        rs.getString("id_sommelier"),
                        rs.getString("id_usuario"),
                        rs.getString("fecha_validacion"),
                        rs.getString("nombre"),
                        rs.getInt("nota_presentacion"),
                        rs.getString("ultima_actualizacion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sommelier;
    }
}