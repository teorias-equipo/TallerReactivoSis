package edu.javeriana.taller.Controller;

import edu.javeriana.taller.Model.Curso;
import edu.javeriana.taller.Service.CursoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public Flux<Curso> getAllCursos() {
        return cursoService.getAllCursos();
    }

    @GetMapping("/{codigo}")
    public Mono<Curso> getCursoById(@PathVariable String codigo) {
        return cursoService.getCursoById(codigo);
    }

    @PostMapping
    public Mono<Curso> createCurso(@RequestBody Curso curso) {
        return cursoService.createCurso(curso);
    }

    @DeleteMapping("/{codigo}")
    public Mono<Void> deleteCurso(@PathVariable String codigo) {
        return cursoService.deleteCurso(codigo);
    }
}
