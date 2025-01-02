package service;

import Clases.Usuario;
import Clases.CobroPremium;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private final String url = "jdbc:sqlite:src/main/resources/baseDeDatos/bdd"; // Asegúrate de poner la ruta correcta
    private final CobroPremiumService cobroPremiumService = new CobroPremiumService();

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPremium(rs.getBoolean("premium"));

                // Obtener CobroPremium si el usuario es premium
                Integer id_usuario = rs.getInt("id_usuario");
                if (usuario.getPremium()) {
                    CobroPremium cobroPremium = cobroPremiumService.obtenerCobroPremiumPorUsuarioId(id_usuario);
                    usuario.setCobroPremium(cobroPremium);
                }

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }


    // Obtener usuario por id_usuario
    public Usuario obtenerUsuarioPorIdentidad(Integer id) {
        Usuario usuario = null;
        String query = "SELECT * FROM usuarios WHERE id_usuario = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);  // Establecer el ID del usuario como parámetro para la búsqueda
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPremium(rs.getBoolean("premium"));

                // Obtener el CobroPremium asociado si el usuario es premium
                if (usuario.getPremium()) {
                    CobroPremium cobroPremium = cobroPremiumService.obtenerCobroPremiumPorUsuarioId(id);
                    usuario.setCobroPremium(cobroPremium);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}

