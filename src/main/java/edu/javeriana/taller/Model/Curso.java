package edu.javeriana.taller.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table("curso")
public class Curso {

    @Id
    @Column("codigo")  // El ID del curso
    private Integer codigo;  // Cambié a Integer

    @Column("materia_id")  // Referencia a la materia del curso
    private Integer materiaId;

    @Column("profesor_id")  // Referencia al profesor del curso
    private Integer profesorId;

    @Column("fecha_inicio")  // Fecha de inicio del curso
    private LocalDate fechaInicio;

    @Column("fecha_fin")  // Fecha de fin del curso
    private LocalDate fechaFin;

    @Column("nombre") // Nombre del curso (de la materia asociada)
    private String nombre;

    // Getters y setters generados por Lombok


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
