package edu.javeriana.taller.Repository;

import edu.javeriana.taller.Model.CursoProfesor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CursoProfesorRepository extends ReactiveCrudRepository<CursoProfesor, Integer> {
    Mono<CursoProfesor> findByCursoId(Integer cursoId);
}
