package edu.javeriana.taller.Controller;

import edu.javeriana.taller.Model.Nota;
import edu.javeriana.taller.Service.NotaService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping
    public Flux<Nota> getAllNotas() {
        return notaService.getAllNotas();
    }

    @GetMapping("/{id}")
    public Mono<Nota> getNotaById(@PathVariable Integer id) {
        return notaService.getNotaById(id);
    }

    @PostMapping
    public Mono<Nota> createNota(@RequestBody Nota nota) {
        return notaService.createNota(nota);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteNota(@PathVariable Integer id) {
        return notaService.deleteNota(id);
    }
}
