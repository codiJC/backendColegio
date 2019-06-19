package com.sistema.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.model.Alumno;

public interface InterfaceAlumno extends JpaRepository<Alumno, Integer>{

}
