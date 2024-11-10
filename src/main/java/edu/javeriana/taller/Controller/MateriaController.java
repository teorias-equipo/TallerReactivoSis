package edu.javeriana.taller.Controller;

import edu.javeriana.taller.Model.Materia;
import edu.javeriana.taller.Service.MateriaService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public Flux<Materia> getAllMaterias() {
        return materiaService.getAllMaterias();
    }

    @GetMapping("/{id}")
    public Mono<Materia> getMateriaById(@PathVariable Integer id) {
        return materiaService.getMateriaById(id);
    }

    @PostMapping
    public Mono<Materia> createMateria(@RequestBody Materia materia) {
        return materiaService.createMateria(materia);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteMateria(@PathVariable Integer id) {
        return materiaService.deleteMateria(id);
    }
}

