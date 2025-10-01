package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/prueba")
    public String home() {
        return "API de tareas corriendo";
    }

    @GetMapping
    public ResponseEntity<?> listarTareas(){
        return ResponseEntity.ok(tareaService.obtenerTareas());
    }

    @PostMapping
    public ResponseEntity<?> RegistrarTarea(@RequestBody Tarea tarea){
        try {

            tareaService.crearTarea(tarea);
            return ResponseEntity.ok(Map.of("Mensaje", "Tarea creada correctamente"));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{tareaId}")
    public ResponseEntity<?> obtenerTareaPorId(@PathVariable int tareaId){
        try {
            return tareaService.obtenerTareaPorId(tareaId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error:" + e.getMessage());
        }
    }

    @PutMapping("/{tareaId}")
    public ResponseEntity<?> ActualizarTarea(@PathVariable int tareaId, @RequestBody Tarea tarea){
        try{
            tareaService.actualizarDatos(tareaId, tarea.getTitulo(), tarea.getDescripcion(), tarea.getEstadoEnum(), tarea.getFechaLimite());
            return ResponseEntity.ok(Map.of("Mensaje", "Tarea actualizada"));

        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{tareaId}")
    public ResponseEntity<?> EliminarTarea(@PathVariable int tareaId){
        try{
            tareaService.eliminarTarea(tareaId);
            return ResponseEntity.ok(Map.of("Mensaje", "Tarea eliminada"));

        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }
}
