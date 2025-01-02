// src/main/java/service/TipoUvaService.java
package service;

import Clases.TipoUva;

import java.sql.*;
import java.util.ArrayList;

public class TipoUvaService {
    private final String url = "jdbc:sqlite:src/main/resources/baseDeDatos/bdd"; // Asegúrate de poner la ruta correcta

    // Método para obtener todas las bodegas desde la base de datos
    public TipoUva obtenerTipoUvaEntity(String nombreTipoUva) {
        TipoUva tipoUva = new TipoUva();

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tipoUvas WHERE nombre = '" + nombreTipoUva + "'")) {

            if (rs.next()) {
                tipoUva.setNombre(rs.getString("nombre"));
                tipoUva.setDescripcion(rs.getString("descripcion"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipoUva;
    }

    // Método para obtener todos los tipos de uvas desde la base de datos
    public ArrayList<TipoUva> obtenerTiposUva() {
        ArrayList<TipoUva> tiposUva = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tipoUvas")) {
            while (rs.next()) {
                TipoUva tipoUva = new TipoUva();
                tipoUva.setNombre(rs.getString("nombre"));
                tipoUva.setDescripcion(rs.getString("descripcion"));

                // Agregar el tipo de uva a la lista
                tiposUva.add(tipoUva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tiposUva;
    }

    // Método para insertar un nuevo tipo de uva en la base de datos
    public void insertarTipoUva(String nombre, String descripcion) {
        String query = "INSERT INTO tipoUvas (nombre, descripcion) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}