package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Tarea;

public interface TareaService {

    Tarea crearTarea(Tarea tarea);
    List<Tarea> obtenerTareas();
    Tarea obtenerTareaPorId(int id);
} 