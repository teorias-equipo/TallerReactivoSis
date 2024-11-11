package edu.javeriana.taller.Repository;

import edu.javeriana.taller.Model.Curso;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends ReactiveCrudRepository<Curso, Integer> {
}

