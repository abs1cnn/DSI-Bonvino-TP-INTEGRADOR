import Clases.Bodega;
import Clases.Enofilo;
import Clases.Maridaje;
import service.*;

import java.util.List;
import Clases.*;

public class main {
    public static void main(String[] args) {

        BodegaService bodegaService = new BodegaService();
        VinoService vinoService = new VinoService();
        CobroPremiumService cobroPremiumService = new CobroPremiumService();
        EnofiloService enofiloService = new EnofiloService();
        MaridajeService maridajeService = new MaridajeService();
        ReseniaService reseniaService = new ReseniaService();
        TipoUvaService tipoUvaService = new TipoUvaService();
        UsuarioService usuarioService = new UsuarioService();
        VarietalService varietalService = new VarietalService();
        SiguiendoService siguiendoService = new SiguiendoService();


        System.out.println("-----------------------------------------");
        // Obtener y mostrar enófilos
        List<Enofilo> enofilosBdd = enofiloService.obtenerEnofilos();
        for (Enofilo enofilo : enofilosBdd) {
            System.out.println(enofilo);
        }
        System.out.println("-----------------------------------------");
        System.out.println("ola");
        System.out.println("adiosh");
        System.out.println("-----------------------------------------");


    /*
        for (Vino vino :vinoService.obtenerVinos()){
            System.out.println("hola");
            System.out.println(vino.getNombre());
            System.out.println(vino.getAniada());
            System.out.println(vino.getImagenEtiqueta());
            System.out.println(vino.getNotaDeCataBodega());
            System.out.println(vino.getPrecioARS());
            System.out.println(vino.getBodega());
            System.out.println(vino.getResenia());
            for (int i = 0; i < vino.getResenia().size(); i++) {
                System.out.println(vino.getResenia().get(i).getPuntaje());
                System.out.println(vino.getResenia().get(i).getComentario());
            }
            System.out.println(vino.getMaridaje());
            for (int i = 0; i < vino.getMaridaje().size(); i++) {
                System.out.println(vino.getMaridaje().get(i).getNombre());
            }
            System.out.println(vino.getVarietal());
            for (int i = 0; i < vino.getVarietal().size(); i++) {
                System.out.println(vino.getVarietal().get(i).getDescripcion());
                System.out.println(vino.getVarietal().get(i).getPorcentajeComposicion());
                System.out.println(vino.getVarietal().get(i).getTipoUva());
            }
        }
    */

/*
        // Obtener y mostrar cobros premium
        List<CobroPremium> cobrosPremiumBdd = cobroPremiumService.obtenerCobrosPremium();
        System.out.println("Cobros Premium: " + cobrosPremiumBdd);
*/

/*
        // Obtener y mostrar maridajes
        List<Maridaje> maridajesBdd = maridajeService.obtenerMaridajes();
        System.out.println("Maridajes: " + maridajesBdd);

        // Obtener y mostrar reseñas
        List<Resenia> reseniasBdd = reseniaService.obtenerResenias();
        System.out.println("Reseñas: " + reseniasBdd);

        //Obtener y mostrar tipos de uva
        List<TipoUva> tiposUvaBdd = tipoUvaService.obtenerTiposUva();
        System.out.println("Tipos de Uva: " + tiposUvaBdd);


        // Obtener y mostrar usuarios
        List<Usuario> usuariosBdd = usuarioService.obtenerUsuarios();
        System.out.println("Usuarios: " + usuariosBdd);

        /* Obtener y mostrar varietales
        List<Varietal> varietalesBdd = varietalService.obtenerVarietales();
        System.out.println("Varietales: " + varietalesBdd);
        */

    }
}
