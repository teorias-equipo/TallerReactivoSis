package edu.javeriana.taller.Service;

import edu.javeriana.taller.Model.Curso;
import edu.javeriana.taller.Repository.CursoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Flux<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Mono<Curso> getCursoById(String codigo) {
        return cursoRepository.findById(codigo);
    }

    public Mono<Curso> createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Mono<Void> deleteCurso(String codigo) {
        return cursoRepository.deleteById(codigo);
    }
}

