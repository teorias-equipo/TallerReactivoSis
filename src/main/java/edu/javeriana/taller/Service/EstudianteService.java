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

    // Obtener todos los estudiantes
    public Flux<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    // Obtener un estudiante por su ID
    public Mono<Estudiante> getEstudianteById(Integer id) {
        return estudianteRepository.findById(id);
    }

    // Crear un nuevo estudiante
    public Mono<Estudiante> createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // Eliminar un estudiante por ID
    public Mono<Void> deleteEstudiante(Integer id) {
        return estudianteRepository.deleteById(id);
    }

    // Obtener los estudiantes de un curso específico
    public Flux<Estudiante> getEstudiantesPorCurso(Integer cursoId) {
        // Aquí asumimos que en tu repositorio hay un método que obtiene los estudiantes por cursoId
        return estudianteRepository.findEstudiantesByCursoId(cursoId);
    }
}
