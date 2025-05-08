// /act2_devweb/Controllers/UsuarioController.java
package Controllers;

import Models.Entities.Usuario;
import Models.Services.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios/*")
public class UsuarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioService usuarioService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Mensaje al inicializar el servlet de Usuario
        System.out.println("Servlet de Usuario inicializado en la capa de Controllers.");
        usuarioService = new UsuarioService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            // Acción por defecto o página principal de usuarios (si es necesario)
            response.getWriter().println("Acceso a la página principal de usuarios desde el Controller.");
        } else if (pathInfo.equals("/listar")) {
            listarUsuarios(request, response);
        } else if (pathInfo.equals("/agregar")) {
            mostrarFormularioAgregar(request, response);
        } else if (pathInfo.equals("/buscar")) {
            mostrarFormularioBuscar(request, response);
        } else if (pathInfo.equals("/login")) {
            mostrarFormularioLogin(request, response);
        } else if (pathInfo.equals("/logout")) {
            logoutUsuario(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo != null && pathInfo.equals("/agregar")) {
            agregarUsuario(request, response);
        } else if (pathInfo != null && pathInfo.equals("/login")) {
            loginUsuario(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Capa de Controllers: Solicitando listado de usuarios al Servicio.");
        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/Views/forms/usuarios/listar_todo.jsp").forward(request, response);
        System.out.println("Capa de Controllers: Redireccionando a la vista de listado de usuarios.");
    }

    private void mostrarFormularioAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Capa de Controllers: Redireccionando al formulario de agregar usuario.");
        request.getRequestDispatcher("/Views/forms/usuarios/agregar.jsp").forward(request, response);
    }

    private void agregarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Capa de Controllers: Recibiendo datos para agregar usuario.");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");

        Usuario usuario = new Usuario(null, username, password, nombre, email);
        usuarioService.guardarUsuario(usuario);
        System.out.println("Capa de Controllers: Usuario agregado. Redireccionando al listado.");
        response.sendRedirect(request.getContextPath() + "/usuarios/listar");
    }

    private void mostrarFormularioBuscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Capa de Controllers: Redireccionando al formulario de búsqueda de usuario.");
        request.getRequestDispatcher("/Views/forms/usuarios/buscar.jsp").forward(request, response);
    }

    private void mostrarFormularioLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Capa de Controllers: Redireccionando al formulario de login de usuario.");
        request.getRequestDispatcher("/Views/forms/usuarios/login.jsp").forward(request, response);
    }

    private void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Capa de Controllers: Recibiendo datos para el login de usuario.");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Usuario usuario = usuarioService.autenticarUsuario(username, password);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", usuario);
            System.out.println("Capa de Controllers: Usuario logueado correctamente. Redireccionando a la lista de computadores.");
            response.sendRedirect(request.getContextPath() + "/computadores/listar");
        } else {
            request.setAttribute("errorLogin", "Credenciales incorrectas.");
            System.out.println("Capa de Controllers: Fallo en el login. Redireccionando al formulario de login.");
            request.getRequestDispatcher("/Views/forms/usuarios/login.jsp").forward(request, response);
        }
    }

    private void logoutUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            System.out.println("Capa de Controllers: Sesión de usuario cerrada.");
        }
        response.sendRedirect(request.getContextPath() + "/usuarios/login");
    }
}
