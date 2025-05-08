package Models.Repositories;

import Models.Entities.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputadorRepository {

    private Connection getConnection() throws SQLException {
        // Detalles de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/act2_devweb?serverTimezone=America/Bogota";
        String user = "ramiro_espana";
        String password = "AbcdeUdeC";
        return DriverManager.getConnection(url, user, password);
    }

    public void guardarComputador(Computador computador) {
        String sql = "INSERT INTO Computadores (marca, categoria, marcaCpu, velocidadCpu, tecnologiaRam, capacidadRam, tecnologiaDisco, capacidadDisco, numPuertosUSB, numPuertosHDMI, MarcaMonitor, pulgadas, precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, computador.getMarca());
            pstmt.setString(2, computador.getCategoria());
            pstmt.setString(3, computador.getMarcaCpu());
            pstmt.setString(4, computador.getVelocidadCpu());
            pstmt.setString(5, computador.getTecnologiaRam());
            pstmt.setString(6, computador.getCapacidadRam());
            pstmt.setString(7, computador.getTecnologiaDisco());
            pstmt.setString(8, computador.getCapacidadDisco());
            pstmt.setInt(9, computador.getNumPuertosUSB());
            pstmt.setInt(10, computador.getNumPuertosHDMI());
            pstmt.setString(11, computador.getMarcaMonitor());
            pstmt.setDouble(12, computador.getPulgadas());
            pstmt.setDouble(13, computador.getPrecio());
            pstmt.executeUpdate();
            System.out.println("Capa de Repositorios: Computador guardado en la base de datos.");
        } catch (SQLException e) {
            System.err.println("Capa de Repositorios: Error al guardar computador: " + e.getMessage());
        }
    }

    public List<Computador> obtenerTodosComputadores() {
        String sql = "SELECT id, marca, categoria, marcaCpu, velocidadCpu, tecnologiaRam, capacidadRam, tecnologiaDisco, capacidadDisco, numPuertosUSB, numPuertosHDMI, MarcaMonitor, pulgadas, precio FROM Computadores";
        List<Computador> computadores = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                computadores.add(new Computador(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("categoria"),
                        rs.getString("marcaCpu"),
                        rs.getString("velocidadCpu"),
                        rs.getString("tecnologiaRam"),
                        rs.getString("capacidadRam"),
                        rs.getString("tecnologiaDisco"),
                        rs.getString("capacidadDisco"),
                        rs.getInt("numPuertosUSB"),
                        rs.getInt("numPuertosHDMI"),
                        rs.getString("MarcaMonitor"),
                        rs.getDouble("pulgadas"),
                        rs.getDouble("precio")
                ));
            }
            System.out.println("Capa de Repositorios: Listado de computadores obtenido de la base de datos.");
        } catch (SQLException e) {
            System.err.println("Capa de Repositorios: Error al obtener todos los computadores: " + e.getMessage());
        }
        return computadores;
    }

    // Puedes agregar más métodos como obtener por ID, buscar por marca, etc.
}
