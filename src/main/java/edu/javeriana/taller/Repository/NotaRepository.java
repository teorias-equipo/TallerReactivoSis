package edu.javeriana.taller.Repository;

import edu.javeriana.taller.Model.Nota;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends ReactiveCrudRepository<Nota, Integer> {
}