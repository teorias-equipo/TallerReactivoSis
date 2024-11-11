package edu.javeriana.taller.Repository;

import edu.javeriana.taller.Model.Estudiante;
import edu.javeriana.taller.Model.Nota;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface NotaRepository extends ReactiveCrudRepository<Nota, Integer> {

    // Método que obtiene todos los estudiantes de un curso por su código
    Flux<Estudiante> findEstudiantesByCursoCodigo(String cursoCodigo);
}
