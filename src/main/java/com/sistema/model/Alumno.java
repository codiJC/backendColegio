package com.sistema.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumno")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlumno;
	
	@Size(min=2, message="Nombres debe tener minimo 2 caracteres")
	@Column(name = "nombres", nullable=false, length = 120)
	private String nombres;
	
	@Size(min=2, message="Apellidos debe tener minimo 2 caracteres")
	@Column(name = "apellidos", nullable=false, length = 120)
	private String apellidos;
	
	@Size(min=8, max=8, message="Apellido debe tener minimo 2 caracteres")
	@Column(name = "dni", nullable=false, length = 8)
	private String dni;
	
	@Size(min=2, max=254, message="Direccion debe tener minimo 2 caracteres")
	@Column(name = "direccion", nullable=false, length = 254)
	private String direccion;
	
	@Size(min=1, message="sexo debe tener minimo 1 caracteres")
	@Column(name = "sexo", nullable=false, length = 5)
	private String sexo;
	
	@Size(min=7, max = 9, message="telefono debe tener minimo 7 caracteres")
	@Column(name = "telefono", nullable=true, length = 11)
	private String telefono;
	
	@Size(min=1, max = 100,message="fechaNacimiento debe tener el formato la fecha AAAA/MM/DD HH:MM:SS")
	@Column(name = "fechaNacimiento", nullable=false)
	private String fechaNacimiento;
	
	@Size(min=1,max=1, message="estado debe tener minimo 1 caracteres: 1,0")
	@Column(name = "estado", nullable=false, length = 1)
	private String estado;
	
	@OneToMany(mappedBy = "alumno")
	private List<Matricula> matriculas;

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	

	

}
