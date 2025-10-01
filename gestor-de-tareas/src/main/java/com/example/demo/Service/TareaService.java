package com.example.demo.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.EstadoEnum;
import com.example.demo.Entity.Tarea;

public interface TareaService {

    Tarea crearTarea(Tarea tarea);
    List<Tarea> obtenerTareas();
    Optional<Tarea> obtenerTareaPorId(int id);
    Tarea actualizarTarea(Tarea tarea);
    boolean eliminarTarea(int id);

    Tarea actualizarDatos(int id, String titulo, String descripcion, EstadoEnum estado, Date fechaLimite);
    void validarTarea(Tarea tarea);
} 