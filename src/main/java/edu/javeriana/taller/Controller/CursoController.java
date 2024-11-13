package edu.javeriana.taller.Controller;

import edu.javeriana.taller.Service.CursoService;
import edu.javeriana.taller.Service.EstudianteService;  // Asegúrate de tener un servicio para obtener estudiantes
import edu.javeriana.taller.Model.Curso;
import edu.javeriana.taller.Model.Estudiante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;
    private final EstudianteService estudianteService;

    public CursoController(CursoService cursoService, EstudianteService estudianteService) {
        this.cursoService = cursoService;
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public Mono<String> getAllCursos(Model model) {
        return cursoService.getAllCursos()
                .collectList()
                .doOnTerminate(() -> {
                    // No es necesario hacer nada aquí
                })
                .doOnSuccess(cursos -> model.addAttribute("cursos", cursos)) // Asignamos los cursos al modelo
                .then(Mono.just("cursos")) // Devuelve el nombre de la vista
                .onErrorResume(error -> {
                    model.addAttribute("error", "Ocurrió un error al cargar los cursos.");
                    return Mono.just("error"); // Redirige a una página de error
                });
    }

    @GetMapping("/{codigo}/estudiantes")
    public Mono<String> getEstudiantes(@PathVariable Integer codigo, Model model) {
        return estudianteService.getEstudiantesPorCurso(codigo)
                .collectList() // Convierte Flux a una lista de estudiantes
                .doOnTerminate(() -> {
                    // No es necesario hacer nada aquí
                })
                .doOnSuccess(estudiantes -> model.addAttribute("estudiantes", estudiantes)) // Asigna los estudiantes al modelo
                .then(Mono.just("estudiantes")) // Devuelve el nombre de la vista para mostrar estudiantes
                .onErrorResume(error -> {
                    model.addAttribute("error", "Ocurrió un error al cargar los estudiantes.");
                    return Mono.just("error"); // Redirige a una página de error
                });
    }
}
