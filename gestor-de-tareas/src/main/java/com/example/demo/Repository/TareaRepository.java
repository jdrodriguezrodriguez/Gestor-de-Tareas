package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Integer>{
    Optional<Tarea> findByTitulo (String titulo);
} 
