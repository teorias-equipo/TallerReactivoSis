package edu.javeriana.taller.Repository;

import edu.javeriana.taller.Model.Materia;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends ReactiveCrudRepository<Materia, Integer> {
}
