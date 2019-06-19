package com.sistema.service;

import java.util.List;

public interface InterfaceCRUD<T> {
	
	T registrar (T t);
	T modificar (T t);
	void eliminar (int id);
	T listarId (int id);
	List<T> listar();
}
