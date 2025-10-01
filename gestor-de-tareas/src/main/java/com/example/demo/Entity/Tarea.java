package com.example.demo.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "tareas")
public class Tarea{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarea_id")
    private Integer tareaId;
    
    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "La descripción no puede estar vacía")
	private String descripcion;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
	private EstadoEnum estadoEnum;
    
    @Column(name = "fecha_limite")
	private Date fechaLimite;
}