package Models.Services;

import Models.Entities.Computador;
import Models.Repositories.ComputadorRepository;
import java.util.List;

public class ComputadorService {
    private ComputadorRepository computadorRepository;

    public ComputadorService() {
        this.computadorRepository = new ComputadorRepository();
        System.out.println("Capa de Servicios: Servicio de Computador inicializado.");
    }

    public void guardarComputador(Computador computador) {
        // Aquí puedes agregar lógica de negocio antes de guardar, como validaciones.
        computadorRepository.guardarComputador(computador);
        System.out.println("Capa de Servicios: Solicitando guardar computador al Repositorio.");
    }

    public List<Computador> obtenerTodosComputadores() {
        System.out.println("Capa de Servicios: Solicitando todos los computadores al Repositorio.");
        return computadorRepository.obtenerTodosComputadores();
    }

    // Puedes agregar más métodos para la lógica de negocio relacionada con computadores
}
