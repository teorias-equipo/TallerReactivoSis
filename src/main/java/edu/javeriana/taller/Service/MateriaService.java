package edu.javeriana.taller.Service;

import edu.javeriana.taller.Model.Materia;
import edu.javeriana.taller.Repository.MateriaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MateriaService {

    private final MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public Flux<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    public Mono<Materia> getMateriaById(Integer id) {
        return materiaRepository.findById(id);
    }

    public Mono<Materia> createMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    public Mono<Void> deleteMateria(Integer id) {
        return materiaRepository.deleteById(id);
    }
}

