package com.sistema.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.dao.InterfaceMatricula;
import com.sistema.model.Matricula;
import com.sistema.service.InterfaceServiceMatricula;

@Service
public class ImpServiceMatricula implements InterfaceServiceMatricula{
	
	@Autowired
	private InterfaceMatricula dao;

	@Override
	public Matricula registrar(Matricula t) {
		return dao.save(t);
	}

	@Override
	public Matricula modificar(Matricula t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.delete(id);
	}

	@Override
	public Matricula listarId(int id) {
		return dao.findOne(id);
	}

	@Override
	public List<Matricula> listar() {
		return dao.findAll();
	}

}
