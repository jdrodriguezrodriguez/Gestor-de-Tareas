package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Integer>{
    
} 
