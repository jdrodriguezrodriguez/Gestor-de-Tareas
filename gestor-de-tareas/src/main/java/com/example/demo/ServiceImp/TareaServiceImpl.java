package com.example.demo.ServiceImp;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.EstadoEnum;
import com.example.demo.Entity.Tarea;
import com.example.demo.Repository.TareaRepository;
import com.example.demo.Service.TareaService;

@Service
public class TareaServiceImpl implements TareaService{
    
    private TareaRepository tareaRepository;

    public TareaServiceImpl(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public Tarea crearTarea(Tarea tarea) {
        validarTarea(tarea);
        return tareaRepository.save(tarea);
    }

    @Override
    public List<Tarea> obtenerTareas(){
        return tareaRepository.findAll();
    }

    @Override
    public Optional<Tarea> obtenerTareaPorId(int id){
        return tareaRepository.findById(id);
    }

    @Override
    public Tarea actualizarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public boolean eliminarTarea(int id){
        return obtenerTareaPorId(id).map(t ->{
            tareaRepository.deleteById(t.getTareaId());
            return true;
        })
        .orElse(false);
    }   

    @Override
    public Tarea actualizarDatos(int id, String titulo, String descripcion, EstadoEnum estado, Date fechaLimite){
        return obtenerTareaPorId(id).map(tarea ->{
            validarTarea(tarea);

            tarea.setTitulo(titulo);
            tarea.setDescripcion(descripcion);
            tarea.setEstadoEnum(estado);
            tarea.setFechaLimite(fechaLimite);

            return actualizarTarea(tarea);
        }).orElseThrow(() -> new IllegalArgumentException("La tarea no existe"));
    }

    @Override
    public void validarTarea(Tarea tarea){
        tareaRepository.findByTitulo(tarea.getTitulo().trim().toLowerCase()).ifPresent(t ->{
            if (!t.getTareaId().equals(tarea.getTareaId())) {
                throw new IllegalArgumentException("Tarea ya asignada");
            }
        });
    }
}
