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
import com.sistema.model.Alumno;
import com.sistema.service.InterfaceServiceAlumno;

@RestController
@RequestMapping("/alumnos")
public class ControllerAlumno {
	
	@Autowired
	private InterfaceServiceAlumno ser;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Alumno>> listar(){
		List<Alumno> alumnos= new ArrayList<>();
		alumnos =ser.listar();
		return new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Alumno> listarId(@PathVariable("id") Integer id) {
		Alumno alu = ser.listarId(id);
		if(alu == null) {
			throw new ModeloNotFoundException("ID:" + id);	
		}
		
		return new ResponseEntity<Alumno>(alu, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar (@Valid @RequestBody Alumno alumno){
		Alumno alu = new Alumno();
		alu = ser.registrar(alumno);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alu.getIdAlumno()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody Alumno alumno){
		ser.modificar(alumno);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Alumno alu = ser.listarId(id);
		if(alu == null) {
			throw new ModeloNotFoundException("ID:" + id);
			
		}else {
			ser.eliminar(id);
		}
		
	}
}
