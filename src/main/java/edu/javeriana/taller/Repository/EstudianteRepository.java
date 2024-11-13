package edu.javeriana.taller.Repository;

import edu.javeriana.taller.Model.Estudiante;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EstudianteRepository extends ReactiveCrudRepository<Estudiante, Integer> {

    // Método para obtener los estudiantes asociados a un curso
    @Query("SELECT * FROM estudiante e " +
            "JOIN curso_estudiante ce ON e.id = ce.estudiante_id " +
            "WHERE ce.curso_id = :cursoId")
    Flux<Estudiante> findEstudiantesByCursoId(Integer cursoId);
}
