package com.example.demo.ServiceImp;

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
}
