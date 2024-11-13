package edu.javeriana.taller.Service;

import edu.javeriana.taller.Model.Curso;
import edu.javeriana.taller.Repository.CursoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Método para obtener todos los cursos
    public Flux<Curso> getAllCursos() {
        return cursoRepository.findAll();  // Esto devuelve un Flux<Curso> con todos los cursos de la base de datos
    }
}
