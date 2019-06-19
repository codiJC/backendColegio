package com.sistema.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.dao.InterfaceAlumno;
import com.sistema.model.Alumno;
import com.sistema.service.InterfaceServiceAlumno;

@Service
public class ImpServiceAlumno implements InterfaceServiceAlumno{
	
	@Autowired
	private InterfaceAlumno dao;

	@Override
	public Alumno registrar(Alumno t) {
		return dao.save(t);
	}

	@Override
	public Alumno modificar(Alumno t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.delete(id);
		
	}

	@Override
	public Alumno listarId(int id) {
		return dao.findOne(id);
	}

	@Override
	public List<Alumno> listar() {
		return dao.findAll();
	}

}
