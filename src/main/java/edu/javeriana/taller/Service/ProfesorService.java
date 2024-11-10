package edu.javeriana.taller.Service;

import edu.javeriana.taller.Model.Profesor;
import edu.javeriana.taller.Repository.ProfesorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public Flux<Profesor> getAllProfesores() {
        return profesorRepository.findAll();
    }

    public Mono<Profesor> getProfesorById(Integer id) {
        return profesorRepository.findById(id);
    }

    public Mono<Profesor> createProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public Mono<Void> deleteProfesor(Integer id) {
        return profesorRepository.deleteById(id);
    }
}

