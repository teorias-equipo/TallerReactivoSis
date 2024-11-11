package edu.javeriana.taller.Service;

import edu.javeriana.taller.Model.Curso;
import edu.javeriana.taller.Model.Materia;  // Asegúrate de tener este modelo
import edu.javeriana.taller.Repository.CursoRepository;
import edu.javeriana.taller.Repository.MateriaRepository;  // Añadimos el repositorio de Materia
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final MateriaRepository materiaRepository; // Repositorio para Materia

    public CursoService(CursoRepository cursoRepository, MateriaRepository materiaRepository) {
        this.cursoRepository = cursoRepository;
        this.materiaRepository = materiaRepository;
    }

    // Obtener todos los cursos
    public Flux<Curso> getAllCursos() {
        return cursoRepository.findAll()
                .flatMap(curso -> {
                    // Obtener el nombre de la materia asociada al curso
                    return materiaRepository.findById(curso.getMateriaId())
                            .flatMap(materia -> {
                                curso.setNombre(materia.getNombre()); // Asignamos el nombre de la materia al curso
                                return Mono.just(curso);
                            });
                });
    }


    // Crear un nuevo curso
    public Mono<Curso> createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Mono<Curso> getCursoById(Integer codigo) {
        if (codigo == null) {
            return Mono.error(new IllegalArgumentException("El código del curso no puede ser nulo"));
        }
        // Aquí estamos pasando el Integer al repositorio
        return cursoRepository.findById(codigo);
    }


    public Mono<Void> deleteCurso(Integer codigo) {
        return cursoRepository.deleteById(codigo);  // Ahora con Integer
    }




}
