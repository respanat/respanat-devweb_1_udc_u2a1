package Models.Services;

import Models.Entities.Usuario;
import Models.Repositories.UsuarioRepository;
import java.util.List;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
        System.out.println("Capa de Servicios: Servicio de Usuario inicializado.");
    }

    public void guardarUsuario(Usuario usuario) {
        // Aquí puedes agregar lógica de negocio antes de guardar, como validaciones.
        usuarioRepository.guardarUsuario(usuario);
        System.out.println("Capa de Servicios: Solicitando guardar usuario al Repositorio.");
    }

    public Usuario obtenerUsuarioPorId(int id) {
        System.out.println("Capa de Servicios: Solicitando usuario por ID al Repositorio.");
        return usuarioRepository.obtenerUsuarioPorId(id);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        System.out.println("Capa de Servicios: Solicitando todos los usuarios al Repositorio.");
        return usuarioRepository.obtenerTodosUsuarios();
    }

    public Usuario autenticarUsuario(String username, String password) {
        System.out.println("Capa de Servicios: Solicitando autenticación de usuario al Repositorio.");
        return usuarioRepository.autenticarUsuario(username, password);
    }

    // Puedes agregar más métodos para la lógica de negocio relacionada con usuarios
}
