package edu.javeriana.taller.Repository;

import edu.javeriana.taller.Model.Profesor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends ReactiveCrudRepository<Profesor, Integer> {
}
