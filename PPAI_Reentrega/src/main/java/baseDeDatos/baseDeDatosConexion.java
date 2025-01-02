package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class baseDeDatosConexion {

    private static final String URL = "jdbc:sqlite:src/main/resources/baseDeDatos/bdd";

    // Method to create a connection to the database
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /*
    // Method to create a new table
    public static void crearMaridajeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Maridajes (\n"
                + " id integer PRIMARY KEY,\n"
                + " nombre text NOT NULL,\n"
                + " descripcion NOT NULL\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla maridaje creada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para crear la tabla TipoUva
    public static void createTipoUvaTable() {
        String sql = "CREATE TABLE IF NOT EXISTS TipoUva (\n"
                + " id integer PRIMARY KEY,\n"
                + " nombre text NOT NULL,\n"
                + " descripcion text NOT NULL\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla TipoUva creada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para crear la tabla Varietales
    public static void createVarietalesTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Varietales (\n"
                + " id integer PRIMARY KEY,\n"
                + " descripcion text NOT NULL,\n"
                + " porcentajeComposicion real,\n"
                + " idTipoUva integer NOT NULL,\n"
                + " FOREIGN KEY (idTipoUva) REFERENCES TipoUva(id)\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla Varietales creada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para insertar datos en la tabla TipoUva
    public static void insertTipoUva(String nombre, String descripcion) {
        String sql = "INSERT INTO TipoUva(nombre, descripcion) VALUES(?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);
            pstmt.executeUpdate();
            System.out.println("Datos de TipoUva insertados.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para insertar datos en la tabla Varietales
    public static void insertVarietal(String descripcion, double porcentajeComposicion, int idTipoUva) {
        String sql = "INSERT INTO Varietales(descripcion, porcentajeComposicion, idTipoUva) VALUES(?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, descripcion);
            pstmt.setDouble(2, porcentajeComposicion);
            pstmt.setInt(3, idTipoUva);
            pstmt.executeUpdate();
            System.out.println("Datos de Varietal insertados.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to insert data into the table
    public static void insertMaridaje(String nombre, String description) {
        String sql = "INSERT INTO Maridajes(nombre, descripcion) VALUES(?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, description);
            pstmt.executeUpdate();
            System.out.println("Maridaje insertado con exito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to create the Vinos table
    public static void createVinosTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Vinos (\n"
                + " id integer PRIMARY KEY,\n"
                + " aniada integer NOT NULL,\n"
                + " imagenEtiqueta text,\n"
                + " nombre text NOT NULL,\n"
                + " notaDeCata text,\n"
                + " bodega text NOT NULL,\n"
                + " precioARS real NOT NULL,\n"
                + " idBodega integer NOT NULL\n"
                + " FOREIGN KEY (idBodega) REFERENCES Bodegas(idBodega)\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Vinos table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to insert data into the Vinos table
    public static void insertVino(int aniada, String imagenEtiqueta, String nombre, String notaDeCata, String bodega, double precioARS, int idBodega) {
        String sql = "INSERT INTO Vinos(aniada, imagenEtiqueta, nombre, notaDeCata, bodega, precioARS, idBodega) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, aniada);
            pstmt.setString(2, imagenEtiqueta);
            pstmt.setString(3, nombre);
            pstmt.setString(4, notaDeCata);
            pstmt.setString(5, bodega);
            pstmt.setDouble(6, precioARS);
            pstmt.setInt(7, idBodega);
            pstmt.executeUpdate();
            System.out.println("Vino data has been inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to create the MaridajeXVino table
    public static void createMaridajeXVinoTable() {
        String sql = "CREATE TABLE IF NOT EXISTS MaridajeXVino (\n"
                + " idMaridaje integer NOT NULL,\n"
                + " idVino integer NOT NULL,\n"
                + " PRIMARY KEY (idMaridaje, idVino),\n"
                + " FOREIGN KEY (idMaridaje) REFERENCES Maridajes(id),\n"
                + " FOREIGN KEY (idVino) REFERENCES Vinos(id)\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("MaridajeXVino table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to create the VarietalesXVino table
    public static void createVarietalesXVinoTable() {
        String sql = "CREATE TABLE IF NOT EXISTS VarietalesXVino (\n"
                + " idVarietal integer NOT NULL,\n"
                + " idVino integer NOT NULL,\n"
                + " PRIMARY KEY (idVarietal, idVino),\n"
                + " FOREIGN KEY (idVarietal) REFERENCES Varietales(id),\n"
                + " FOREIGN KEY (idVino) REFERENCES Vinos(id)\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("VarietalesXVino table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to insert data into the MaridajeXVino table
    public static void insertMaridajeXVino(int idMaridaje, int idVino) {
        String sql = "INSERT INTO MaridajeXVino(idMaridaje, idVino) VALUES(?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idMaridaje);
            pstmt.setInt(2, idVino);
            pstmt.executeUpdate();
            System.out.println("MaridajeXVino data has been inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to insert data into the VarietalesXVino table
    public static void insertVarietalesXVino(int idVarietal, int idVino) {
        String sql = "INSERT INTO VarietalesXVino(idVarietal, idVino) VALUES(?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idVarietal);
            pstmt.setInt(2, idVino);
            pstmt.executeUpdate();
            System.out.println("VarietalesXVino data has been inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to create the Bodega table
    public static void createBodegaTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Bodega (\n"
                + " id integer PRIMARY KEY,\n"
                + " descripcion text NOT NULL,\n"
                + " historia text,\n"
                + " nombre text NOT NULL,\n"
                + " periodoActualizacion text,\n"
                + " idCordenadas integer NOT NULL,\n"
                + " idRegionVinicola integer NOT NULL,\n"
                + " FOREIGN KEY (idCordenadas) REFERENCES Cordenadas(id),\n"
                + " FOREIGN KEY (idRegionVinicola) REFERENCES RegionVinicola(id)\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Bodega table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to insert data into the Bodega table
    public static void insertBodega(String descripcion, String historia, String nombre, String periodoActualizacion, int idCordenadas, int idRegionVinicola) {
        String sql = "INSERT INTO Bodega(descripcion, historia, nombre, periodoActualizacion, idCordenadas, idRegionVinicola) VALUES(?,?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, descripcion);
            pstmt.setString(2, historia);
            pstmt.setString(3, nombre);
            pstmt.setString(4, periodoActualizacion);
            pstmt.setInt(5, idCordenadas);
            pstmt.setInt(6, idRegionVinicola);
            pstmt.executeUpdate();
            System.out.println("Bodega data has been inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // Method to create the Cordenadas table
    public static void createCordenadasTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Cordenadas (\n"
                + " latitud real NOT NULL,\n"
                + " longuitud real NOT NULL,\n"
                + " PRIMARY KEY (latitud, longuitud)\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Cordenadas table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to insert data into the Cordenadas table
    public static void insertCordenadas(double latitud, double longuitud) {
        String sql = "INSERT INTO Cordenadas(latitud, longuitud) VALUES(?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, latitud);
            pstmt.setDouble(2, longuitud);
            pstmt.executeUpdate();
            System.out.println("Cordenadas data has been inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to create the NovedadesEventos table
    public static void createNovedadesEventosTable() {
        String sql = "CREATE TABLE IF NOT EXISTS NovedadesEventos (\n"
                + " id integer PRIMARY KEY,\n"
                + " codDescuentoPremium text,\n"
                + " descripcion text NOT NULL,\n"
                + " esSoloPrimium boolean NOT NULL,\n"
                + " fechaHoraEvento text NOT NULL,\n"
                + " nombreEvento text NOT NULL\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("NovedadesEventos table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // Method to insert data into the NovedadesEventos table
    public static void insertNovedadesEventos(String codDescuentoPremium, String descripcion, boolean esSoloPrimium, String fechaHoraEvento, String nombreEvento) {
        String sql = "INSERT INTO NovedadesEventos(codDescuentoPremium, descripcion, esSoloPrimium, fechaHoraEvento, nombreEvento) VALUES(?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codDescuentoPremium);
            pstmt.setString(2, descripcion);
            pstmt.setBoolean(3, esSoloPrimium);
            pstmt.setString(4, fechaHoraEvento);
            pstmt.setString(5, nombreEvento);
            pstmt.executeUpdate();
            System.out.println("NovedadesEventos data has been inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // Method to create the BodegasXNovedades table
    public static void createBodegasXNovedadesTable() {
        String sql = "CREATE TABLE IF NOT EXISTS BodegasXNovedades (\n"
                + " idBodega integer NOT NULL,\n"
                + " idNovedadEvento integer NOT NULL,\n"
                + " PRIMARY KEY (idBodega, idNovedadEvento),\n"
                + " FOREIGN KEY (idBodega) REFERENCES Bodega(id),\n"
                + " FOREIGN KEY (idNovedadEvento) REFERENCES NovedadesEventos(id)\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("BodegasXNovedades table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // Method to insert data into the BodegasXNovedades table
    public static void insertBodegasXNovedades(int idBodega, int idNovedadEvento) {
        String sql = "INSERT INTO BodegasXNovedades(idBodega, idNovedadEvento) VALUES(?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idBodega);
            pstmt.setInt(2, idNovedadEvento);
            pstmt.executeUpdate();
            System.out.println("BodegasXNovedades data has been inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        crearMaridajeTable();
        createTipoUvaTable();
        createVarietalesTable();
        createVinosTable();
        createVarietalesXVinoTable();
        createMaridajeXVinoTable();
        createBodegasXNovedadesTable();
        createNovedadesEventosTable();
        createCordenadasTable();
        insertMaridaje("Maridaje 1", "Descripcion 1");
        insertMaridaje("Maridaje 2", "Descripcion 2");
        insertTipoUva("Malbec", "Vino tinto");
        insertTipoUva("Cabernet Sauvignon", "Vino tinto");
        insertVarietal("Malbec", 0.5, 1);
        insertVarietal("Cabernet Sauvignon", 0.5, 2);
    }

     */
}
