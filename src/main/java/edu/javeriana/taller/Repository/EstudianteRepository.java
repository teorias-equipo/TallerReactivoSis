package edu.javeriana.taller.Repository;

import edu.javeriana.taller.Model.Estudiante;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EstudianteRepository extends ReactiveCrudRepository<Estudiante, Integer> {
}
