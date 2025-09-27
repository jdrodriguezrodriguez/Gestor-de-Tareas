package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Tarea;
import com.example.demo.Service.TareaService;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    
    private TareaService tareaService;
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }


    public List<Tarea> listarTareas(){
        return tareaService.obtenerTareas();
    }

    @PostMapping
    public Tarea RegistrarTarea(@RequestBody Tarea tarea){
        return tareaService.crearTarea(tarea);
    }

    @GetMapping("/{tareaId}")
    public @ResponseBody Tarea obtenerTareaPorId(@PathVariable int tareaId){
        return tareaService.obtenerTareaPorId(tareaId);
    }
}
