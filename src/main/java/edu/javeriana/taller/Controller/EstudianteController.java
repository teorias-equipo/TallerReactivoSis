package edu.javeriana.taller.Controller;

import edu.javeriana.taller.Model.Estudiante;
import edu.javeriana.taller.Service.EstudianteService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public Flux<Estudiante> getAllEstudiantes() {
        return estudianteService.getAllEstudiantes();
    }

    @GetMapping("/{id}")
    public Mono<Estudiante> getEstudianteById(@PathVariable Integer id) {
        return estudianteService.getEstudianteById(id);
    }

    @PostMapping
    public Mono<Estudiante> createEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.createEstudiante(estudiante);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteEstudiante(@PathVariable Integer id) {
        return estudianteService.deleteEstudiante(id);
    }
}

