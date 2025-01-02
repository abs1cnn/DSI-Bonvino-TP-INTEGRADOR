package service;

import Clases.CobroPremium;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CobroPremiumService {
    private final String url = "jdbc:sqlite:src/main/resources/baseDeDatos/bdd"; // Asegúrate de poner la ruta correcta

    // Método para obtener todos los cobros premium
    public List<CobroPremium> obtenerCobrosPremium() {
        List<CobroPremium> cobrosPremium = new ArrayList<>();
        String query = "SELECT * FROM cobros_premium";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                CobroPremium cobroPremium = new CobroPremium();
                cobroPremium.setNroOperacionMercadoPago(rs.getInt("nro_operacion_mercado_pago"));
                cobroPremium.setEsAnual(rs.getBoolean("es_anual"));
                cobroPremium.setMonto(rs.getDouble("monto"));
                cobroPremium.setFechaPago(rs.getTimestamp("fecha_pago").toLocalDateTime());

                cobrosPremium.add(cobroPremium);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cobrosPremium;
    }

    public CobroPremium obtenerCobroPremiumPorUsuarioId(Integer idUsuario) {
        CobroPremium cobroPremium = null;
        String query = "SELECT * FROM cobros_premium WHERE id_usuario = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cobroPremium = new CobroPremium();
                cobroPremium.setNroOperacionMercadoPago(rs.getObject("nro_operacion_mercado_pago"));
                cobroPremium.setEsAnual(rs.getObject("es_anual"));
                cobroPremium.setMonto(rs.getObject("monto"));
                cobroPremium.setFechaPago(rs.getObject("fecha_pago"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cobroPremium;
    }
}