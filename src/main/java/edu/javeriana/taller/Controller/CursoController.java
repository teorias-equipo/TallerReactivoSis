package edu.javeriana.taller.Controller;

import edu.javeriana.taller.Service.CursoService;
import edu.javeriana.taller.Model.Curso;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public Mono<String> getAllCursos(Model model) {
        return cursoService.getAllCursos()
                .collectList()  // Convertimos Flux a una lista
                .doOnTerminate(() -> {
                    // Aquí no es necesario hacer nada extra en este caso
                })
                .doOnSuccess(cursos -> {
                    if (cursos == null || cursos.isEmpty()) {
                        model.addAttribute("message", "No se encontraron cursos.");
                    } else {
                        model.addAttribute("cursos", cursos);  // Se pasan los cursos al modelo
                    }
                })
                .then(Mono.just("cursos"));  // Devuelve el nombre de la vista
    }
}
