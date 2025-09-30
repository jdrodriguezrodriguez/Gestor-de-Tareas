package com.example.demo.Service;

import java.sql.Date;
import java.util.List;

import com.example.demo.Entity.Tarea;

public interface TareaService {

    Tarea crearTarea(Tarea tarea);
    List<Tarea> obtenerTareas();
    Tarea obtenerTareaPorId(int id);
    Tarea actualizarTarea(Tarea tarea);
    Void eliminarTarea(int id);

    Tarea actualizarDatos(int id, String titulo, String descripcion, String estado, Date fechaLimite);
} 