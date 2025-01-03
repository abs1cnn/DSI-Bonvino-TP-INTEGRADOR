package service;

import Clases.Bodega;
import Clases.Vino;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BodegaService {
    private final String url = "jdbc:sqlite:src/main/resources/baseDeDatos/bdd"; // Asegúrate de poner la ruta correcta

    // Método para obtener todas las bodegas desde la base de datos
    public List<Bodega> obtenerBodegas() {
        List<Bodega> bodegas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM bodegas")) { // Asegúrate de que la tabla se llame 'Bodegas'

            while (rs.next()) {
                // Obtener los IDs de NovedadEvento y RegionVitivinicola

                // Crear el objeto Bodega con todos los nuevos campos
                Bodega bodega = new Bodega(
                        rs.getString("coordenadas"), // Coordenadas de ubicación
                        rs.getString("descripcion"), // Descripción de la bodega
                        rs.getString("historia"), // Historia de la bodega
                        rs.getString("nombre_bodega"), // Nombre de la bodega
                        rs.getInt("periodo_actualizacion"), // Periodo de actualización
                        rs.getString("ultima_actualizacion") // Última actualización (como String)
                );

                // Agregar la bodega a la lista
                bodegas.add(bodega);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bodegas;
    }

    public Bodega obtenerBodegaEntity(String nombreBodega) {
        Bodega bodega = null;
        String query = "SELECT * FROM bodegas WHERE nombre_bodega = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, nombreBodega);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                bodega = new Bodega(
                        rs.getString("coordenadas"), // Coordenadas de ubicación
                        rs.getString("descripcion"), // Descripción de la bodega
                        rs.getString("historia"), // Historia de la bodega
                        rs.getString("nombre_bodega"), // Nombre de la bodega
                        rs.getInt("periodo_actualizacion"), // Periodo de actualización
                        rs.getString("ultima_actualizacion") // Última actualización (como String)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bodega;
    }


    public void actualizarBodega(Bodega bod){

        String query = "UPDATE bodegas SET coordenadas = ?, descripcion = ?, historia = ?, periodo_actualizacion = ?, ultima_actualizacion = ? WHERE nombre_bodega = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, bod.getCoordenadasUbicacion());
            pstmt.setString(2, bod.getDescripcion());
            pstmt.setString(3, bod.getHistoria());
            pstmt.setInt(4, bod.getPeriodoActualizacion());
            pstmt.setString(5, bod.getUltimaActualizacion());
            pstmt.setString(6, bod.getNombreBodega());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
    }

    }

    public boolean actualizarVino(Vino vino) {

        String nombreVino = vino.getNombre();
        Integer aniada = vino.getAniada();
        String nombreBodega = vino.getBodega().getNombreBodega();
        String notaDeCataBodega = vino.getNotaDeCataBodega();
        Double precioArs = vino.getPrecioARS();
        String imagenEtiqueta = vino.getImagenEtiqueta();


        String query = "UPDATE vinos SET nombre_bodega = ?, nota_de_cata_bodega = ?, precio_ars = ?, imagen_etiqueta = ? " +
                "WHERE nombre_vino = ? AND aniada = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Asignamos los parámetros a la consulta
            pstmt.setString(1, nombreBodega);
            pstmt.setString(2, notaDeCataBodega);
            pstmt.setDouble(3, precioArs);
            pstmt.setString(4, imagenEtiqueta);
            pstmt.setString(5, nombreVino);
            pstmt.setInt(6, aniada);

            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("--------------------------------------------------");
                System.out.println("Vino actualizado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró el vino para actualizar. Se Creara <3");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    // Método para obtener la NovedadEvento por su ID
    private NovedadEvento obtenerNovedadEventoPorId(Connection conn, int id) {
        String query = "SELECT * FROM novedadEvento WHERE id_novedad_evento = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new NovedadEvento(
                            rs.getInt("id_novedad_evento"),
                            rs.getInt("esSoloPremium"),
                            rs.getString("fechaHoraEvento"),
                            rs.getString("codDescPremium"),
                            rs.getString("descripcion"),
                            rs.getString("nombreEvento")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para obtener la RegionVitivinicola por su ID
    private RegionVitivinicola obtenerRegionVitivinicolaPorId(Connection conn, int id) {
        String query = "SELECT * FROM regionVitivinicola WHERE id_regionVitivinicola = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new RegionVitivinicola(
                            rs.getInt("id_regionVitivinicola"),
                            rs.getString("id_Provincia"),
                            rs.getString("nombre")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

     */
}


