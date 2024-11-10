package edu.javeriana.taller.Controller;

import edu.javeriana.taller.Model.Profesor;
import edu.javeriana.taller.Service.ProfesorService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public Flux<Profesor> getAllProfesores() {
        return profesorService.getAllProfesores();
    }

    @GetMapping("/{id}")
    public Mono<Profesor> getProfesorById(@PathVariable Integer id) {
        return profesorService.getProfesorById(id);
    }

    @PostMapping
    public Mono<Profesor> createProfesor(@RequestBody Profesor profesor) {
        return profesorService.createProfesor(profesor);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProfesor(@PathVariable Integer id) {
        return profesorService.deleteProfesor(id);
    }
}
