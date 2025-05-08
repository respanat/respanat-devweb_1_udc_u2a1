
package Models.Repositories;

import Models.Entities.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    private Connection getConnection() throws SQLException {
        // Detalles de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/act2_devweb?serverTimezone=America/Bogota";
        String user = "ramiro_espana";
        String password = "AbcdeUdeC";
        return DriverManager.getConnection(url, user, password);
    }

    public void guardarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (username, password, nombre, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getUsername());
            pstmt.setString(2, usuario.getPassword());
            pstmt.setString(3, usuario.getNombre());
            pstmt.setString(4, usuario.getEmail());
            pstmt.executeUpdate();
            System.out.println("Capa de Repositorios: Usuario guardado en la base de datos.");
        } catch (SQLException e) {
            System.err.println("Capa de Repositorios: Error al guardar usuario: " + e.getMessage());
        }
    }

    public Usuario obtenerUsuarioPorId(int id) {
        String sql = "SELECT id, username, password, nombre, email FROM Usuario WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nombre"), rs.getString("email"));
            }
        } catch (SQLException e) {
            System.err.println("Capa de Repositorios: Error al obtener usuario por ID: " + e.getMessage());
        }
        return null;
    }

    public List<Usuario> obtenerTodosUsuarios() {
        String sql = "SELECT id, username, password, nombre, email FROM Usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nombre"), rs.getString("email")));
            }
            System.out.println("Capa de Repositorios: Listado de usuarios obtenido de la base de datos.");
        } catch (SQLException e) {
            System.err.println("Capa de Repositorios: Error al obtener todos los usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    public Usuario obtenerUsuarioPorUsername(String username) {
        String sql = "SELECT id, username, password, nombre, email FROM Usuario WHERE username = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nombre"), rs.getString("email"));
            }
        } catch (SQLException e) {
            System.err.println("Capa de Repositorios: Error al obtener usuario por username: " + e.getMessage());
        }
        return null;
    }

    public Usuario autenticarUsuario(String username, String password) {
        String sql = "SELECT id, username, password, nombre, email FROM Usuario WHERE username = ? AND password = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nombre"), rs.getString("email"));
            }
        } catch (SQLException e) {
            System.err.println("Capa de Repositorios: Error al autenticar usuario: " + e.getMessage());
        }
        return null;
    }
}
	

