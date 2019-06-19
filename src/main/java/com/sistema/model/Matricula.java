package com.sistema.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "matricula")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMatricula;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_alumno", nullable = false)
	private Alumno alumno;
	
	@Size(min=1,max=1, message="partidaNacimiento debe tener minimo 1 caracteres")
	@Column(name = "partidaNacimiento", nullable=false )
	private String partidaNacimiento;
	
	@Size(min=1,max=1, message="grado debe tener minimo 1 caracteres: 1,2,3,4,5,6")
	@Column(name = "grado", nullable= false, length=1)
	private String grado;
	
	@Size(min=1,max=1, message="Seccion debe tener minimo 1 caracteres: a,b,c")
	@Column(name = "Seccion", nullable=false, length=1)
	private String Seccion;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaRegistro;
	
	@Size(min=1,max=1, message="estado debe tener minimo 1 caracteres: 1,0")
	@Column(name = "estado", nullable= false, length=1)
	private String estado;

	public Integer getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String getPartidaNacimiento() {
		return partidaNacimiento;
	}

	public void setPartidaNacimiento(String partidaNacimiento) {
		this.partidaNacimiento = partidaNacimiento;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getSeccion() {
		return Seccion;
	}

	public void setSeccion(String seccion) {
		Seccion = seccion;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
