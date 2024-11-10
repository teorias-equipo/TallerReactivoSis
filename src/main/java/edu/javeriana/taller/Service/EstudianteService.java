package edu.javeriana.taller.Service;

import edu.javeriana.taller.Model.Estudiante;
import edu.javeriana.taller.Repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Flux<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Mono<Estudiante> getEstudianteById(Integer id) {
        return estudianteRepository.findById(id);
    }

    public Mono<Estudiante> createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Mono<Void> deleteEstudiante(Integer id) {
        return estudianteRepository.deleteById(id);
    }
}

