package com.sistema.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sistema.exception.ModeloNotFoundException;
import com.sistema.model.Matricula;
import com.sistema.service.InterfaceServiceMatricula;

@RestController
@RequestMapping("/matriculas")
public class ControllerMatricula {
	
	@Autowired
	private InterfaceServiceMatricula ser;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Matricula>> listar(){
		List<Matricula> matriculas= new ArrayList<>();
		matriculas =ser.listar();
		return new ResponseEntity<List<Matricula>>(matriculas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Matricula> listarId(@PathVariable("id") Integer id) {
		Matricula mat = ser.listarId(id);
		if(mat == null) {
			throw new ModeloNotFoundException("ID:" + id);	
		}
		
		return new ResponseEntity<Matricula>(mat, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar (@Valid @RequestBody Matricula Matricula){
		Matricula mat = new Matricula();
		mat = ser.registrar(Matricula);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mat.getIdMatricula()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody Matricula Matricula){
		ser.modificar(Matricula);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Matricula mat = ser.listarId(id);
		if(mat == null) {
			throw new ModeloNotFoundException("ID:" + id);
			
		}else {
			ser.eliminar(id);
		}
		
	}
}
