package edu.javeriana.taller.Service;

import edu.javeriana.taller.Model.Nota;
import edu.javeriana.taller.Repository.NotaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public Flux<Nota> getAllNotas() {
        return notaRepository.findAll();
    }

    public Mono<Nota> getNotaById(Integer id) {
        return notaRepository.findById(id);
    }

    public Mono<Nota> createNota(Nota nota) {
        // Aquí agregamos la validación del porcentaje
        return notaRepository.findAll()
                .filter(n -> n.getCursoCodigo().equals(nota.getCursoCodigo()) &&
                        n.getEstudianteId().equals(nota.getEstudianteId()))
                .map(Nota::getPorcentaje)
                .reduce(0.0, Double::sum)
                .flatMap(totalPorcentaje -> {
                    if (totalPorcentaje + nota.getPorcentaje() > 100) {
                        return Mono.error(new RuntimeException("El porcentaje acumulado supera el 100%"));
                    }
                    return notaRepository.save(nota);
                });
    }

    public Mono<Void> deleteNota(Integer id) {
        return notaRepository.deleteById(id);
    }
}

