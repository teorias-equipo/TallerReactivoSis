package edu.javeriana.taller.Controller;

import edu.javeriana.taller.Service.CursoService;
import edu.javeriana.taller.Model.Curso;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public String getAllCursos(Model model) {
        // Realizamos la llamada al servicio y asignamos los cursos al modelo
        cursoService.getAllCursos()
                .collectList() // Convertimos el Flux a una lista
                .doOnTerminate(() -> {
                    // No es necesario hacer nada aquí en este caso
                })
                .subscribe(cursos -> model.addAttribute("cursos", cursos)); // Se asigna directamente cuando se recibe el resultado

        return "cursos"; // La vista que muestra la lista de cursos
    }
}
