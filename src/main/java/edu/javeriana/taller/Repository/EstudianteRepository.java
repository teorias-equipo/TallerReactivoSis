package edu.javeriana.taller.Repository;

import edu.javeriana.taller.Model.Estudiante;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends ReactiveCrudRepository<Estudiante, Integer> {
}
