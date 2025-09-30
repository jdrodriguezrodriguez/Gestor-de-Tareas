package com.example.demo.ServiceImp;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Tarea;
import com.example.demo.Repository.TareaRepository;
import com.example.demo.Service.TareaService;

@Service
public class TareaServiceImp implements TareaService{
    
    private TareaRepository tareaRepository;

    public TareaServiceImp(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public List<Tarea> obtenerTareas(){
        return tareaRepository.findAll();
    }

    @Override
    public Tarea obtenerTareaPorId(int id){
        return tareaRepository.findById(id).orElse(null);
    }

    @Override
    public Tarea actualizarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Void eliminarTarea(int id){
        Tarea tarea = obtenerTareaPorId(id);

        if (tarea != null) {
            tareaRepository.deleteById(tarea.getTareaId());
        }
        return null;
    }

    @Override
    public Tarea actualizarDatos(int id, String titulo, String descripcion, String estado, Date fechaLimite){
        Tarea tareaExistente = obtenerTareaPorId(id);

        if (tareaExistente != null) {
            
            tareaExistente.setTitulo(titulo);
            tareaExistente.setDescripcion(descripcion);
            tareaExistente.setEstado(estado);
            tareaExistente.setFechaLimite(fechaLimite);

            return actualizarTarea(tareaExistente);
        }
        return null;
    }
}
