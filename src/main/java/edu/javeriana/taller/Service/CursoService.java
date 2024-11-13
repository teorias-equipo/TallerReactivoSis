package edu.javeriana.taller.Service;

import edu.javeriana.taller.Model.Curso;
import edu.javeriana.taller.Model.Profesor;
import edu.javeriana.taller.Repository.CursoRepository;
import edu.javeriana.taller.Repository.ProfesorRepository;
import edu.javeriana.taller.Repository.CursoProfesorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final ProfesorRepository profesorRepository;
    private final CursoProfesorRepository cursoProfesorRepository;

    public CursoService(CursoRepository cursoRepository, ProfesorRepository profesorRepository, CursoProfesorRepository cursoProfesorRepository) {
        this.cursoRepository = cursoRepository;
        this.profesorRepository = profesorRepository;
        this.cursoProfesorRepository = cursoProfesorRepository;
    }

    public Flux<Curso> getAllCursos() {
        return cursoRepository.findAll()
                .flatMap(curso -> cursoProfesorRepository.findByCursoId(curso.getCodigo())  // Usa getCodigo() en lugar de getId()
                        .flatMap(cursoProfesor -> profesorRepository.findById(cursoProfesor.getProfesorId())
                                .map(profesor -> {
                                    curso.setProfesor(profesor);
                                    return curso;
                                }))
                        .defaultIfEmpty(curso) // Si no hay profesor, devuelve el curso sin profesor
                );
    }

}
