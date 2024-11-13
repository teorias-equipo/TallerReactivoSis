package edu.javeriana.taller.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Mono<String> handleException(Exception e, Model model) {
        model.addAttribute("error", "Ocurrió un error inesperado: " + e.getMessage());
        return Mono.just("error");
    }
}
