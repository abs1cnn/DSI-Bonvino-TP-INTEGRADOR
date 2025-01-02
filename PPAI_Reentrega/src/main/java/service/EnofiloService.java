package service;
import Clases.Enofilo;
import Clases.Siguiendo;
import Clases.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import service.UsuarioService;

public class EnofiloService {
    private final String url = "jdbc:sqlite:src/main/resources/baseDeDatos/bdd"; // Asegúrate de poner la ruta correcta
    private final UsuarioService usuarioService = new UsuarioService();
    private final SiguiendoService siguiendoService = new SiguiendoService();

    public ArrayList<Enofilo> obtenerEnofilos() {
        ArrayList<Enofilo> enofilos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM enofilos")) { // Asegúrate de que la tabla se llame 'Bodegas'

            while (rs.next()) {
                Enofilo enofilo = new Enofilo();

                // Obtener el Usuario a partir del id_usuario
                Integer idUsuario = rs.getInt("id_usuario");
                Usuario usuario = usuarioService.obtenerUsuarioPorIdentidad(idUsuario); // Asumiendo que existe este método
                enofilo.setUsuario(usuario);

                enofilo.setApellido(rs.getString("apellido"));
                enofilo.setImagenPerfil(rs.getString("imagen_perfil"));
                enofilo.setNombre(rs.getString("nombre"));

                // LLenar la lista de seguidores
                List<Siguiendo> seguidores = siguiendoService.obtenerSeguidoresPorEnofilo(rs.getInt("id_enofilo"));
                enofilo.setSiguiendo(seguidores);


                enofilos.add(enofilo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enofilos;
    }


    public Enofilo obtenerEnofiloPorId(Integer id) {
        Enofilo enofilo = null;

        String sql = "SELECT * FROM enofilos WHERE id_enofilo = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id); // Establecemos el valor del parámetro (id_enofilo)

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    enofilo = new Enofilo();

                    // Obtener el Usuario a partir del id_usuario
                    Integer idUsuario = rs.getInt("id_usuario");
                    Usuario usuario = usuarioService.obtenerUsuarioPorIdentidad(idUsuario); // Asumiendo que existe este método
                    enofilo.setUsuario(usuario);

                    enofilo.setApellido(rs.getString("apellido"));
                    enofilo.setImagenPerfil(rs.getString("imagen_perfil"));
                    enofilo.setNombre(rs.getString("nombre"));

                    // LLenar la lista de seguidores (si los hay)
                    List<Siguiendo> seguidores = siguiendoService.obtenerSeguidoresPorEnofilo(id);
                    enofilo.setSiguiendo(seguidores);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones adecuado
        }

        return enofilo; // Devuelve el objeto Enofilo o null si no se encuentra
    }

}

