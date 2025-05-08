// /act2_devweb/Controllers/ComputadorController.java
package Controllers;

import Models.Entities.Computador;
import Models.Entities.Usuario;
import Models.Services.ComputadorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/computadores/*")
public class ComputadorController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ComputadorService computadorService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Mensaje al inicializar el servlet de Computador
        System.out.println("Servlet de Computador inicializado en la capa de Controllers.");
        computadorService = new ComputadorService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        HttpSession session = request.getSession(false);
        Usuario usuarioLogueado = (session != null) ? (Usuario) session.getAttribute("usuarioLogueado") : null;

        if (usuarioLogueado == null) {
            System.out.println("Capa de Controllers: Usuario no logueado. Redireccionando al login.");
            response.sendRedirect(request.getContextPath() + "/usuarios/login");
            return;
        }

        if (pathInfo == null || pathInfo.equals("/")) {
            response.getWriter().println("Acceso a la página principal de computadores desde el Controller.");
        } else if (pathInfo.equals("/listar")) {
            listarComputadores(request, response);
        } else if (pathInfo.equals("/agregar")) {
            mostrarFormularioAgregar(request, response);
        } else if (pathInfo.equals("/buscar")) {
            mostrarFormularioBuscar(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        HttpSession session = request.getSession(false);
        Usuario usuarioLogueado = (session != null) ? (Usuario) session.getAttribute("usuarioLogueado") : null;

        if (usuarioLogueado == null) {
            System.out.println("Capa de Controllers: Usuario no logueado. Redireccionando al login.");
            response.sendRedirect(request.getContextPath() + "/usuarios/login");
            return;
        }

        if (pathInfo != null && pathInfo.equals("/agregar")) {
            agregarComputador(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void listarComputadores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Capa de Controllers: Solicitando listado de computadores al Servicio.");
        List<Computador> computadores = computadorService.obtenerTodosComputadores();
        request.setAttribute("computadores", computadores);
        request.getRequestDispatcher("/Views/forms/computadores/listar_todo.jsp").forward(request, response);
        System.out.println("Capa de Controllers: Redireccionando a la vista de listado de computadores.");
    }

    private void mostrarFormularioAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Capa de Controllers: Redireccionando al formulario de agregar computador.");
        request.getRequestDispatcher("/Views/forms/computadores/agregar.jsp").forward(request, response);
    }

    private void agregarComputador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Capa de Controllers: Recibiendo datos para agregar computador.");
        String marca = request.getParameter("marca");
        String categoria = request.getParameter("categoria");
        String marcaCpu = request.getParameter("marcaCpu");
        String velocidadCpu = request.getParameter("velocidadCpu");
        String tecnologiaRam = request.getParameter("tecnologiaRam");
        String capacidadRam = request.getParameter("capacidadRam");
        String tecnologiaDisco = request.getParameter("tecnologiaDisco");
        String capacidadDisco = request.getParameter("capacidadDisco");
        String numPuertosUSB = request.getParameter("numPuertosUSB");
        String numPuertosHDMI = request.getParameter("numPuertosHDMI");
        String marcaMonitor = request.getParameter("marcaMonitor");
        String pulgadas = request.getParameter("pulgadas");
        String precio = request.getParameter("precio");

        Computador computador = new Computador(null, marca, categoria, marcaCpu, velocidadCpu, tecnologiaRam, capacidadRam, tecnologiaDisco, capacidadDisco, Integer.parseInt(numPuertosUSB), Integer.parseInt(numPuertosHDMI), marcaMonitor, Double.parseDouble(pulgadas), Double.parseDouble(precio));
        computadorService.guardarComputador(computador);
        System.out.println("Capa de Controllers: Computador agregado. Redireccionando al listado.");
        response.sendRedirect(request.getContextPath() + "/computadores/listar");
    }

    private void mostrarFormularioBuscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Capa de Controllers: Redireccionando al formulario de búsqueda de computador.");
        request.getRequestDispatcher("/Views/forms/computadores/buscar.jsp").forward(request, response);
    }
}
