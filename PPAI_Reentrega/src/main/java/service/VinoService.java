package service;

import Clases.Vino;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VinoService {

    private final String url = "jdbc:sqlite:src/main/resources/baseDeDatos/bdd"; // Asegúrate de poner la ruta correcta

    // Método para obtener todas las bodegas desde la base de datos
    public List<Vino> obtenerVinos() {
        List<Vino> vinos = new ArrayList<>();
        ReseniaService reseniaService = new ReseniaService();
        MaridajeService maridajeService = new MaridajeService();
        VarietalService varietalService = new VarietalService();
        BodegaService bodegaService = new BodegaService();

        try (Connection conn = DriverManager.getConnection(url);

             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM vinos")){
            while (rs.next()) {
                // Obtener los IDs de NovedadEvento y RegionVitivinicola

                // Crear el objeto Bodega con todos los nuevos campos
                Vino vino = new Vino(
                        rs.getInt("aniada"),
                        rs.getString("imagen_etiqueta"),
                        rs.getString("nombre_vino"),
                        rs.getString("nota_de_cata_bodega"),
                        rs.getDouble("precio_ars")
                );
                vino.setResenia(reseniaService.obtenerReseniaEntity(rs.getInt("aniada"), rs.getString("nombre_vino")));
                vino.setMaridaje(maridajeService.obtenerVarietalesEntity(rs.getInt("aniada"), rs.getString("nombre_vino")));
                vino.setVarietal(varietalService.obtenerVarietalesEntity(rs.getInt("aniada"), rs.getString("nombre_vino")));
                vino.setBodega(bodegaService.obtenerBodegaEntity(rs.getString("nombre_bodega")));

                // Agregar la bodega a la lista
                vinos.add(vino);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vinos;
    }


    // Método para insertar un nuevo vino en la base de datos
    public void insertarVino(int aniada, String imagen_etiqueta, String nombre_vino, String nota_de_cata_bodega, double precio_ars, String nombre_bodega) {
        String query = "INSERT INTO vinos (aniada, imagen_etiqueta, nombre_vino, nota_de_cata_bodega, precio_ars, nombre_bodega) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, aniada);
            pstmt.setString(2, imagen_etiqueta);
            pstmt.setString(3, nombre_vino);
            pstmt.setString(4, nota_de_cata_bodega);
            pstmt.setDouble(5, precio_ars);
            pstmt.setString(6, nombre_bodega);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para insertar un nuevo vino en la base de datos
    public void insertarVinoXMaridaje(String nombre_vino, Integer aniada, String nombre_maridaje) {
        String query = "INSERT INTO vino_maridaje (nombre_vino, aniada, nombre_maridaje) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre_vino);
            pstmt.setInt(2, aniada);
            pstmt.setString(3, nombre_maridaje);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para insertar un nuevo vino en la base de datos
    public void insertarVinoXVarietal(String nombre_vino, Integer aniada, String nombre_tipo_uva, Double porcentaje_composicion) {
        String query = "INSERT INTO vino_varietales (nombre_vino, aniada, nombre_tipo_uva, porcentaje_composicion ) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre_vino);
            pstmt.setInt(2, aniada);
            pstmt.setString(3, nombre_tipo_uva);
            pstmt.setDouble(4, porcentaje_composicion);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
